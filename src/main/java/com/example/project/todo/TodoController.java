package com.example.project.todo;

import com.example.project.todo.dto.TodoRequest;
import com.example.project.todo.dto.TodoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {
    private final TodoService todoService;
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping()
    public List<TodoResponse> getTodos(){
        return todoService.getAllTodos();
    }

    @GetMapping("{id}")
    public TodoResponse getTodoById(@PathVariable Integer id){
        return todoService.getTodoById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<TodoResponse> updateTodo(@Valid @PathVariable Integer id, @RequestBody TodoRequest request){
        TodoResponse savedTodo = todoService.updateTodoById(id, request);
        return ResponseEntity.ok().body(savedTodo);
    }

    @PostMapping()
    public ResponseEntity<TodoResponse> inertTodo(@Valid @RequestBody TodoRequest request){
        TodoResponse savedTodo = todoService.insertTodo(request);
        return ResponseEntity.ok().body(savedTodo);
    }



    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Integer id){
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }


}
