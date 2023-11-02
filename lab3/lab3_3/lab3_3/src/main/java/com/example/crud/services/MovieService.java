package com.example.crud.services;

import java.util.List;

import com.example.crud.entities.Movie;

public interface MovieService {
    Movie createMovie(Movie movie);

    Movie updateMovie(Movie movie);

    Movie getMovieById(Long id);

    List<Movie> getAllMovies();

    void deleteMovie(Long id);
}
