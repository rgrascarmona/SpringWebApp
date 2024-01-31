package com.bolsadeideas.springboot.webapp.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.webapp.models.Usuario;


@Controller
@RequestMapping("/app")
public class IndexController {

	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping(value="/index")
	public String index(ModelMap model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
	
		Usuario usuario = new Usuario();
		usuario.setNombre("Ramon");
		usuario.setApellido("Gras Carmona");
		usuario.setEmail("rgrascarmona@gmail.com");
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo", textoListar);
				
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(new Usuario("Andres","Guzman","andres@gmail.com"));
		usuarios.add(new Usuario("Ramon","Gras Carmona","rgracarmona@gmail.com"));
		usuarios.add(new Usuario("Elisabet","solis","esolis@gmail.com"));
		
		return usuarios;
	}
	
}
