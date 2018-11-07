package com.ucc.asignacion.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.models.ContrasenaModel;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.services.IProgramaService;
import com.ucc.asignacion.services.IRolService;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/admin/usuario")
public class UsuarioController {

	private final IUsuarioService usuarioService;
	private final IRolService rolService;
	private final IProgramaService programaService;

	private static final String REDIRECT_USUARIO = "redirect:/admin/usuario/";
	private static final String VISTA_CONSULTA = "/admin/usuarios/usuario";
	private static final String VISTA_EDITAR = "/admin/usuarios/edit";

	/**
	 * Constructor.
	 *
	 * @param usuarioService
	 * @param rolService
	 * @param programaService
	 */
	@Autowired
	public UsuarioController(IUsuarioService usuarioService, IRolService rolService, IProgramaService programaService) {
		this.rolService = rolService;
		this.usuarioService = usuarioService;
		this.programaService = programaService;
	}

	@GetMapping("/")
	public ModelAndView getUsuarios() {
		ModelAndView view = new ModelAndView(VISTA_CONSULTA);
		view.addObject("usuarios", usuarioService.usuarios());
		return view;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable(value = "id") String id) {
		ModelAndView view = new ModelAndView(VISTA_EDITAR);
		UsuarioModel usuarioModel = usuarioService.buscarUsuarioById(id);
		usuarioModel.setEditar(true);
		view.addObject("usuarioModel", usuarioModel);
		view.addObject("rolModel", rolService.roles());
		view.addObject("programaModel", programaService.programas());
		return view;
	}

	@GetMapping("/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView(VISTA_EDITAR);
		view.addObject("usuarioModel", new UsuarioModel());
		view.addObject("rolModel", rolService.roles());
		view.addObject("programaModel", programaService.programas());
		return view;
	}

	@PostMapping("/")
	public ModelAndView save(@Valid UsuarioModel usuario, BindingResult bindingResult) {
		ModelAndView view = new ModelAndView();
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}
			view.setViewName(VISTA_EDITAR);
			view.addObject("usuarioModel", usuario);
			view.addObject("errors", errors);
			view.addObject("rolModel", rolService.roles());
			view.addObject("programaModel", programaService.programas());
		} else {
			usuarioService.guardarUsuario(usuario, false);
			view.setViewName(REDIRECT_USUARIO);
		}
		return view;

	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") String id) {
		usuarioService.eliminarUsuarioById(id);
		return REDIRECT_USUARIO;
	}

	@GetMapping("/cambiarcontrasena")
	public ModelAndView cambiarContraseña() {
		ModelAndView view = new ModelAndView("/user/cambiarcontrasena");
		view.addObject("contrasenaModel", new ContrasenaModel());
		return view;

	}
	
	@PostMapping("/")
	public ModelAndView save(@Valid ContrasenaModel contrasena) {
		ModelAndView view = new ModelAndView();
		
		view.setViewName(REDIRECT_USUARIO);
	
		return view;

		
	}

}
