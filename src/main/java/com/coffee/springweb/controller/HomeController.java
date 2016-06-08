package com.coffee.springweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/welcome")
	public String welcome(Model model){
		model.addAttribute("greeting", "Welcome");
		model.addAttribute("tagline", "This is the welcome page.");
		return "welcome";
	}
	
	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("titulo", "Admin");
		model.addAttribute("mensaje", "Mensaje de la pantalla Admin");
		return "index";
	}
	
	@RequestMapping("/products")
	public String products(Model model){
		return "products";
	}	
}
