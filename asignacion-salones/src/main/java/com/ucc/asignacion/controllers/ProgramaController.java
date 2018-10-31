package com.ucc.asignacion.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.models.ProgramaModel;
import com.ucc.asignacion.services.IProgramaService;

@Controller
@RequestMapping("/programas")
public class ProgramaController {

  private static final String VISTA = "/Programas/Programas";

  private final IProgramaService programaService;

  @Autowired
  public ProgramaController(IProgramaService programaService) {

    this.programaService = programaService;

  }

  @GetMapping("/")
  public ModelAndView getProgramas() {
    ModelAndView view = new ModelAndView(VISTA);
    view.addObject("programas", programaService.programas());
    return view;
  }

  @GetMapping("/add")
  public ModelAndView create() {
    ModelAndView view = new ModelAndView("/Programas/edit");
    view.addObject("programaModel", new ProgramaModel());
    return view;
  }

}
