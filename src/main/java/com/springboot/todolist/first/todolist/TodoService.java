package com.springboot.todolist.first.todolist;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService 
{
	private static int id=0;
    private static List<TodoStructure> todos =new ArrayList<>();
    static {
//    	
    	todos.add(new TodoStructure("Ujjwal",++id,"Learn GraphQL now",LocalDate.now().plusYears(1),false));
    	todos.add(new TodoStructure("Ujjwal",++id,"Learn SonarQube now",LocalDate.now().plusYears(0),false));
    	todos.add(new TodoStructure("Ujjwal",++id,"Learn RabbitMQ now",LocalDate.now().plusYears(2),false));
    }
    
    public List<TodoStructure> getTodoUserBased(String username)
    {
    	Predicate <? super TodoStructure> predicate= todos -> todos.getUsername().equalsIgnoreCase(username);
    	return todos.stream().filter(predicate).toList();
    }
   
    public TodoStructure getTodoIdBased(int id)
    {
    	Predicate <? super TodoStructure> predicate= todos -> todos.getId()==id;
    	return todos.stream().filter(predicate).findFirst().get();
    }
    
    public void addNewTodo(String username,String description,LocalDate date,boolean status)
    {
    	TodoStructure todo=new TodoStructure(username,++id,description,date,status);
    	todos.add(todo);
    }
    
    public void deleteTodo(int id)
    {
    	Predicate <? super TodoStructure> predicate= todos -> todos.getId()== id;
    	todos.removeIf(predicate);
    }

	public void updateTodo(@Valid TodoStructure todo) 
	{
		deleteTodo(todo.getId());
		todos.add(todo);
	}
    
}
