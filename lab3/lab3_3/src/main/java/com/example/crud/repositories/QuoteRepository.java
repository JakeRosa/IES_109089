package com.example.crud.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Quote;

public interface QuoteRepository extends JpaRepository<Quote, Long> {
    List<Quote> findByMovieId(Long movieId);
}
