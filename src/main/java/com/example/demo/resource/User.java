package com.example.demo.resource;

import java.util.Date;


public class User 
{
	private int id;
	private String name;
	private Date creationDate;
	
	public User() {}
	
	public User(int id, String name, Date creationDate) 
	{
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
