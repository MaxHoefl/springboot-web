package com.example.demo.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(value=HelloWorldController.class, secure=false)
public class Test_HelloWorldController {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void testGetHelloWorldMessage() throws Exception 
	{
		RequestBuilder requestBuilder = MockMvcRequestBuilders
										.get("/hello-world-int");
										//.header("Accept-Language", "en-uk");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse().getContentAsString());
	}

}
