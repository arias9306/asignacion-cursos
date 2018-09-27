package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final IUsuarioService usuarioService;

	@Autowired
	public LoginController(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	public ModelAndView getRoles() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	@GetMapping("/usuario")
	public ModelAndView getUsuario() {
		ModelAndView view = new ModelAndView("index");
		Usuario usurio = usuarioService.buscarUsuarioLogin("andres.arias@correo.co", "12345");
		System.out.println(usurio);
		return view;
	}

}
