package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PostRepository;
import com.example.demo.resource.Post;

@Service
public class PostService {
	@Autowired
	private PostRepository postResource;
	
	public List<Post> getAllFromUser(int id)
	{
		return postResource.getAllFromUser(id);
	}
	
	public Post	get(final int id)
	{
		return postResource.getPost(id);
	}
	
	public boolean add(final int userId, final Post post)
	{
		return postResource.addPost(userId, post);
	}
	
	public boolean update(final int userId, final Post post)
	{
		return postResource.updatePost(userId, post);
	}
}
