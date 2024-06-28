package com.example.joke;

import com.example.joke.dto.Joke;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.stream.Stream;

class JokeTests extends AbstractTests {

	@Test
	@DisplayName("Get one random joke")
	void fetchOneRandomJoke() {
		ResponseEntity<Joke> response = jokeService.fetchOneRandomJoke();
        response.getStatusCode().is2xxSuccessful();
        Assertions.assertNotNull(response.getBody());
	}

	@Test
	@DisplayName("Get one random joke second way")
	void fetchRandomJoke() {
		ResponseEntity<Joke> response = jokeService.fetchRandomJoke();
		response.getStatusCode().is2xxSuccessful();
		Assertions.assertNotNull(response.getBody());
	}

	@ParameterizedTest
	@MethodSource("types")
	@DisplayName("Get one random joke by type")
	void fetchTypeOneRandomJoke(String type) {
		ResponseEntity<ArrayList<Joke>> response = jokeService.fetchTypeRandomJoke(type);
		response.getStatusCode().is2xxSuccessful();
		Assertions.assertNotNull(response.getBody());
	}

	@Test
	@DisplayName("Get ten random jokes")
	void fetchTenRandomJoke() {
		ResponseEntity<ArrayList<Joke>> response = jokeService.fetchTenRandomJoke();
		response.getStatusCode().is2xxSuccessful();
		Assertions.assertNotNull(response.getBody());
	}

	@Test
	@DisplayName("Get ten random jokes second way")
	void fetchTenRandomJokes() {
		ResponseEntity<ArrayList<Joke>> response = jokeService.fetchTenRandomJokes();
		response.getStatusCode().is2xxSuccessful();
		Assertions.assertNotNull(response.getBody());
	}

	@ParameterizedTest
	@MethodSource("types")
	@DisplayName("Get ten random jokes by type")
	void fetchTypeTenRandomJoke(String type) {
		ResponseEntity<ArrayList<Joke>> response = jokeService.fetchTypeTenRandomJokes(type);
		response.getStatusCode().is2xxSuccessful();
		Assertions.assertNotNull(response.getBody());
	}

	private static Stream<Arguments> types() {
		return Stream.of(
				Arguments.of("/programming"),
				Arguments.of("/knock-knock"),
				Arguments.of("/general"),
				Arguments.of("/dad"));
	}
}