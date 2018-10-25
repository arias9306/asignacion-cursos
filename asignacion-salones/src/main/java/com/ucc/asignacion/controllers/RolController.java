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

import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.services.IRolService;

@Controller
@RequestMapping("/roles")
public class RolController {

	private static final String VISTA = "/roles/roles";

	private final IRolService rolService;

	@Autowired
	public RolController(IRolService rolService) {
		this.rolService = rolService;
	}

	@GetMapping("/")
	public ModelAndView getRoles() {
		ModelAndView view = new ModelAndView(VISTA);
		view.addObject("roles", rolService.roles());
		return view;
	}

	@GetMapping("/add")
	public ModelAndView createProduct(Model model) {
		ModelAndView view = new ModelAndView("/roles/edit");
		view.addObject("rolModel", new RolModel());
		return view;
	}

	@PostMapping("/")
	public ModelAndView saveProduct(@Valid RolModel rol, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}

			ModelAndView view = new ModelAndView("/roles/edit");
			view.addObject("rolModel", rol);
			view.addObject("errors", errors);
			return view;
		} else {
			rolService.guardarRol(rol);
			return new ModelAndView("redirect:/roles/");
			
		}
	}

	@GetMapping("/edit/{id}")
	public String editProduct(Model model, @PathVariable(value = "id") String id) {
		RolModel rolModel = rolService.buscarRolById(id);
		rolModel.setEditar(true);
		model.addAttribute("rolModel", rolModel);
		return "/roles/edit";
	}

	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") String id) {
		rolService.eliminarRolById(id);
		return "redirect:/roles/";
	}
}
