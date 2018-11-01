package com.ucc.asignacion.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.models.ProgramaModel;
import com.ucc.asignacion.services.IProgramaService;

@Controller
@RequestMapping("/admin/programas")
public class ProgramaController {

	private static final String REDIRECT_PROGRAMA = "redirect:/admin/programas/";
	private static final String PROGRAMAS_EDIT = "/admin/programas/edit";
	private static final String VISTA = "/admin/programas/programas";
	private final IProgramaService programaService;

	@Autowired
	public ProgramaController(IProgramaService programaService) {
		this.programaService = programaService;
	}

	@GetMapping("/")
	public ModelAndView getProgramas() {
		ModelAndView view = new ModelAndView(VISTA);
		view.addObject("programas", programaService.programas());
		return view;
	}

	@GetMapping("/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView(PROGRAMAS_EDIT);
		view.addObject("programaModel", new ProgramaModel());
		return view;
	}

	@PostMapping("/")
	public ModelAndView save(@Valid ProgramaModel programa, BindingResult bindingResult) {
		ModelAndView view = new ModelAndView();
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}
			view.setViewName(PROGRAMAS_EDIT);
			view.addObject("errors", errors);

		} else {
			programaService.guardarPrograma(programa);
			view.setViewName(REDIRECT_PROGRAMA);
		}
		return view;

	}

}
