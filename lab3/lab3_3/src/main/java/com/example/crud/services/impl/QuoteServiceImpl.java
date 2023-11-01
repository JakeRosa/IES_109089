package com.example.crud.services.impl;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.example.crud.entities.Quote;
import com.example.crud.repositories.QuoteRepository;
import com.example.crud.services.QuoteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuoteServiceImpl implements QuoteService {

    private QuoteRepository quoteRepository;

    @Override
    public Quote createQuote(Quote quote) {
        return quoteRepository.save(quote);
    }

    @Override
    public Quote updateQuote(Quote quote) {
        Quote existingQuote = quoteRepository.findById(quote.getId()).get();
        existingQuote.setQuote(quote.getQuote());
        Quote updatedQuote = quoteRepository.save(existingQuote);
        return updatedQuote;
    }

    @Override
    public void deleteQuote(Long id) {
        quoteRepository.deleteById(id);
    }

    @Override
    public Quote getQuoteById(Long id) {
        return quoteRepository.findById(id).get();
    }

    @Override
    public List<Quote> getQuoteByMovieId(Long movieId) {
        return quoteRepository.findByMovieId(movieId);
    }

    @Override
    public Quote getRandomQuote() {
        Random random = new Random();
        List<Quote> quotes = quoteRepository.findAll();
        int randomIndex = random.nextInt(quotes.size());
        Quote randomQuote = quotes.get(randomIndex);

        return randomQuote;
    }
}
