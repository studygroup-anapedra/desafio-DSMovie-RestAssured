package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ForbiddenException;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreService {


	@Autowired
	private UserService userService;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto){
		User user = userService.authenticated();
		Movie movie = movieRepository.findById(dto.getMovieId())
				.orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		updateMovieScore(movie);

		return new MovieDTO(movie);
	}

	@Transactional
	public MovieDTO updateScore(ScoreDTO dto) {
		User user = userService.authenticated();
		Movie movie = movieRepository.getReferenceById(dto.getMovieId());

		if (!dto.getUserId().equals(userService.me().getId())) {
			throw new ForbiddenException("Access denied: User does not have the required permissions.");
		}

		Score score = scoreRepository.findByUserAndMovie(user, movie)
				.orElseThrow(() -> new ResourceNotFoundException("Pontuação não encontrada para o usuário e filme"));

		score.setValue(dto.getScore());
		scoreRepository.saveAndFlush(score);

		updateMovieScore(movie);

		return new MovieDTO(movie);
	}


	private void updateMovieScore(Movie movie) {

		double sum = movie.getScores().stream().mapToDouble(Score::getValue).sum();
		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movieRepository.save(movie);
	}


}
