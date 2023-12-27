package com.springboot.todolist.first.todolist;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoStructureRepository extends JpaRepository<TodoStructure,Integer> 
{
     List<TodoStructure> findByUsername(String username);
}
