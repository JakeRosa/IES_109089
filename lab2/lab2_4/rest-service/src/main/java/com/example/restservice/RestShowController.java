package com.example.restservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestShowController {
    private static List<Show> shows = new ArrayList<>();

    public RestShowController() {
        shows.add(new Show(0, "The Lion King", List.of("Hakuna Matata", "I laugh in the face of danger!",
                "Oh yes, the past can hurt. But the way I see it, you can either run from it or learn from it.")));
        shows.add(new Show(1, "Titanic", List.of("I'm the king of the world!", "I'll never let go, Jack.",
                "I figure life's a gift and I don't intend on wasting it. You don't know what hand you're gonna get dealt next. You learn to take life as it comes at you... to make each day count.")));
        shows.add(new Show(2, "Ironman 1", List.of(
                "Is it better to be feared or respected? I say, is it too much to ask for both?",
                "Sometimes you gotta run before you can walk.",
                "I shouldn't be alive... unless it was for a reason. I'm not crazy, Pepper. I just finally know what I have to do. And I know in my heart that it's right.")));
    }

    @GetMapping("/api/quote")
    public String randomQuote() {
        int randomShowIndex = (int) (Math.random() * shows.size());
        Show randomShow = shows.get(randomShowIndex);
        int randomQuoteIndex = (int) (Math.random() * randomShow.getQuotes().size());
        return randomShow.getQuotes().get(randomQuoteIndex);
    }

    @GetMapping("/api/shows")
    public List<Show> shows() {
        return shows;
    }

    @GetMapping("/api/quotes")
    public List<String> quotes(@RequestParam(value = "show") int show_id) {
        return shows.get(show_id).getQuotes();
    }
}
