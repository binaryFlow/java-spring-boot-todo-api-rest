package com.example.project.todo;

import com.example.project.todo.dto.TodoRequest;
import com.example.project.todo.dto.TodoResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoResponse> getAllTodos() {
        return todoRepository.findAll().stream().map(todo -> new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isDone()
        )).toList();
    }

    public TodoResponse getTodoById(Integer id) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));

        return new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isDone()
        );
    }

    public List<TodoResponse> getTodoByDone(Boolean done) {
        List<Todo> todos = todoRepository.findByDone(done);

        return todos.stream().map(todo -> new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.isDone()
        )).toList();

    }

    public TodoResponse insertTodo(TodoRequest request) {
        Todo todo = new Todo();
        todo.setTitle(request.getTitle().trim());


        Todo saved = todoRepository.save(todo);

        return new TodoResponse(
                saved.getId(),
                saved.getTitle(),
                saved.isDone()
        );
    }

    public TodoResponse updateTodoById(Integer id, TodoRequest request) {
        Todo todo = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setTitle(request.getTitle().trim());
        if(request.getDone() != null) {
            todo.setDone(request.getDone());
        }

        Todo saved = todoRepository.save(todo);
        return new TodoResponse(
                saved.getId(),
                saved.getTitle(),
                saved.isDone()
        );

    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }


}
