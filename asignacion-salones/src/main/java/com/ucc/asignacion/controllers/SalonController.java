package com.ucc.asignacion.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ucc.asignacion.models.CaracteristicaModel;
import com.ucc.asignacion.models.SalonModel;
import com.ucc.asignacion.services.ICaracteristicaService;
import com.ucc.asignacion.services.ISalonService;

@Controller
@RequestMapping("/admin/salones")
public class SalonController {

	private static final String REDIRECT_SALONES = "redirect:/admin/salones/";
	private static final String SALONES_EDIT = "/admin/salones/edit";
	private static final String VIEW = "/admin/salones/salones";

	private final ISalonService salonService;
	private final ICaracteristicaService caracteristicaService;

	/**
	 * Constructor.
	 *
	 * @param salonService
	 * @param caracteristicaService
	 */
	@Autowired
	public SalonController(ISalonService salonService, ICaracteristicaService caracteristicaService) {
		this.salonService = salonService;
		this.caracteristicaService = caracteristicaService;
	}

	@GetMapping("/")
	public ModelAndView getSalones() {
		ModelAndView view = new ModelAndView(VIEW);
		view.addObject("salones", salonService.salones());
		return view;
	}

	@GetMapping("/add")
	public ModelAndView create() {
		ModelAndView view = new ModelAndView(SALONES_EDIT);
		SalonModel model = new SalonModel();
		ArrayList<CaracteristicaModel> caracteristicas = new ArrayList<>();
		for (CaracteristicaModel c : caracteristicaService.caracteristicasActivas()) {
			caracteristicas.add(c);
		}
		model.setCaracteristicas(caracteristicas);
		view.addObject("salonModel", model);
		view.addObject("caracteriticasObject", caracteristicas);
		return view;
	}

	@PostMapping("/")
	public ModelAndView save(@Valid @ModelAttribute SalonModel salon, BindingResult bindingResult)  {
		ModelAndView view = new ModelAndView();
		if (bindingResult.hasErrors()) {
			List<String> errors = new ArrayList<>();
			for (ObjectError error : bindingResult.getAllErrors()) {
				if (error.getCode().contains("typeMismatch")) {
					errors.add("El campo " + ((DefaultMessageSourceResolvable) error.getArguments()[0]).getCodes()[1]
							+ " es numérico...");
				} else {
					errors.add(error.getDefaultMessage());
				}
			}

			view.setViewName(SALONES_EDIT);
			view.addObject("salonModel", salon);
			view.addObject("errors", errors);
		} else {
			salonService.guardarSalon(salon);
			view.setViewName(REDIRECT_SALONES);
		}
		return view;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable(value = "id") String id) {
		ModelAndView view = new ModelAndView(SALONES_EDIT);
		SalonModel modelSalon = salonService.buscarSalonById(id);
		modelSalon.setEditar(true);
		ArrayList<CaracteristicaModel> caracteristicas = new ArrayList<>();
		for (CaracteristicaModel c : caracteristicaService.caracteristica()) {
			caracteristicas.add(c);
		}
		modelSalon.setCaracteristicas(caracteristicas);
		view.addObject("salonModel", modelSalon);
		return view;
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") String id) {
		salonService.eliminarSalonById(id);
		return REDIRECT_SALONES;
	}

}
