package com.springboot.todolist.first.todolist;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;


 @Controller
@SessionAttributes("name")
public class TodoController 
{
	private TodoService todolist;
	
   public TodoController(TodoService todolist) {
		super();
		this.todolist = todolist;
	}

   //--------xxxxx-------
   @RequestMapping(value="todo")
   public String returnUserFilteredTodolist(ModelMap model)
		     {
	            String name = getLoggedInUserName(model);
				List<TodoStructure> todos=todolist.getTodoUserBased(name);
				model.addAttribute("todos",todos);
		    	 return "todo";
		     }

    private String getLoggedInUserName(ModelMap model) {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
    }
   //--------xxxxx----	
    
    
    //-------xxxxxxx-----
    //Implementing 2 way binding(bean-server and server-bean
    //Adding a todo
    
    @RequestMapping(value="add-todo",method=RequestMethod.GET)
    public String redirectToAddTodoPage(ModelMap model) 
    {
    	String name = getLoggedInUserName(model);
    	TodoStructure todo=new TodoStructure(name,0,"",LocalDate.now(),false);
    	model.put("todo",todo);
    	return "add-todo";
    }
    
    @RequestMapping(value="add-todo",method=RequestMethod.POST)
    public String toAddTodo(ModelMap model, @Valid TodoStructure todo, BindingResult result) 
    {	
    	if(result.hasErrors())
    	{
    		model.put("todo", todo);
    	}
    	String name = getLoggedInUserName(model);
    	todolist.addNewTodo(name,todo.getDesc(), todo.getDate(), todo.isStatus());
    	return "redirect:todo";
    }
     
    //-------xxxxx-----
    
    @RequestMapping(value="delete-todo")
    public String toDeleteTodo(@RequestParam int id)
    {
    	todolist.deleteTodo(id);
    	return "redirect:todo";
    }
    
    //-------xxxx-----
    @RequestMapping(value="update-todo",method=RequestMethod.GET)
    public String  redirectToUpdateTodoPage(@RequestParam int id,ModelMap model)
    {
    	TodoStructure todo =todolist.getTodoIdBased(id);
    	model.addAttribute("todo", todo);
    	return "add-todo";
    }
    
    @RequestMapping(value="update-todo",method=RequestMethod.POST)
    public String toUpdateTodo(ModelMap model, @Valid TodoStructure todo, BindingResult result) 
    {	
    	if(result.hasErrors())
    	{
    		model.put("todo", todo);
    	}
    	String name=getLoggedInUserName(model);
    	todo.setUsername(name);
    	todolist.updateTodo(todo);
    	return "redirect:todo";
    }
   
}
