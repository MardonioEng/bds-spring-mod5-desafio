package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieDTO;
import com.devsuperior.movieflix.dto.MovieDetailsDTO;
import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Genre;
import com.devsuperior.movieflix.entities.Movie;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.repositories.GenreRepository;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> find(Long genreId, Pageable pageable) {
		Genre genre = (genreId == 0) ? null : genreRepository.getOne(genreId);
		Page<Movie> page = movieRepository.find(genre, pageable);
		return page.map(x -> new MovieDTO(x));
	}
	
	@Transactional(readOnly = true)
	public MovieDetailsDTO findById(Long movieId) {
		Optional<Movie> obj = movieRepository.findById(movieId);
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado!"));
		return new MovieDetailsDTO(movie);
	}
	
	public List<ReviewDTO> findAllReviewsMovie(Long movieId) {
		Optional<Movie> obj = Optional.ofNullable(movieRepository.getOne(movieId));
		Movie movie = obj.orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado!"));
		
		List<Review> reviewList = reviewRepository.findAllByMovieId(movie.getId());
		
		return reviewList.stream().map(review -> new ReviewDTO(review)).collect(Collectors.toList());
	}

}
