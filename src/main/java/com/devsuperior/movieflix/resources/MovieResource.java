package com.devsuperior.movieflix.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.MovieReviewDTO;
import com.devsuperior.movieflix.services.MovieService;

@RequestMapping("/movies")
@RestController
public class MovieResource {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<Page<MovieDTO>> find(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId,
			Pageable pageable
		) {
		Page<MovieDTO> page = movieService.find(genreId, pageable);
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieDetailsDTO> findById(@PathVariable(name = "id") Long movieId) {
		MovieDetailsDTO movie = movieService.findById(movieId);
		return ResponseEntity.ok().body(movie);
		
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<List<MovieReviewDTO>> findAllReviewsMovie(@PathVariable(name = "id") Long movieId) {
		List<MovieReviewDTO> list = movieService.findAllReviewsMovie(movieId);
		return ResponseEntity.ok().body(list);
	}

}
