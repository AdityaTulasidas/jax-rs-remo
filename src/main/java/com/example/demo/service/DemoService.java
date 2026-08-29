package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

    public String getMessage() {
        return "Hello from jax-rs!";
    }

    public String createMessage(String message) {
        return "Created: " + message;
    }
}
