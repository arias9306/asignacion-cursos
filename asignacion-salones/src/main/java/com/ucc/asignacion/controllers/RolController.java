package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.services.IRolService;

@Controller
@RequestMapping("/roles")
public class RolController {

	private static final String VISTA = "roles";

	private final IRolService rolService;

	@Autowired
	public RolController(IRolService rolService) {
		this.rolService = rolService;
	}

	@GetMapping("/")
	public ModelAndView getRoles() {
		ModelAndView view = new ModelAndView(VISTA);
		view.addObject("usuarios", rolService.roles());
		return view;
	}
}
