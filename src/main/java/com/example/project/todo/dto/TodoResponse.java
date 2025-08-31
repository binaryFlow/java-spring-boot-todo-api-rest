package com.example.project.todo.dto;

public class TodoResponse {
    private final Integer id;
    private final String title;
    private final String description;
    private final boolean done;

    public TodoResponse(Integer id, String title, String description, boolean done) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }
}
