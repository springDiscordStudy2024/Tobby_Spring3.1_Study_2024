package com.group.todomvc.controller;

import com.group.todomvc.dto.ToDoGetAllResponse;
import com.group.todomvc.dto.ToDoSaveRequest;
import com.group.todomvc.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/test")
    public String greeting() {
        return "Hello, World";
    }
    @PostMapping
    public void saveTodo(@RequestBody ToDoSaveRequest request) {
        todoService.saveTodo(request);
    }

    @GetMapping("/list")
    public List<ToDoGetAllResponse> getAll(){
        return todoService.getAll();
    }

    @PutMapping()
    public void updateTodo(@RequestParam long id){
        todoService.updateTodo(id);
    }

    @DeleteMapping()
    public void deleteTodo(@RequestParam long id){
        todoService.deleteTodo(id);
    }
}
