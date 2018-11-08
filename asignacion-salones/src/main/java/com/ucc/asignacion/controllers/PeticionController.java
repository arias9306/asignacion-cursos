package com.ucc.asignacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard/peticion")
public class PeticionController {
	
	
	private static final String VISTA = "/user/peticion";
	
	@GetMapping("/")
	public ModelAndView getProgramas() {
		ModelAndView view = new ModelAndView(VISTA);
		return view;
	}

}
