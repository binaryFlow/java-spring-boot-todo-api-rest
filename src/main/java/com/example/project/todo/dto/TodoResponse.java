package com.example.project.todo.dto;

public class TodoResponse {
    private final Integer id;
    private final String title;
    private final boolean done;

    public TodoResponse(Integer id, String title, boolean done) {
        this.id = id;
        this.title = title;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isDone() {
        return done;
    }
}
