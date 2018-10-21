package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.models.SalonModel;

public interface ISalonService {

	List<SalonModel> salones();

	void guardarSalon(SalonModel salon);

	SalonModel buscarSalonById(String id);

	void eliminarSalonById(String id);

}
