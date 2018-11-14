package com.ucc.asignacion.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard/peticion")
public class PeticionController {
	
	
	private static final String VISTA = "user/peticion";
	
	@GetMapping("/")
	public ModelAndView getProgramas(Principal principal) {
		ModelAndView view = new ModelAndView(VISTA);
		view.addObject("user", principal.getName());
		return view;
	}

}
