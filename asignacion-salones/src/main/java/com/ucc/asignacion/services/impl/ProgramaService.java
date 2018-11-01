package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Programa;
import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.ProgramaModel;
import com.ucc.asignacion.repository.IProgramaRepository;
import com.ucc.asignacion.services.IProgramaService;
import com.ucc.asignacion.util.Converts;

@Service
public class ProgramaService implements IProgramaService {

	private final IProgramaRepository programaRepository;

	@Autowired
	public ProgramaService(IProgramaRepository programaRespository) {
		this.programaRepository = programaRespository;
	}

	@Override
	public List<ProgramaModel> programas() {
		List<ProgramaModel> programasModel = new ArrayList<ProgramaModel>();
		Iterable<Programa> programas = programaRepository.findAll();
		if (programas != null) {
			programas.forEach(programa -> programasModel.add(Converts.convertprogramaToProgramaModel(programa)));
		}
		return programasModel;
	}

	@Override
	public ProgramaModel buscarByNombre(String nombre) {
		Programa programa = programaRepository.findByNombre(nombre);
		return Converts.convertprogramaToProgramaModel(programa);
	}

	@Override
	public void guardarPrograma(ProgramaModel programa) {
		if (programa.getIdPrograma() != 0) {
			Optional<Programa> programaEntity = programaRepository.findById(programa.getIdPrograma());
			if (programaEntity.isPresent()) {
				Programa updatePrograma = programaEntity.get();
				updatePrograma.setCodigo(programa.getCodigo());
				updatePrograma.setFacultad(programa.getFacultad());
				updatePrograma.setNombre(programa.getNombre());
			}
		} else {
			programaRepository.save(Converts.convertProgramaModelToPrograma(programa));
		}

	}

}
