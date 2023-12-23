package com.springboot.todolist.first.todolist;

import java.time.LocalDate;

import jakarta.validation.constraints.Size;

public class TodoStructure 
{
	private String username;
    private int id;
    @Size(min=10,message="err")
    private String desc;
    private LocalDate date;
    private boolean status;
	public TodoStructure(String username,int id, String desc, LocalDate date, boolean status) {
		super();
		this.username=username;
		this.id = id;
		this.desc = desc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
		return "TodoStructure [username=" + username + ", id=" + id + ", desc=" + desc + ", date=" + date + ", status="
				+ status + "]";
	}
	
    
    
}
