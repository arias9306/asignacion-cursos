package com.ucc.asignacion.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.models.CaracteristicaModel;
import com.ucc.asignacion.services.ICaracteristicaService;

@Controller
@RequestMapping("/admin/caracteristica")
public class CaracteristicaController {

	private static final String REDIRECT_CARACTERISTICA = "redirect:/admin/caracteristica/";
	private static final String CARACTERISTICAS_EDIT = "admin/caracteristicas/edit";
	private static final String VISTA = "admin/caracteristicas/caracteristica";

	private final ICaracteristicaService caracteristicaService;

	@Autowired
	public CaracteristicaController(ICaracteristicaService caracteristicaService) {
		this.caracteristicaService = caracteristicaService;
	}

	@GetMapping("/")
	public ModelAndView getCaracteristica() {
		ModelAndView view = new ModelAndView(VISTA);
		view.addObject("caracteristica", caracteristicaService.caracteristica());
		return view;
	}

	@GetMapping("/add")
	public ModelAndView crearCaracteristica() {
		ModelAndView view = new ModelAndView(CARACTERISTICAS_EDIT);
		view.addObject("caracteristicaModel", new CaracteristicaModel());
		return view;
	}

	@PostMapping("/")
	public ModelAndView guardarCaracteristica(@Valid CaracteristicaModel caracteristica, BindingResult bindingResult) {
		ModelAndView view = new ModelAndView();
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}
			view.setViewName(CARACTERISTICAS_EDIT);
			if(caracteristica.getIdcaracteristica() != 0)
				caracteristica.setEditar(true);
			view.addObject("caracteristicaModel", caracteristica);
			view.addObject("errors", errors);
		} else {
			caracteristicaService.guardarCaracteristica(caracteristica);
			view.setViewName(REDIRECT_CARACTERISTICA);
		}
		return view;
	}

	@GetMapping("/edit/{id}")
	public String editarCaracteristica(Model model, @PathVariable(value = "id") String id) {
		CaracteristicaModel caracteristicaModel = caracteristicaService.buscarCaractById(id);
		caracteristicaModel.setEditar(true);
		model.addAttribute("caracteristicaModel", caracteristicaModel);
		return CARACTERISTICAS_EDIT;
	}

	@GetMapping("/delete/{id}")
	public String eliminarCaracteristica(@PathVariable(name = "id") String id) {
		caracteristicaService.eliminarCaractById(id);
		return REDIRECT_CARACTERISTICA;
	}

}
