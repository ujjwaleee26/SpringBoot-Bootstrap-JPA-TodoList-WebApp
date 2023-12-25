package com.springboot.todolist.first.todolist;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class TodoStructure 
{
	public TodoStructure() {
		
	}
	@Id
	@GeneratedValue
    private int id;
	private String username;
    @Size(min=10,message="err")
    private String description;
    private LocalDate date;
    private boolean status;
	public TodoStructure(String username,int id, String description, LocalDate date, boolean status) {
		super();
		this.username=username;
		this.id = id;
		this.description = description;
		this.date = date;
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TodoStructure [username=" + username + ", id=" + id + ", description=" + description + ", date=" + date + ", status="
				+ status + "]";
	}
	
    
    
}
