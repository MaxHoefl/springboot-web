package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.resource.User;

@Component
public class UserRepository 
{
	static int idCount = 0;
	static List<User> users = new ArrayList<>(Arrays.asList(new User(++idCount, "max", new Date()), new User(++idCount, "mona", new Date())));
	
	public List<User> getAll()
	{
		return users;
	}
	
	public User getUser(final int id)
	{
		if(users.size() > id)
			return users.get(id);
		else
			return null;
	}
	
	public boolean addUser(final User user)
	{
		if(users.size() >= user.getId()) { return false; }
		user.setId(++idCount);
		return users.add(user);
	}
	
	public boolean updateUser(final User user, final int id)
	{
		if(users.stream().filter(u -> u.getId() == id).count() > 0) 
		{ 
			users.get(id-1).setName(user.getName());
			users.get(id-1).setCreationDate(user.getCreationDate());
			return true;
		}
		return false;
	}
}
