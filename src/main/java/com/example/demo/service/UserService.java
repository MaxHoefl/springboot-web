package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepository;
import com.example.demo.resource.User;

@Service
public class UserService 
{
	@Autowired
	private UserRepository repo;
	
	public List<User> getAll()
	{
		return repo.getAll();
	}
	
	public User getUser(final int id)
	{
		return repo.getUser(id);
	}
	
	public boolean addUser(final User user)
	{
		return repo.addUser(user);
	}
	
	public boolean updateUser(final User user, final int id)
	{
		return repo.updateUser(user, id);
	}
}
