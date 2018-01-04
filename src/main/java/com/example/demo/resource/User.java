package com.example.demo.resource;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
public class User 
{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Size(min=2, message="must be at least 2 characters")
	@Column(name="name")
	private String name;
	
	@Past
	@Column(name="creationDate")
	private Date creationDate;
	
	public User() {}
	
	public User(int id, String name, Date creationDate) 
	{
		this.id = id;
		this.name = name;
		this.creationDate = creationDate;
	}

	public int getId() 
	{
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
