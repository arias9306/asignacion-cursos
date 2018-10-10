package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.services.ISalonService;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/salon")
public class SalonController {
	
	private final ISalonService salonService;
	
	@Autowired
	public SalonController(ISalonService salonService) {
		this.salonService = salonService;
	}
	
	
	@GetMapping("/")
	public ModelAndView getSalon() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}
	
	@GetMapping("/salon")
	public ModelAndView getSalon() {
		ModelAndView view = new ModelAndView("index");
		
		
	}
	

}
