package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.models.AuditoriaModel;
import com.ucc.asignacion.services.IAuditoriaService;

@Controller
@RequestMapping("/admin/auditoria")
public class AuditoriaController {

  //private static final String REDIRECT_AUDITORIA = "redirect:/admin/auditoria/";
  private static final String VISTA = "admin/auditoria/auditoria";

  private final IAuditoriaService auditoriaService;

  @Autowired
  public AuditoriaController(IAuditoriaService auditoriaService) {
    this.auditoriaService = auditoriaService;
  }

  @GetMapping("/")
  public ModelAndView getAuditoria() {
    ModelAndView view = new ModelAndView(VISTA);
    view.addObject("auditoria", auditoriaService.auditoria());
    return view;
  }

  @GetMapping("/Ver/{id}")
  public ModelAndView edit(@PathVariable(value = "id") String id) {
    ModelAndView view = new ModelAndView("admin/auditoria/Ver");
    AuditoriaModel auditoriaModel = auditoriaService.buscarAuditoriaById(id);
    view.addObject("auditoria", auditoriaModel);
    return view;
  }

}
