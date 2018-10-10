package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final IUsuarioService usuarioService;
	
	@Autowired
	public UsuarioController(IUsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@GetMapping("/")
	public ModelAndView getUsuarios() {
		ModelAndView view = new ModelAndView("/usuarios/usuario");
		view.addObject("usuarios", usuarioService.buscarUsuarioPrimerApellido("123"));
		view.addObject("usuarioModel", new UsuarioModel());
		return view;
	}
	
	@PostMapping("/usuario")
	public String buscarUsuarios(Model model, @ModelAttribute("usuarioModel") UsuarioModel usuarioModel) {
		
		Usuario usuario= usuarioService.buscarUsuarioPrimerApellido(usuarioModel.getPrimerApellido());
		return "";
	} 

	
	
}
