package com.group.todomvc.service;

import com.group.todomvc.dto.ToDoGetAllResponse;
import com.group.todomvc.dto.ToDoSaveRequest;
import com.group.todomvc.entity.Todo;
import com.group.todomvc.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {
    private final ToDoRepository toDoRepository;

    public TodoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    // create todos
    public void saveTodo(ToDoSaveRequest request) {
        toDoRepository.save(new Todo(request.getMessage()));
    }

    // get all todos
    public List<ToDoGetAllResponse> getAll() {
        return toDoRepository.findAll()
                .stream()
                .map(ToDoGetAllResponse::new)
                .collect(Collectors.toList());
    }

    public void updateTodo(long id) {
        toDoRepository.setMessage(id);
    }

    public void deleteTodo(long id) {
        toDoRepository.deleteById(id);
    }
}
