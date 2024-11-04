package com.devsuperior.dsmovie.controllers;

import org.json.JSONException;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class MovieControllerRA {

	private static final String BASE_URI = "http://localhost:8080";
	private static final String MOVIE_ENDPOINT = "/movies";


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

	}

	@Test
	public void insertShouldReturnUnprocessableEntityWhenAdminLoggedAndBlankTitle() throws JSONException {		
	}
	
	@Test
	public void insertShouldReturnForbiddenWhenClientLogged() throws Exception {
	}
	
	@Test
	public void insertShouldReturnUnauthorizedWhenInvalidToken() throws Exception {
	}
}
