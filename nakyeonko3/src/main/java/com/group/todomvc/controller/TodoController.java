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

    // todo를 추가하는 기능  create
    @PostMapping
    public void saveTodo(@RequestBody ToDoSaveRequest request) {
        todoService.saveTodo(request);
    }

    //저장된 todo전체를 가져오는 기능 read
    @GetMapping("/list")
    public List<ToDoGetAllResponse> getAll(){
        return todoService.getAll();
    }

    // 저장된 todo의 내용을 업데이트 하는 기능 update
    @PutMapping()
    public void updateTodo(@RequestParam long id){
        todoService.updateTodo(id);
    }

    // 저장된 todo중에서 id 값을 이용해서 삭제하는 기능 delete
    @DeleteMapping()
    public void deleteTodo(@RequestParam long id){
        todoService.deleteTodo(id);
    }
}
