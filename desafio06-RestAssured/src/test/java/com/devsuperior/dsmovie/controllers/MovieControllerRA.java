package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.tests.TokenUtil;
import io.restassured.http.ContentType;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MovieControllerRA {

	private static final String BASE_URI = "http://localhost:8080";
	private static final String MOVIE_ENDPOINT = "/movies";

	private static final String CLIENT_USERNAME = "alex@gmail.com";
	private static final String CLIENT_PASSWORD = "123456";
	private static final String ADMIN_USERNAME = "maria@gmail.com";
	private static final String ADMIN_PASSWORD = "123456";

	private String adminToken, clientToken, invalidToken;

	private Map<String, Object> postMovieInstance;

	@BeforeEach
	public void setup() throws Exception {

		clientToken = TokenUtil.obtainAccessToken(CLIENT_USERNAME, CLIENT_PASSWORD);
		adminToken = TokenUtil.obtainAccessToken(ADMIN_USERNAME, ADMIN_PASSWORD);
		invalidToken = adminToken + "xpto";


		postMovieInstance = createMovieInstance("The Witcher", 2, 4.5, "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg");
	}

	private Map<String, Object> createMovieInstance(String title, int count, double score, String imageUrl) {
		Map<String, Object> movieInstance = new HashMap<>();
		movieInstance.put("title", title);
		movieInstance.put("count", count);
		movieInstance.put("score", score);
		movieInstance.put("image", imageUrl);

		List<Map<String, Object>> scores = Arrays.asList(
				Collections.singletonMap("id", 2),
				Collections.singletonMap("id", 3)
		);

		movieInstance.put("scores", scores);
		return movieInstance;
	}



	@Test
	public void findAllShouldReturnOkWhenMovieNoArgumentsGiven() {
		given()
				.baseUri(BASE_URI)
				.queryParam("title", "The Witcher")
				.when()
				.get(MOVIE_ENDPOINT)
				.then()
				.statusCode(200)
				.body("content.id[0]", is(1))
				.body("content.title[0]", equalTo("The Witcher"));
	}

	@Test
	public void findAllShouldReturnPagedMoviesWhenMovieTitleParamIsNotEmpty() {
		given()
				.baseUri(BASE_URI)
				.queryParam("title", "The Witcher")
				.when()
				.get(MOVIE_ENDPOINT)
				.then()
				.statusCode(200)
				.body("content.id[0]", is(1))
				.body("content.title[0]", equalTo("The Witcher"));

	}

	@Test
	public void findByIdShouldReturnMovieWhenIdExists() {
		given()
				.baseUri(BASE_URI)
				.pathParam("id", 1)
				.when()
				.get(MOVIE_ENDPOINT + "/{id}")
				.then()
				.statusCode(200)
				.body("id", is(1))
				.body("title", equalTo("The Witcher"));


	}

	@Test
	public void findByIdShouldReturnNotFoundWhenIdDoesNotExist() {
		given()
				.baseUri(BASE_URI)
				.pathParam("id", 1000)
				.when()
				.get(MOVIE_ENDPOINT + "/{id}")
				.then()
				.statusCode(404);

	}

	@Test
	public void insertShouldReturnUnprocessableEntityWhenAdminLoggedAndBlankTitle() throws JSONException {

		Map<String, Object> newMovie = createMovieInstance("O Início do Fim", 3, 4.5, "https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg");

		given()
				.baseUri(BASE_URI)
				.header("Authorization", "Bearer " + adminToken)
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(newMovie)
				.when()
				.post(MOVIE_ENDPOINT)
				.then()
				.statusCode(201)
				.body("title", equalTo("O Início do Fim"))
				.body("count", is(3))
				.body("image", equalTo("https://www.themoviedb.org/t/p/w533_and_h300_bestv2/jBJWaqoSCiARWtfV0GlqHrcdidd.jpg"))
				.log().all();

	}



	@Test
	public void insertShouldReturnForbiddenWhenClientLogged() throws Exception {

	}
	
	@Test
	public void insertShouldReturnUnauthorizedWhenInvalidToken() throws Exception {

	}
}
