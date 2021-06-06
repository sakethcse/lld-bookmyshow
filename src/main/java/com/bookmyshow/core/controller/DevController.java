package com.bookmyshow.core.controller;

import com.bookmyshow.core.model.Movie;
import com.bookmyshow.core.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dev")
public class DevController {

  @Autowired
  MovieRepository movieRepository;

  public List<Movie> getAllMovies(){
    return movieRepository.findAll();
  }

  public Optional<Movie> getMovieById(Long id){
    return movieRepository.findById(id);
  }
}
