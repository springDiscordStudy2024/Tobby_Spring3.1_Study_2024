package com.group.todomvc.dto;

import com.group.todomvc.entity.Todo;
import lombok.Getter;


@Getter
public class ToDoGetAllResponse {
    private long id;
    private String message;

    public ToDoGetAllResponse(Todo todo) {
        this.id = todo.getId();
        this.message = todo.getMessage();
    }


}
