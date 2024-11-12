package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.services.ScoreService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scores")
public class ScoreController {
	
	@Autowired
	private ScoreService service;
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
	@PostMapping
	public ResponseEntity<MovieDTO> saveScore(@Valid @RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.saveScore(dto);
		return ResponseEntity.ok().body(movieDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MovieDTO> updateScore(@PathVariable Long id, @Valid @RequestBody ScoreDTO dto) {
		MovieDTO movieDTO = service.updateScore(dto);
		return ResponseEntity.ok().body(movieDTO);
	}


}
