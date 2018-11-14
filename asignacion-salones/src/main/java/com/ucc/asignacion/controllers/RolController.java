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

import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.services.IRolService;

@Controller
@RequestMapping("/admin/roles")
public class RolController {

  private static final String ROL_MODEL = "rolModel";
  private static final String REDIRECT_ROLES = "redirect:/admin/roles/";
  private static final String VISTA_EDITAR = "admin/roles/edit";
  private static final String VISTA_CONSULTA = "admin/roles/roles";

  private final IRolService rolService;

  @Autowired
  public RolController(IRolService rolService) {
    this.rolService = rolService;
  }

  @GetMapping("/")
  public ModelAndView getRoles() {
    ModelAndView view = new ModelAndView(VISTA_CONSULTA);
    view.addObject("roles", rolService.roles());
    return view;
  }

  @GetMapping("/add")
  public ModelAndView create() {
    ModelAndView view = new ModelAndView(VISTA_EDITAR);
    view.addObject(ROL_MODEL, new RolModel());
    return view;
  }

  @PostMapping("/")
  public ModelAndView save(@Valid RolModel rol, BindingResult bindingResult) {
    ModelAndView view = new ModelAndView();
    if (bindingResult.hasErrors()) {
      List<String> errors = new ArrayList<>();
      for (ObjectError error : bindingResult.getAllErrors()) {
        errors.add(error.getDefaultMessage());
      }
      if (rol.getIdRol() != 0) {
        rol.setEditar(true);
      }
      view.setViewName(VISTA_EDITAR);
      view.addObject(ROL_MODEL, rol);
      view.addObject("errors", errors);
    }
    else {
      rolService.guardarRol(rol);
      view.setViewName(REDIRECT_ROLES);
    }
    return view;
  }

  @GetMapping("/edit/{id}")
  public ModelAndView edit(@PathVariable(value = "id") String id) {
    ModelAndView view = new ModelAndView(VISTA_EDITAR);
    RolModel rolModel = rolService.buscarRolById(id);
    rolModel.setEditar(true);
    view.addObject(ROL_MODEL, rolModel);
    return view;
  }

  @GetMapping("/delete/{id}")
  public ModelAndView delete(@PathVariable(name = "id") String id) {
    rolService.eliminarRolById(id);
    return new ModelAndView(REDIRECT_ROLES);
  }
}
