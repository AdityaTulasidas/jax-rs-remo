package com.example.demo.controller;

import com.example.demo.service.DemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class RestDemoController {

    private final DemoService demoService;

    public RestDemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @GetMapping("/demo")
    public Map<String, String> getMessage() {
        return Map.of("message", demoService.getMessage());
    }

    @PostMapping("/demo")
    public ResponseEntity<Map<String, String>> createMessage(@RequestParam(defaultValue = "") String message) {
        return ResponseEntity.ok(Map.of("message", demoService.createMessage(message)));
    }
}
