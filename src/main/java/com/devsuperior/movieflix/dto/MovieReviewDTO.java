package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entities.Review;
import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank
	private String text;
	
	private Long movieId;
	
	@JsonProperty("user")
	private UserDTO user;

	public MovieReviewDTO() {
	}

	public MovieReviewDTO(Long id, String text, Long movieId, UserDTO userDTO) {
		this.id = id;
		this.text = text;
		this.movieId = movieId;
		this.user = userDTO;
	}
	
	public MovieReviewDTO(Review review) {
		id = review.getId();
		text = review.getText();
		movieId = review.getMovie().getId();
		user = new UserDTO(review.getUser());
	}
	 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	@JsonProperty("user")
	public UserDTO getUserDTO() {
		return user;
	}

	@JsonProperty("user")
	public void setUserDTO(UserDTO userDTO) {
		this.user = userDTO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieReviewDTO other = (MovieReviewDTO) obj;
		return Objects.equals(id, other.id);
	}

}
