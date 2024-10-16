package com.indra.flux_test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.Instant;


@RestController("/")
public class Foo {

    @GetMapping(path = "see", produces = TEXT_EVENT_STREAM_VALUE)
    Flux<Data> sse() {
        return source();
    }

    @GetMapping(path = "ndjson", produces = APPLICATION_NDJSON_VALUE)
    Flux<Data> ndjson() {
        return source();
    }

    @GetMapping
    Flux<Data> json() {
        return source();
    }

    private Flux<Data> source() {
        return Flux.interval(Duration.ofSeconds(1))
                .take(5)
                .map(i -> new Data(i, Instant.now()));
    }

}