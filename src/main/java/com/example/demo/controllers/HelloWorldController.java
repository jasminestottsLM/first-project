package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Subtractor;
import com.example.demo.models.Whisperer;
import com.example.demo.models.Yeller;

@Controller
@RequestMapping({"/", "/HelloWorld"})
// this will work whether you go to localhost:8080/ or to localhost:8080/HelloWorld
public class HelloWorldController {
	
	private String title;
	
	public HelloWorldController() {
		title = "Hello Java and Spring!";
	}
	
	@GetMapping("")
	// URL of simply localhost:8080
	public String index() {
		// create a public class of type String called index
		return "helloworld/index";
		// and set this to the helloworld/index file
	}
	// This means that if you go to localhost:8080, what you'll see is the HTML in the index file in this project.
	
	@GetMapping("message")  
	//URL to which the form submits
	public ModelAndView message(@RequestParam(required=false, defaultValue="«silence»") String message) {  
		// in a public class message of type ModelAndView, with no required parameters and a default value of <<silence>>, request the message of type String
		// this message is the part of the method being called 
		ModelAndView mv = new ModelAndView("helloworld/message");  
		//create a new mv of type ModelAndView use it on the helloworld/message page 
		mv.addObject("title", title);
		// using the Model mv, set the title (used in the HTML page) to the title we set above ("Hello Java and Spring!") 
		Yeller yeller = new Yeller(message);  
		//In class Yeller, there is an instance yeller.  Set that equal to class Yeller with input message.
		String yellmessage = yeller.yell();  
		//The result we're looking for, the yellmessage string, is equal to the yeller instance we set above with the yell method applied  
		mv.addObject("message", yellmessage);  
		//Using the model mv, use the method addObject to add the yellmessage string to the message form. 
		return mv; 
		//Return the resulting model mv.
	}

	@GetMapping("whisper")
	public ModelAndView whisper(@RequestParam(required=false, defaultValue="«shhhh!»") String message) {
		ModelAndView mv = new ModelAndView("helloworld/message");
		mv.addObject("title", title);
		Whisperer whisperer = new Whisperer(message);
		String whispermessage = whisperer.whisper();
		mv.addObject("message", whispermessage);
		return mv;
	}
	

}
