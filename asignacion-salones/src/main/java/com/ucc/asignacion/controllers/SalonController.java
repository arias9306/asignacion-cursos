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

import com.ucc.asignacion.models.SalonModel;
import com.ucc.asignacion.services.ISalonService;

@Controller
@RequestMapping("/salones")
public class SalonController {

  private static final String VIEW = "/salones/salones";

  private final ISalonService salonService;

  @Autowired
  public SalonController(ISalonService salonService) {
    this.salonService = salonService;
  }

  @GetMapping("/")
  public ModelAndView getSalones() {
    ModelAndView view = new ModelAndView(VIEW);
    view.addObject("salones", salonService.salones());
    return view;
  }

  @GetMapping("/add")
  public ModelAndView create() {
    ModelAndView view = new ModelAndView("/salones/edit");
    view.addObject("salonModel", new SalonModel());
    return view;
  }

  @PostMapping("/")
  public ModelAndView save(@Valid SalonModel salon, BindingResult bindingResult) {
    ModelAndView view = new ModelAndView();
    if (bindingResult.hasErrors()) {
      List<String> errors = new ArrayList<>();
      for (ObjectError error : bindingResult.getAllErrors()) {
        errors.add(error.getDefaultMessage());
      }

      view.setViewName("salones/edit");
      view.addObject("salonModel", salon);
      view.addObject("errors", errors);
    }
    else {
      salonService.guardarSalon(salon);
      view.setViewName("redirect:/salones/");
    }
    return view;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable(value = "id") String id) {
    ModelAndView view = new ModelAndView("/salones/edit");
    SalonModel modelSalon = salonService.buscarSalonById(id);
    modelSalon.setEditar(true);
    view.addObject("salonModel", modelSalon);
    return view;
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable(name = "id") String id) {
    salonService.eliminarSalonById(id);
    return "redirect:/salones/";
  }

}
