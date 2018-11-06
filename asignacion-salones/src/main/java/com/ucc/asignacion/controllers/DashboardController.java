package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.services.IPeticionService;
import com.ucc.asignacion.services.ISalonService;
import com.ucc.asignacion.services.IUsuarioService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

  private final IUsuarioService usuarioService;
  private final ISalonService salonService;
  private final IPeticionService peticionService;

  @Autowired
  public DashboardController(IUsuarioService usuarioService, ISalonService salonService, IPeticionService peticionService) {
    this.salonService = salonService;
    this.usuarioService = usuarioService;
    this.peticionService = peticionService;
  }

  @GetMapping("/")
  public ModelAndView get() {
    ModelAndView view = new ModelAndView("/user/dashboard");
    long numeroSalones = salonService.numeroSalones();
    long numeroSalonesOcupados = peticionService.numeroSalonesOcupados();
    long numeroSalonesLibres = numeroSalones - numeroSalonesOcupados;
    view.addObject("numeroUsuarios", usuarioService.numeroUsuarios());
    view.addObject("numeroSalones", numeroSalones);
    view.addObject("numeroSalonesLibres", numeroSalonesLibres);
    view.addObject("numerSalonesOcupados", numeroSalonesOcupados);
    view.addObject("solicitudes", peticionService.obtenerSolicitudes());
    return view;
  }

}
