package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Score;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ScoreDTO {
	private static final DecimalFormat df = new DecimalFormat("#.##", new DecimalFormatSymbols(Locale.US));

	@NotNull(message = "Campo requerido")
	private Long movieId;
	private Long userId;

	@NotNull(message = "Campo requerido")
	@Min(value = 0, message = "Valor mínimo 0")
	@Max(value = 5, message = "Valor máximo 5")
	private Double score;

	public ScoreDTO() {
	}

	public ScoreDTO(Long movieId,Long userId, Double score) {
		this.movieId = movieId;
		this.userId = userId;
		this.score = Double.valueOf(df.format(score));
	}

	public ScoreDTO(Score score) {
		movieId = score.getId().getMovie().getId();
		userId = score.getId().getUser().getId();
		this.score = Double.valueOf(df.format(score.getValue()));
	}



	public Long getMovieId() {
		return movieId;
	}

	public Double getScore() {
		return score;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
