package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.tests.TokenUtil;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ScoreControllerRA {

	private static final String BASE_URI = "http://localhost:8080";
	private static final String SCORE_ENDPOINT = "/scores";
	private static final String CLIENT_USERNAME = "alex@gmail.com";
	private static final String CLIENT_PASSWORD = "123456";
	private static final String ADMIN_USERNAME = "maria@gmail.com";
	private static final String ADMIN_PASSWORD = "123456";

	private String adminToken;
	private String clientToken;
	private String invalidToken;

	@BeforeEach
	public void setup() throws Exception {
		clientToken = TokenUtil.obtainAccessToken(CLIENT_USERNAME, CLIENT_PASSWORD);
		adminToken = TokenUtil.obtainAccessToken(ADMIN_USERNAME, ADMIN_PASSWORD);
		invalidToken = adminToken + "tpto";
	}

	@Test
	public void saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist() {
		long nonExistentMovieId = 9999L;
		double score = 4.5;

		given()
				.baseUri(BASE_URI)
				.header("Authorization", "Bearer " + clientToken)
				.contentType(ContentType.JSON)
				.body(createScorePayload(nonExistentMovieId, score))
				.when()
				.post(SCORE_ENDPOINT)
				.then()
				.statusCode(404);

	}


	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId() throws Exception {
		double score = 4.5;

		given()
				.baseUri(BASE_URI)
				.header("Authorization", "Bearer " + clientToken)
				.contentType(ContentType.JSON)
				.body(createScorePayload(null, score))
				.when()
				.post(SCORE_ENDPOINT)
				.then()
				.statusCode(422)
				.body("errors.message[0]", equalTo("Campo requerido"));
	}
	
	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero() throws Exception {
		long validMovieId = 1L;
		double invalidScore = -1.0;

		given()
				.baseUri(BASE_URI)
				.header("Authorization", "Bearer " + clientToken)
				.contentType(ContentType.JSON)
				.body(createScorePayload(validMovieId, invalidScore))
				.when()
				.post(SCORE_ENDPOINT)
				.then()
				.statusCode(422)
				.body("errors.message[0]", equalTo("Valor mínimo 0"));
	}


	private Map<String, Object> createScorePayload(Long movieId, Double score) {
		Map<String, Object> scorePayload = new HashMap<>();
		if (movieId != null) scorePayload.put("movieId", movieId);
		scorePayload.put("score", score);
		return scorePayload;
	}
}
