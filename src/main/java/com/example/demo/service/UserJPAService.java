package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserJPARepository;
import com.example.demo.dao.UserRepository;
import com.example.demo.resource.User;

@Service
public class UserJPAService 
{
	@Autowired
	private UserJPARepository repo;
	
	public List<User> getAll()
	{
		List<User> users = new ArrayList<User>();
		repo.findAll().forEach(users::add);
		return users;
	}
	
	public User getUser(final int id)
	{
		return repo.findOne(id);
	}
	
	public User addUser(final User user)
	{
		return repo.save(user);
	}
	
	public User updateUser(final User user, final int id)
	{
		return repo.save(user);
	}
}
