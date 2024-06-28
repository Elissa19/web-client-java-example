package com.example.joke.dto;

public record Joke(
        int id,
        String type,
        String setup,
        String punchline) {
}