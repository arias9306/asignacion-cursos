package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.models.AuditoriaModel;
import com.ucc.asignacion.models.RolModel;

public interface IAuditoriaService {
	
	List<AuditoriaModel> auditoria();

	AuditoriaModel buscarAuditoriaById(String id);
	

}
