package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.resource.Post;

@Component
public class PostRepository 
{
	static int postId = 0;
	static List<Post> posts = new ArrayList<>(Arrays.asList(
										new Post(++postId, new Date(), UserRepository.users.get(0).getId(), "this is a post by max"), 
										new Post(++postId, new Date(), UserRepository.users.get(0).getId(), "this is another post by max"),
										new Post(++postId, new Date(), UserRepository.users.get(1).getId(), "this is a post by mona"),
										new Post(++postId, new Date(), UserRepository.users.get(1).getId(), "this is another post by mona")));
	
	public List<Post> getAllFromUser(int userId)
	{
		if(!UserRepository.users.stream().anyMatch(u -> u.getId() == userId))
		{
			throw new ResourceNotFoundException("No user with id " + userId);
		}
		ArrayList<Post> res = new ArrayList<>();
		posts.stream().filter(p -> p.getUserId() == userId).forEach(res::add);
		return res;
	}
	
	public Post getPost(final int id)
	{
		if(!posts.stream().anyMatch(p -> p.getId() == id)) 
		{ 
			throw new ResourceNotFoundException("");
		}
		
		return posts.get(id);
	}
	
	public boolean addPost(final int userId, final Post post)
	{
		post.setUserId(userId);
		return posts.add(post);
	}
	
	public boolean updatePost(final int userId, final Post post)
	{
		if(!posts.stream().anyMatch(p -> p.getUserId() == userId))
		{
			return false;
		}
			
		for(Post p : posts)
		{
			if(post.getId() == p.getId())
			{
				p.setCreationDate(post.getCreationDate());
				p.setMessage(post.getMessage());
				p.setUserId(post.getUserId());
				return true;
			}
		}
		return false;
	}
}
