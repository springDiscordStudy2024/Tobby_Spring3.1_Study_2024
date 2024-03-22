package com.group.todomvc.controller;

import com.group.dto.ToDoSaveRequest;
import com.group.todomvc.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/v1/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public void addTodo(@RequestBody ToDoSaveRequest request) {
        System.out.println(request.getMessage() + ":" + request.getToday());
    }

}
