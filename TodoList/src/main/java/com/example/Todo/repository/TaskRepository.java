package com.example.Todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.Todo.Model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
