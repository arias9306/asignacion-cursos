package com.ucc.asignacion.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ucc.asignacion.entities.Caracteristica;

public interface ICaracteristicaRepository extends CrudRepository<Caracteristica, Integer> {
	
	List<Caracteristica> findByEstadoTrue();

}
