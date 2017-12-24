package com.example.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.exception.DuplicateResourceException;
import com.example.demo.resource.Post;
import com.example.demo.service.PostService;

@RestController
public class PostController 
{
	@Autowired
	private PostService service;
	
	@RequestMapping(path="/users/{userId}/posts", method=RequestMethod.GET)
	public List<Post> getAllFromUser(@PathVariable int userId)
	{
		return service.getAllFromUser(userId);
	}
	
	@RequestMapping(path="/users/{userId}/posts/{id}", method=RequestMethod.GET)
	public Post getById(@PathVariable int userId, @PathVariable int id)
	{
		return service.get(id);
	}
	
	@RequestMapping(path="/users/{userId}/posts", method=RequestMethod.POST)
	public ResponseEntity<Object> addPostFromUser(@PathVariable int userId, @RequestBody final Post post)
	{
		service.add(userId, post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(post.getId())
				  .toUri();
		return ResponseEntity.created(location).build();
	}
	
	@RequestMapping(path="/users/{id}/posts", method=RequestMethod.PUT)
	public boolean updatePostFromUser(@PathVariable int userId, @RequestBody final Post post)
	{
		return service.update(userId, post);
	}
}
