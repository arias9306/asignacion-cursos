package com.ucc.asignacion.services;

import java.util.List;


import com.ucc.asignacion.models.SalonModel;

public interface ISalonService {

	List<SalonModel> salon();
	
	void guardarSalon(SalonModel salon);
	
	SalonModel buscarSalonById(int id);
	
}
