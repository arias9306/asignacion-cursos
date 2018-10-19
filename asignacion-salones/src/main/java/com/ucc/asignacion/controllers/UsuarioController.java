package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.RolModel;
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
		view.addObject("usuarios", usuarioService.usuarios());
		return view;
	}
	
	@GetMapping("/edit/{id}")
	public String editProduct(Model model, @PathVariable(value = "id") String id) {
		model.addAttribute("usuarioModel", usuarioService.buscarUsuarioById(id));
		return "/usuarios/edit";
	}
	
	@GetMapping("/add")
	public ModelAndView createProduct(Model model) {
		ModelAndView view = new ModelAndView("/usuarios/edit");
		view.addObject("usuarioModel", new UsuarioModel());
		return view;
	}
	
	@PostMapping("/")
	public String saveProduct(UsuarioModel usuario) {
		usuarioService.guardarUsuario(usuario);
		return "redirect:/usuario/";
	}
	
	
	
	
}
