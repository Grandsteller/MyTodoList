package com.example.Todo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Todo.Model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
