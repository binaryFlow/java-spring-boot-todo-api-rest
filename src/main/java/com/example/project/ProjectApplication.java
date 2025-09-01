package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@SpringBootApplication
public class ProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

    @GetMapping
    public Map<String, Object> index() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("name", "Todo API");
        response.put("version", "1.0");
        response.put("description", "A simple REST API to manage todos");

        List<Map<String, String>> endpoints = List.of(
                Map.of("method", "GET", "path", "/api/v1/todos", "description", "List all todos"),
                Map.of("method", "GET", "path", "/api/v1/todos/{id}", "description", "Get todo by ID"),
                Map.of("method", "GET", "path", "/api/v1/todos/filterByDone/{done}", "description", "Filter todos by completed"),
                Map.of("method", "POST", "path", "/api/v1/todos", "description", "Create a new todo"),
                Map.of("method", "DELETE", "path", "/api/v1/todos/{id}", "description", "Delete a todo by ID")

        );

        response.put("endpoints", endpoints);
        return response;
    }

}
