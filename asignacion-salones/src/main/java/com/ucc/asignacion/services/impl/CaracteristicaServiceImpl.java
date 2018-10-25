
package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Caracteristica;
import com.ucc.asignacion.models.CaracteristicaModel;
import com.ucc.asignacion.repository.ICaracteristicaRepository;
import com.ucc.asignacion.services.ICaracteristicaService;
import com.ucc.asignacion.util.Converts;

@Service
public class CaracteristicaServiceImpl implements ICaracteristicaService {

	private final ICaracteristicaRepository caracteristicaRepository;

	@Autowired
	public CaracteristicaServiceImpl(ICaracteristicaRepository caracteristicaRepository) {
		this.caracteristicaRepository = caracteristicaRepository;
	}

	@Override
	public List<CaracteristicaModel> caracteristica() {
		// TODO Auto-generated method stub
		
		List<CaracteristicaModel> caracteristicaModel = new ArrayList<CaracteristicaModel>();
		Iterable<Caracteristica> caracteristica = caracteristicaRepository.findAll();
		if(caracteristica != null) {
			caracteristica.forEach(caracteris-> caracteristicaModel.add(Converts.convertCaracteristicaToCaracteristicaModel(caracteris)));
		}
		
		return caracteristicaModel;
	}

	@Override
	public void guardarCaracteristica(CaracteristicaModel caracteristica) {
		// TODO Auto-generated method stub
		// si el idrol es diferente de 0, entonces ya existe en la base
				if (caracteristica.getIdCaracteristica() != 0) {
					//Consulto el rol ya guardado
					Optional<Caracteristica> caracteristicaEntity = caracteristicaRepository.findById(caracteristica.getIdCaracteristica());
					if (caracteristicaEntity.isPresent()) {
						//Actualizo los valores que se pueden actualizar (el id NO)
						Caracteristica updateCaracteristica = caracteristicaEntity.get();
						updateCaracteristica.setNombre(caracteristica.getNombre());
						updateCaracteristica.setEstado(caracteristica.isEstado());
						caracteristicaRepository.save(updateCaracteristica);
					}
				} else {
					// si el idrol es 0 es nuevo
					caracteristicaRepository.save(Converts.convertCaracteriscitcaModelToCaracteristica(caracteristica));
				}
	}

	@Override
	public CaracteristicaModel buscarCaractById(String id) {
		Optional<Caracteristica> caracteristica = caracteristicaRepository.findById(Integer.valueOf(id));
		if(caracteristica.isPresent()) {
			return Converts.convertCaracteristicaToCaracteristicaModel(caracteristica.get());
		}
		return null ;
	}

	@Override
	public void eliminarCaractById(String id) {
		caracteristicaRepository.deleteById(Integer.parseInt(id));
		
		
		
		// TODO Auto-generated method stub

	}

}
