package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.movieflix.entities.Review;

public class ReviewDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nameUser;
	private String text;

	public ReviewDTO() {
	}

	public ReviewDTO(String nameUser, String text) {
		this.nameUser = nameUser;
		this.text = text;
	}
	
	public ReviewDTO(Review review) {
		nameUser = review.getUser().getName();
		text = review.getText();
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReviewDTO other = (ReviewDTO) obj;
		return Objects.equals(nameUser, other.nameUser);
	}

}
