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

@Controller
@RequestMapping({"/Maths"})


public class MathsController {

	@PostMapping("adder")
	public String addTwoNumbers(@RequestParam(name = "left") int first, @RequestParam(name = "right") double second,
			Model model) {
		// demonstrates aliasing- request a variable named "left" and store it in an integer named "first"
		Adder adder = new Adder(first, second);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}


	@GetMapping("adder")
	public String addTwoNumbers(Model model) {
		Adder adder = new Adder(0, 0);
		double result = adder.calculate();
		model.addAttribute("sum", result);
		return "helloworld/sum-result";
	}

	
	@PostMapping("subtractor")
	public String subtractTwoNumbers(@RequestParam(name = "left") int first,
			@RequestParam(name = "right") double second, Model model) {
		Subtractor subtractor = new Subtractor(first, second);
		double difference = subtractor.subtract();
		model.addAttribute("difference", difference);
		return "helloworld/difference-result";
	}
	

	@GetMapping("subtractor")
	public String subtractTwoNumbers(Model model) {
		Subtractor subtractor = new Subtractor(0, 0);
		double difference = subtractor.subtract();
		model.addAttribute("difference", difference);
		return "helloworld/difference-result";
	}


}
