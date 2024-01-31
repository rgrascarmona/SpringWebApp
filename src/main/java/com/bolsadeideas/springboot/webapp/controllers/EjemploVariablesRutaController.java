package com.bolsadeideas.springboot.webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String idex(Model model) {
		model.addAttribute("titulo", "Enviar parámetros a la vista");
		return "variables/index";
	}
	
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado es: "+texto);
		return "variables/ver";
		
	}

	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("resultado", "El texto enviado es: "+texto+" y el numero enviado es:"+numero);
		return "variables/ver";
		
	}
}
