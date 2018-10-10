package com.ucc.asignacion.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.models.SalonModel;
import com.ucc.asignacion.repository.ISalonRepository;
import com.ucc.asignacion.services.ISalonService;

@Service
public class SalonServiceImpl implements ISalonService {
	
	public final ISalonRepository salonRepository;
	

	@Autowired
	public SalonServiceImpl(ISalonRepository salonRepository) {
		this.salonRepository = salonRepository;
			}


	@Override
	public List<SalonModel> consultarSalones() {
		// TODO Auto-generated method stub
		return null;
	}

		
	
}
