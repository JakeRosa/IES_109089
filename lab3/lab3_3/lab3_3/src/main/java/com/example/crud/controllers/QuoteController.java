package com.example.crud.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.entities.Movie;
import com.example.crud.entities.Quote;
import com.example.crud.services.MovieService;
import com.example.crud.services.QuoteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("api")
public class QuoteController {
    private QuoteService quoteService;
    private MovieService movieService;

    @GetMapping("/quote")
    public ResponseEntity<Quote> getRandomQuote() {
        Quote randomQuote = quoteService.getRandomQuote();
        return new ResponseEntity<>(randomQuote, HttpStatus.OK);
    }

    @GetMapping("/shows")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> allMovies = movieService.getAllMovies();
        return new ResponseEntity<>(allMovies, HttpStatus.OK);
    }

    @GetMapping("/quotes")
    public ResponseEntity<List<Quote>> getQuoteByMovieId(
            @RequestParam(name = "movieId", required = true) Long movieId) {
        List<Quote> quotes = quoteService.getQuoteByMovieId(movieId);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @GetMapping("/show")
    public ResponseEntity<Movie> getMovieById(@RequestParam(name = "movieId", required = true) Long movieId) {
        Movie movie = movieService.getMovieById(movieId);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping("/shows")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    @PostMapping("/quotes")
    public ResponseEntity<Quote> createQuote(@RequestBody Quote quote) {
        Quote createdQuote = quoteService.createQuote(quote);
        return new ResponseEntity<>(createdQuote, HttpStatus.CREATED);
    }

}
