package com.example.crud.services;

import java.util.List;

import com.example.crud.entities.Quote;

public interface QuoteService {
    Quote createQuote(Quote quote);

    Quote updateQuote(Quote quote);

    void deleteQuote(Long id);

    Quote getQuoteById(Long id);

    List<Quote> getQuoteByMovieId(Long movieId);

    Quote getRandomQuote();
}
