package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Auditoria;
import com.ucc.asignacion.models.AuditoriaModel;
import com.ucc.asignacion.repository.IAuditoriaRepository;
import com.ucc.asignacion.services.IAuditoriaService;
import com.ucc.asignacion.util.Converts;

@Service
public class AuditoriaServiceImpl implements IAuditoriaService {
	
	private final IAuditoriaRepository auditoriaRepository;
	
@Autowired
	public AuditoriaServiceImpl(IAuditoriaRepository auditoriaRepository) {
	
		this.auditoriaRepository = auditoriaRepository;
	}


	@Override
	public List<AuditoriaModel> auditoria() {
		// TODO Auto-generated method stub
 		List<AuditoriaModel> auditoriaModel = new ArrayList<AuditoriaModel>();
		Iterable<Auditoria> auditoria = auditoriaRepository.findAll();
		if(auditoria != null) {
			auditoria.forEach(auditori-> auditoriaModel.add(Converts.convertAuditoriaToAuditoriaModel(auditori)));
		}
		
		return auditoriaModel;
	}
	
	
	
	
	

}
