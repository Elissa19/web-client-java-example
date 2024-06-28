package com.example.joke.service;

import com.example.joke.dto.Joke;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@SuppressWarnings(value = "UNCHECKED_CASTS")
@Lazy
@Service
public class JokeService extends BaseService {
    @Value("${base-url.back}")
    private String baseUrl;
    private final String ten = "/ten";
    private final String jokes = "/jokes";
    private final String random = "/random";
    private final String randomTen = "/random_ten";
    private final String randomJoke = "/random_joke";

    private ResponseEntity<?> fetchJoke(String url, Class<?> responseType) {
        return getRequest(url, null, responseType);
    }

    public ResponseEntity<Joke> fetchOneRandomJoke() {
        return (ResponseEntity<Joke>) fetchJoke(baseUrl + randomJoke, Joke.class);
    }

    public ResponseEntity<Joke> fetchRandomJoke() {
        return (ResponseEntity<Joke>) fetchJoke(baseUrl + jokes + random, Joke.class);
    }

    public ResponseEntity<ArrayList<Joke>> fetchTypeRandomJoke(String type) {
        return (ResponseEntity<ArrayList<Joke>>) fetchJoke(baseUrl + jokes + type + random, Joke[].class);
    }

    public ResponseEntity<ArrayList<Joke>> fetchTenRandomJoke() {
        return (ResponseEntity<ArrayList<Joke>>) fetchJoke(baseUrl + randomTen, Joke[].class);
    }

    public ResponseEntity<ArrayList<Joke>> fetchTenRandomJokes() {
        return (ResponseEntity<ArrayList<Joke>>) fetchJoke(baseUrl + jokes + ten, Joke[].class);
    }

    public ResponseEntity<ArrayList<Joke>> fetchTypeTenRandomJokes(String type) {
        return (ResponseEntity<ArrayList<Joke>>) fetchJoke(baseUrl + jokes + type + ten, Joke[].class);
    }
}