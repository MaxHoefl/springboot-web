package com.example.demo.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController 
{
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping("/test1/{name}")
    public String handleRequest (@PathVariable String name, @RequestHeader(name="Accept-Language", required=false) Locale locale) 
	{
		//	System.out.println(locale);
        return messageSource.getMessage(
                  "hello.world.response", new Object[]{name}, locale);
    }
}
