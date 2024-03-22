package com.group.todomvc.service;

import com.group.todomvc.repository.ToDoRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private final ToDoRepository toDoRepository;

    public TodoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
}
