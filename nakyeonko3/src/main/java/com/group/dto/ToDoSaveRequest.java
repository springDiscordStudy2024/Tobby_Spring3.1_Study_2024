package com.group.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
public class ToDoSaveRequest {
    private String message;
    private LocalDate today;

    public ToDoSaveRequest() {
    }

    public ToDoSaveRequest(String message, LocalDate today) {
        this.message = message;
        this.today = LocalDate.now();
    }
}
