package com.group.todomvc;

import com.group.todomvc.entity.Todo;
import com.group.todomvc.repository.ToDoRepository;
import com.group.todomvc.service.TodoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TodomvcApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoRepository toDoRepository;

    @Autowired
    private TodoService todoService;

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/api/v1/todos/test"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, World")));
    }



    @Test
    void shouldGetAllTodos() throws Exception {
        List<Todo> todoList = Arrays.asList(
                new Todo(1L, "Todo 1"),
                new Todo(2L, "Todo 2")
        );
        when(toDoRepository.findAll()).thenReturn(todoList);

        this.mockMvc.perform(get("/api/v1/todos/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].message").value("Todo 1"))
                .andExpect(jsonPath("$[1].message").value("Todo 2"));
    }

    @Test
    void shouldUpdateTodo() throws Exception {
        long todoId = 1L;
        this.mockMvc.perform(put("/api/v1/todos")
                        .param("id", String.valueOf(todoId)))
                .andExpect(status().isOk());

        verify(toDoRepository, times(1)).setMessage(todoId);
    }

    @Test
    void shouldDeleteTodo() throws Exception {
        long todoId = 1L;
        this.mockMvc.perform(delete("/api/v1/todos")
                        .param("id", String.valueOf(todoId)))
                .andExpect(status().isOk());

        verify(toDoRepository, times(1)).deleteById(todoId);
    }
}