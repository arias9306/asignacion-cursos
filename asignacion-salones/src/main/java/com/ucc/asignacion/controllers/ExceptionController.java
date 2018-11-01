package com.ucc.asignacion.controllers;

import javax.servlet.http.HttpServletRequest;

import org.attoparser.ParseException;
import org.springframework.expression.spel.SpelEvaluationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.thymeleaf.exceptions.TemplateProcessingException;

@ControllerAdvice
public class ExceptionController {

  @ExceptionHandler(NoHandlerFoundException.class)
  public ModelAndView handleError404(HttpServletRequest request, Exception e) {
    ModelAndView view = new ModelAndView("/errores/404");
    view.addObject("request", request);
    view.addObject("ex", e);
    return view;
  }

  @ExceptionHandler({ Exception.class, SpelEvaluationException.class, TemplateProcessingException.class, ParseException.class })
  public ModelAndView handleError(HttpServletRequest request, Exception e) {
    ModelAndView view = new ModelAndView("/errores/500");
    view.addObject("request", request);
    view.addObject("ex", e);
    return view;
  }

}
