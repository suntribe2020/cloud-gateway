package com.example.cloudgateway;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Katri Vidén
 * Date: 2022-01-12
 * Time: 19:04
 * Project: cloud-gateway
 * Copyright: MIT
 */
@RestController
public class FallbackController {

    @CircuitBreaker(name = "CircuitBreaker", fallbackMethod = "fallback")
    @RequestMapping("/studentServiceFallback")
    public String studentServiceFallbackGet() {
        return "Oops, it seems like the Student Service might be down or is taking longer than expected. " +
                "Please try again later.";
    }

    @CircuitBreaker(name = "CircuitBreaker", fallbackMethod = "fallback")
    @RequestMapping("/courseServiceFallback")
    public String courseServiceFallback() {
        return "Oops, it seems like the Course Service might be down or is taking longer than expected. " +
                "Please try again later.";
    }

}
