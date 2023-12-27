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
@SessionAttributes("username")
public class TodoJpaController 
{
	
	
   public TodoJpaController(TodoStructureRepository repository) {
		super();
		this.repository=repository;
	}
private TodoStructureRepository repository;
   
   @RequestMapping(value="todo")
   public String returnUserFilteredTodolist(ModelMap model)
		     {
	            String username = getLoggedInUserName(model);  
				List<TodoStructure> todos=repository.findByUsername(username);
				// log.info("Todo list for user {}: {}", username, todos);
				model.put("todos",todos);
		    	 return "todo";
		     }

    private String getLoggedInUserName(ModelMap model) {
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	return authentication.getName();
    }
   
    
    @RequestMapping(value="add-todo",method=RequestMethod.GET)
    public String redirectToAddTodoPage(ModelMap model) 
    {
    	String username = getLoggedInUserName(model);
    	TodoStructure todo=new TodoStructure(username,0,"",LocalDate.now(),false);
    	model.addAttribute("todo",todo); 
    	return "add-todo";
    }
    
    @RequestMapping(value="add-todo",method=RequestMethod.POST)
    public String toAddTodo(ModelMap model, @Valid TodoStructure todo, BindingResult result) 
    {	
    	if(result.hasErrors())
    	{
    		model.put("todo", todo);
    		return "add-todo";
    	}
    	String username = getLoggedInUserName(model);
    	todo.setUsername(username);
    	repository.save(todo);
    	return "redirect:todo";
    }
    
    @RequestMapping(value="delete-todo")
    public String toDeleteTodo(@RequestParam int id)
    {
    	repository.deleteById(id);
    	return "redirect:todo";
    }
    
    @RequestMapping(value="update-todo",method=RequestMethod.GET)
    public String  redirectToUpdateTodoPage(@RequestParam int id,ModelMap model)
    {
    	TodoStructure todo =repository.findById(id).get();
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
    	String username=getLoggedInUserName(model);
    	todo.setUsername(username);
    	repository.save(todo);
    	return "redirect:todo";
    }
   
}

