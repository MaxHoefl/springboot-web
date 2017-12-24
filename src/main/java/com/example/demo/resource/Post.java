package com.example.demo.resource;

import java.util.Date;

public class Post 
{
	private int id;
	private Date creationDate;
	private int userId;
	private String message;
	
	public Post() {}
	
	public Post(int id, Date creationDate, int userId, String message) {
		super();
		this.id = id;
		this.creationDate = creationDate;
		this.userId = userId;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
}
