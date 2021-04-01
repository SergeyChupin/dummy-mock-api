package com.example.mock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@RequestMapping(path = "/mock")
@RestController
@SpringBootApplication
public class Application {

    private AtomicLong counter = new AtomicLong(0);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public String post(@RequestBody(required = false) String body) {
        log.info("POST => Body: {}", body);
        counter.incrementAndGet();
        return "OK";
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String get() {
        counter.incrementAndGet();
        return "OK";
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public String put(@RequestBody(required = false) String body) {
        log.info("PUT => Body: {}", body);
        counter.incrementAndGet();
        return "OK";
    }

    @RequestMapping(value = "/stats", method = RequestMethod.GET)
    public Long stats() {
        return counter.get();
    }
}