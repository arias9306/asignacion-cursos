package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.repository.IRolRepository;
import com.ucc.asignacion.services.IRolService;
import com.ucc.asignacion.util.Converts;

@Service
public class RolServiceImpl implements IRolService {

	private final IRolRepository rolRepository;

	@Autowired
	public RolServiceImpl(IRolRepository rolRepository) {
		this.rolRepository = rolRepository;
	}

	@Override
	public List<RolModel> roles() {
		List<RolModel> rolsModel = new ArrayList<RolModel>() ;
		Iterable<Rol> roles = rolRepository.findAll();
		if (roles != null) {
			roles.forEach(rol -> rolsModel.add(Converts.convertRolToRolModel(rol)));
		}
		return rolsModel;
	}

}
