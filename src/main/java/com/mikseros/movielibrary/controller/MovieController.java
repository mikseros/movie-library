package com.mikseros.movielibrary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mikseros.movielibrary.model.Movie;
import com.mikseros.movielibrary.repo.MovieRepository;

@RestController
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@GetMapping("/test")
	public int test() {
		return 1;
	}
	
	@GetMapping("/movies")
	public List<Movie> getAll() {
		return movieRepository.getAll();
	}
}
