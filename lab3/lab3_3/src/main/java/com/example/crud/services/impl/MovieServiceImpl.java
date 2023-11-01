package com.example.crud.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Movie;
import com.example.crud.repositories.MovieRepository;
import com.example.crud.services.MovieService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Movie existingMovie = movieRepository.findById(movie.getId()).get();
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setYear(movie.getYear());
        Movie updatedMovie = movieRepository.save(existingMovie);
        return updatedMovie;
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }

}
