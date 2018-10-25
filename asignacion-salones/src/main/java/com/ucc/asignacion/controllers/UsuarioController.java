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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.services.IProgramaService;
import com.ucc.asignacion.services.IRolService;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final IUsuarioService usuarioService;
	private final IRolService rolService;
	private final IProgramaService programaService;
	
	@Autowired
	public UsuarioController(IUsuarioService usuarioService, IRolService rolService, IProgramaService programaService) {
		this.rolService=rolService;
		this.usuarioService=usuarioService;
		this.programaService=programaService;
	}	
	
	@GetMapping("/")
	public ModelAndView getUsuarios() {
		ModelAndView view = new ModelAndView("/usuarios/usuario");
		view.addObject("usuarios", usuarioService.usuarios());
		return view;
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(Model model, @PathVariable(value = "id") String id) {
		UsuarioModel usuarioModel = usuarioService.buscarUsuarioById(id);
		usuarioModel.setEditar(true);
		model.addAttribute("usuarioModel", usuarioModel);
		model.addAttribute("rolModel",rolService.roles());
		model.addAttribute("programaModel",programaService.programas());
		return "/usuarios/edit";
	}
	
	@GetMapping("/add")
	public ModelAndView createProduct(Model model) {
		ModelAndView view = new ModelAndView("/usuarios/edit");
		view.addObject("usuarioModel", new UsuarioModel());
		model.addAttribute("rolModel",rolService.roles());
		model.addAttribute("programaModel",programaService.programas());
		return view;
	}
	
	@PostMapping("/")
	public ModelAndView saveProduct(@Valid UsuarioModel usuario, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}

			ModelAndView view = new ModelAndView("/usuarios/edit");
			view.addObject("usuarioModel", usuario);
			view.addObject("errors", errors);
			return view;
			
		} else {
			usuarioService.guardarUsuario(usuario);
			return new ModelAndView("redirect:/usuario/");
			
		}
		
	}
			
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") String id) {
		usuarioService.eliminarUsuarioById(id);
		return "redirect:/usuario/";
	}
	
	
}
