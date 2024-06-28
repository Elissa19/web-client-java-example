package com.example.joke;

import com.example.joke.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AbstractTests {

    @Autowired
    public JokeService jokeService;
}