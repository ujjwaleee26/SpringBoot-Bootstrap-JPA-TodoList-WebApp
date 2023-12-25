package com.springboot.todolist.first.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("username")
public class welcomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String toWelcome(ModelMap model) {
		model.put("username",getLoggedInUserName());
		return "welcome";
	}
	
	private String getLoggedInUserName()
	{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}