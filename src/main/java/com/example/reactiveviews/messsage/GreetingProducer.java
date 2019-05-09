package com.example.reactiveviews.messsage;

import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;
import java.util.stream.Stream;

@Component
public class GreetingProducer {

	public Flux<Greeting> greet(String name) {
		return Flux
				.fromStream(Stream.generate(() -> new Greeting("Hello " + name + " @ " + Instant.now() + "!")))
				.delayElements(Duration.ofSeconds(1));
	}
}
