package com.example.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
