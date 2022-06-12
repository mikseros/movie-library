package com.mikseros.movielibrary.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.mikseros.movielibrary.model.Movie;

@Repository
public class MovieRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Movie> getAll() {
		return jdbcTemplate.query("SELECT id, title, rating FROM movie",
				BeanPropertyRowMapper.newInstance(Movie.class));
	}
	
	public Movie getById(int id) {
		return jdbcTemplate.queryForObject("SELECT id, title, rating FROM movie WHERE id = ?",
				BeanPropertyRowMapper.newInstance(Movie.class), id);
	}

	public int save(List<Movie> movies) {
		movies.forEach(movie -> jdbcTemplate
				.update("INSERT INTO movie(title, rating) VALUES(?,?)",
						movie.getTitle(), movie.getRating()));
		return 1;
	}
	
	public int update(Movie movie) {
		return jdbcTemplate.update("UPDATE movie SET title=?, rating=? WHERE id=?",
				movie.getTitle(), movie.getRating(), movie.getId());
	}
	
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM movie WHERE id=?", id);
	}
}
