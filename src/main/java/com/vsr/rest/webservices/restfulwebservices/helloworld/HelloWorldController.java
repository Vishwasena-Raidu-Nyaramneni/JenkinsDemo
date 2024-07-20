package com.vsr.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController 
{
	private MessageSource messageSource;
	
	public HelloWorldController(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}
	
	//hello-world
	@GetMapping("/hello-world")
	public String helloworld()
	{
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World");
	}
	
	//hello-world/path-variable/{name}
	@GetMapping("/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name)
	{
		return new HelloWorldBean("Hello World, "+name);
	}
	
	//hello-world
	@GetMapping(path = "/hello-world-internationalized")
	public String helloworldInternationalized()
		{	
			Locale locale = LocaleContextHolder.getLocale();
			return messageSource.getMessage("good.morning.message", null, "Default Message", locale);
		}
	
}
