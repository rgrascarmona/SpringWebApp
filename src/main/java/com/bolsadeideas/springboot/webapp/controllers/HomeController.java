package com.bolsadeideas.springboot.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "redirect:/app/index"; // forward:/app:index
	}
	
}
