package com.example.demo.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.resource.User;
import com.example.demo.service.UserJPAService;
import com.example.demo.service.UserService;

@RestController
public class UserJPAController 
{
	@Autowired
	private UserJPAService service;
	
	@RequestMapping(path="/jpa/users", method=RequestMethod.GET)
	public List<User> getAll()
	{
		return service.getAll();
	}
	
	@RequestMapping(path="/jpa/users/{id}", method=RequestMethod.GET)
	public Resource<User> getUser(@PathVariable int id)
	{
		User user = service.getUser(id);
		if(user == null)
		{
			throw new ResourceNotFoundException("Unknown user id: " + id);
		}
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).getAll());
		resource.add(link.withRel("all-users"));
		
		return resource;
	}
	
	@RequestMapping(path="/jpa/users", method=RequestMethod.POST)
	public ResponseEntity<Object> addUser(@Valid @RequestBody final User user)
	{
		User u = service.addUser(user);
		
		if(u != null)
		{
			URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					  .path("/{id}")
					  .buildAndExpand(user.getId())
					  .toUri();
			return ResponseEntity.created(location).build();
		}
		else
		{
			throw new DuplicateResourceException("user with id " + user.getId() + " already found.");
		}
	}
	
	@RequestMapping(path="/jpa/users/{id}", method=RequestMethod.PUT)
	public User addUser(@RequestBody final User user, @PathVariable final int id)
	{
		return service.updateUser(user, id);
	}
}
