package com.group.todomvc.repository;

import com.group.todomvc.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository <Todo, Long> {

    @Query("update Todo c set c.id = :id WHERE c.id = :messageId")
    void setMessage(long messageId);
}
