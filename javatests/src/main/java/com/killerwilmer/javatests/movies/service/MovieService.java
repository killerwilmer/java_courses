package com.killerwilmer.javatests.movies.service;

import com.killerwilmer.javatests.movies.data.MovieRepository;
import com.killerwilmer.javatests.movies.model.Genre;
import com.killerwilmer.javatests.movies.model.Movie;

import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

  private MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {

    this.movieRepository = movieRepository;
  }

  public Collection<Movie> findMoviesByGenre(Genre genre) {

    return movieRepository.findAll().stream()
        .filter(movie -> movie.getGenre() == genre)
        .collect(Collectors.toList());
  }

  public Collection<Movie> findMoviesByLength(int length) {

    return movieRepository.findAll().stream()
        .filter(movie -> movie.getMinutes() <= length)
        .collect(Collectors.toList());
  }
}
