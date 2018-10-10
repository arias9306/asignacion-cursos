package com.ucc.asignacion.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final IUsuarioService usuarioService;

	@Autowired
	public LoginController(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@GetMapping("/")
	public ModelAndView getRoles() {
		ModelAndView view = new ModelAndView("index");
		return view;
	}

	@GetMapping("/usuario")
	public ModelAndView getUsuario() {
		ModelAndView view = new ModelAndView("index");
		Usuario usuario = usuarioService.buscarUsuarioLogin("andres.arias@correo.co", "12345");
		System.out.println(usuario);
		return view;  
	} 
	
	//ENVIO MODELO PARA MANEJO DE GET AND SETS
	@GetMapping("/EnvioModel")
	public ModelAndView SendModel() {
		ModelAndView view = new ModelAndView("index");
		view.addObject("modeloUser", new UsuarioModel());
		return view;
	}
	
	@GetMapping("/EnvioPrueba")
	public ModelAndView PruebaModel() {
		ModelAndView view = new ModelAndView("prueba");
		view.addObject("modeloUser", new UsuarioModel());
		return view;
	}
	
	@PostMapping("/iniciarSesion")
	public String validaUser(Model model, @ModelAttribute("modeloUser") UsuarioModel usuarioModel, HttpSession session) {
		
		String errorMessage = "";
		String correo = usuarioModel.getCorreo();
		String password = usuarioModel.getPassword();
		Usuario usuario = usuarioService.buscarUsuarioLogin(correo, password);
		int id_user= usuario.getIdUsuario();
		
		System.out.println("id: "+id_user);
		//System.out.println("rol: "+rolUser);
		
		if ((usuario != null) && (!"".equals(usuario))) 
		{
			System.out.println("Si se loguea aca");
			session.setAttribute("miUserSession", id_user);
		
			return "redirect:/login/EnvioPrueba";
		}else{
			errorMessage= "Usuario y Contraseña incorrectos";
			System.out.println("Error de Loguin");
		}
		model.addAttribute("mensajeError", errorMessage);
		return "UsuarioModel";
	
	}
	
	@PostMapping("/cambioPassw")
	public String recordarPassword(Model model, @ModelAttribute("modeloUser") UsuarioModel usuarioModel, HttpSession session) {
	
		String correo= usuarioModel.getCorreo();
		Usuario usuario = usuarioService.recuperarPassword(correo);

		if ((usuario != null) && (!"".equals(usuario))) 
		{
			System.out.println("Se le envia la contraseña"+usuario.getPassword());
			}else {
				System.out.println("No le envio nada");
			}
		return "";
	
		}
}
