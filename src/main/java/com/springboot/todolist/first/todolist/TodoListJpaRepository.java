package com.springboot.todolist.first.todolist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoListJpaRepository extends JpaRepository<TodoStructure,Integer> 
{
    public List<TodoStructure> findByUsername(String username);
}
