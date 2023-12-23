package com.springboot.todolist.first.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration       //create a number of spring beans and return them back(have their config)
public class SpringSecurityConfiguration 
{
    //for login and password of users LDAP or database are needed
	//currently using inMemory
	//UserDetails is an interface, can't be directly instanced , needs a builder

//    @Bean
//    public InMemoryUserDetailsManager createUserDetailsManager()
//    {
//    	UserDetails user= User.withDefaultPasswordEncoder() //should never be used as all passwords should be encoded
//    	.username("Ujjwal")
//    	.password("dummy")
//    	.roles("USER","ADMIN")
//    	.build();
//    	
//    	return new InMemoryUserDetailsManager(user); 
//    }
//	
	@Bean
    public InMemoryUserDetailsManager createUserDetailsManager()
    {
		UserDetails user1 = createNewUser("Ujjwal", "dummy"); 
		UserDetails user2 = createNewUser("Shubham", "virat"); 
    	
    	return new InMemoryUserDetailsManager(user1,user2);
    }

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder=input -> passwordEncoder().encode(input);
		UserDetails user= User.builder()
    			              .passwordEncoder(passwordEncoder)
    			              .username(username)
    	                      .password(password)
    	                      .roles("USER","ADMIN")
    	                      .build();
		return user;
	}
    
    @Bean
    public PasswordEncoder passwordEncoder() 
    {
    	return new BCryptPasswordEncoder();
    }
}
