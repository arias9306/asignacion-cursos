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
import com.ucc.asignacion.services.impl.EmailServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {

	private final IUsuarioService usuarioService;
	private final EmailServiceImpl email;

	@Autowired
	public LoginController(IUsuarioService usuarioService, EmailServiceImpl email) {
		this.usuarioService = usuarioService;
		this.email = email;
	}

	@GetMapping("/")
	public ModelAndView getRoles() {
		ModelAndView view = new ModelAndView("index");
		view.addObject("modeloUser", new UsuarioModel());
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
	private String errorMessage = "";
	
	@PostMapping("/iniciarSesion")
	public String validaUser(Model model, @ModelAttribute("modeloUser") UsuarioModel usuarioModel, HttpSession session) {
		
		String correo = usuarioModel.getCorreo();
		String password = usuarioModel.getPassword();
		Usuario usuario = usuarioService.buscarUsuarioLogin(correo, password);
		
		if ((usuario != null) && (!"".equals(usuario))) 
		{
			int id_user= usuario.getIdUsuario();
			System.out.println("Si se loguea aca");
			session.setAttribute("miUserSession", id_user);
		
			return "dashboard";
		}else{
			errorMessage= "Usuario y Contraseña incorrectos";
			System.out.println("Error de Loguin");
			
		}
		model.addAttribute("mensajeError", errorMessage);
		return "index";
	
	}
	
	@PostMapping("/cambioPassw")
	public String recordarPassword(Model model, @ModelAttribute("modeloUser") UsuarioModel usuarioModel, HttpSession session) {
	
		String correo= usuarioModel.getCorreo();
		Usuario usuario = usuarioService.recuperarPassword(correo);

		if ((usuario != null) && (!"".equals(usuario))) 
		{
			System.out.println("Se le envia la contraseña"+usuario.getPassword());
		
			email.enviarCorreo(correo);
			}else {
				System.out.println("No le envio nada");
			}
		return "redirect:/login/";
	
		}
}
