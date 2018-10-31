package com.ucc.asignacion.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.services.IUsuarioService;
import com.ucc.asignacion.services.impl.EmailServiceImpl;

@Controller
@RequestMapping({ "", "/login" })
public class LoginController {

  private final IUsuarioService usuarioService;
  private final EmailServiceImpl email;

  @Autowired
  public LoginController(IUsuarioService usuarioService, EmailServiceImpl email) {
    this.usuarioService = usuarioService;
    this.email = email;
  }

  @GetMapping({ "", "/" })
  public ModelAndView get() {
    ModelAndView view = new ModelAndView("index");
    view.addObject("modeloUser", new UsuarioModel());
    return view;
  }

  @PostMapping("/iniciarSesion")
  public String validarUser(Model model, @ModelAttribute("modeloUser") UsuarioModel usuarioModel, HttpSession session) {
    String errorMessage = "";
    String correo = usuarioModel.getCorreo();
    String password = usuarioModel.getPassword();
    Usuario usuario = usuarioService.buscarUsuarioLogin(correo, password);

    if (usuario != null) {
      int id_user = usuario.getIdUsuario();
      session.setAttribute("miUserSession", id_user);
      return "redirect:/dashboard/";
    }
    else {
      errorMessage = "Usuario y contraseña incorrectos";

    }
    model.addAttribute("mensajeError", errorMessage);
    return "index";

  }

  @PostMapping("/cambioPassw")
  public String recordarPassword(Model model1, @ModelAttribute("modeloUser") UsuarioModel usuarioModel) {

    String correo = usuarioModel.getCorreo();
    String error = "";
    Usuario usuario = usuarioService.recuperarPassword(correo);

    if (usuario != null) {
      email.enviarCorreo(correo, usuario.getPassword());
    }
    else {
      error = "El correo ingresado no está registrado en el sistema..";

    }
    model1.addAttribute("mensajeError", error);
    return "index";

  }
}
