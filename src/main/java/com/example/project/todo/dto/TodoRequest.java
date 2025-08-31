package com.example.project.todo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

public class TodoRequest {

    @NotBlank(message = "Title is required")
    @Size(max = 100, message = "Title must be at least 100 characters")
    private String title;

    @Size(max = 500, message = "Description must be at most 500 characters")
    private String description;
    private Boolean done;

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
