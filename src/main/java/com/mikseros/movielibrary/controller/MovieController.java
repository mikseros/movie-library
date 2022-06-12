package com.mikseros.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikseros.movielibrary.model.Movie;
import com.mikseros.movielibrary.repo.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping
	public List<Movie> getAll() {
		return movieRepository.getAll();
	}
	
	@GetMapping("/{id}")
	public Movie getById(@PathVariable("id") int id) {
		return movieRepository.getById(id);
	}
	
	@PostMapping
	public int add(@RequestBody List<Movie> movies) {
		return movieRepository.save(movies);
	}
}
