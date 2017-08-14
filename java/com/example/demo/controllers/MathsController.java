package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.Adder;
import com.example.demo.models.Divider;
import com.example.demo.models.Exponentiator;
import com.example.demo.models.Moduloer;
import com.example.demo.models.Multiplier;
import com.example.demo.models.Subtractor;
import com.example.demo.models.Whisperer;

@Controller

@RequestMapping({ "/Maths" })



public class MathsController {
	
	@PostMapping("result")
	public String addTwoNumbers(@RequestParam(name = "left") double first, @RequestParam(name = "right") double second,
			@RequestParam(name = "operation") String calc, Model model) {
		if (calc.equals("add")) {
			// demonstrates aliasing- request a variable named "left" and store it in an
			// integer named "first"
			Adder adder = new Adder(first, second);
			double result = adder.add();
			model.addAttribute("result", result);
			model.addAttribute("first", first);
			model.addAttribute("second", second);
			String sign = "+";
			model.addAttribute("sign", sign);
			return "calculations/result";
		} else if (calc.equals("subtract")) {
			Subtractor subtractor = new Subtractor(first, second);
			double difference = subtractor.subtract();
			model.addAttribute("result", difference);
			model.addAttribute("first", first);
			model.addAttribute("second", second); 
			String sign = "-";
			model.addAttribute("sign", sign);
			return "calculations/result";
		} else if (calc.equals("multiply")) {
			Multiplier multiplier = new Multiplier(first, second);
			double result = multiplier.multiply();
			model.addAttribute("result", result);
			model.addAttribute("first", first);
			model.addAttribute("second", second);
			String sign = "*";
			model.addAttribute("sign", sign);
			return "calculations/result";
		} else if (calc.equals("divide")) {
			Divider divider = new Divider(first, second);
			double result = divider.divide();
			model.addAttribute("result", result);
			model.addAttribute("first", first);
			model.addAttribute("second", second);
			String sign = "/";
			model.addAttribute("sign", sign);
			return "calculations/result";
		} else if (calc.equals("modulo")) {
			Moduloer modulo = new Moduloer(first, second);
			double result = modulo.modulo();
			model.addAttribute("result", result);
			model.addAttribute("first", first);
			model.addAttribute("second", second);
			String sign = "mod";
			model.addAttribute("sign", sign);
			return "calculations/result";
		} else if (calc.equals("exponentiate")) {
			Exponentiator exponentiate = new Exponentiator(first, second);
			double result = exponentiate.exponentiate();
			model.addAttribute("result", result);
			model.addAttribute("first", first);
			model.addAttribute("second", second);
			String sign = "^";
			model.addAttribute("sign", sign);
			return "calculations/result";
		} else {
			return "";
		}
	}
	
    @GetMapping("result")
    public String index() {
		return "calculations/index";
    }
}
