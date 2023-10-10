package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private int id;
    private String name;
    private List<Quote> quotes = new ArrayList<>();

    public Show(int id, String name, List<Quote> quotes) {
        this.id = id;
        this.name = name;
        this.quotes = quotes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Quote> getQuotes() {
        return quotes;
    }
}
