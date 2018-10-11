package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Salon;
import com.ucc.asignacion.models.SalonModel;
import com.ucc.asignacion.repository.ISalonRepository;
import com.ucc.asignacion.services.ISalonService;
import com.ucc.asignacion.util.Converts;

@Service
public class SalonServiceImpl implements ISalonService {

	public final ISalonRepository salonRepository;

	@Autowired
	public SalonServiceImpl(ISalonRepository salonRepository) {
		this.salonRepository = salonRepository;
	}

	@Override
	public List<SalonModel> salon() {
		List<SalonModel> salonModel = new ArrayList<SalonModel>();
		Iterable<Salon> salon = salonRepository.findAll();
		if (salon != null) {
			salon.forEach(x -> salonModel.add(Converts.convertsalonToSalonModel(x)));
		}
		return salonModel;
	}

	@Override
	public void guardarSalon(SalonModel salon) {
		// TODO Auto-generated method stub

	}

	@Override
	public SalonModel buscarSalonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
