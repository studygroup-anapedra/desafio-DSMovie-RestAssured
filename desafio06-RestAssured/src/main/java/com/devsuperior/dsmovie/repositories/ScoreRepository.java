package com.devsuperior.dsmovie.repositories;

import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.ScorePK;
import com.devsuperior.dsmovie.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

    @Query("SELECT s FROM Score s WHERE s.id.user = :user AND s.id.movie = :movie")
    Optional<Score> findByUserAndMovie(@Param("user") User user, @Param("movie") Movie movie);

}