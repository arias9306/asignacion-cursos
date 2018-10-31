package com.ucc.asignacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

  @GetMapping("/")
  public ModelAndView get() {
    return new ModelAndView("/user/dashboard");
  }
}
