package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Salon;
import com.ucc.asignacion.models.RolModel;
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
	public List<SalonModel> salones() {
		List<SalonModel> salonModel = new ArrayList<SalonModel>();
		Iterable<Salon> salon = salonRepository.findAll();
		if (salon != null) {
			salon.forEach(x -> salonModel.add(Converts.convertsalonToSalonModel(x)));
		}
		return salonModel;
	}

	@Override
	public void guardarSalon(SalonModel salon) {
		if (salon.getIdSalon() != 0) {
			Optional<Salon> salonEntity = salonRepository.findById(salon.getIdSalon());
			if (salonEntity.isPresent()) {
				Salon updateSalon = salonEntity.get();
				updateSalon.setCodigo(salon.getCodigo());
				updateSalon.setEstado(salon.isEstado());
				updateSalon.setBloque(salon.getBloque());
				updateSalon.setTipo(salon.getTipo());
				updateSalon.setDescripcion(salon.getDescripcion());
				salonRepository.save(updateSalon);

			}
		} else {
			// si el idrol es 0 es nuevo
			salonRepository.save(Converts.convertSalonModelToSalon(salon));
		}

	}

	@Override
	public SalonModel buscarSalonById(String id) {
		Optional<Salon> salon = salonRepository.findById(Integer.parseInt(id));
		if (salon.isPresent()) {
			return Converts.convertsalonToSalonModel(salon.get());
		}
		return new SalonModel();
	}

	@Override
	public void eliminarSalonById(String id) {
		salonRepository.deleteById(Integer.parseInt(id));

	}

}
