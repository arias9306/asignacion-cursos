package com.ucc.asignacion.repository;

import org.springframework.data.repository.CrudRepository;

import com.ucc.asignacion.entities.Programa;

public interface IProgramaRepository extends CrudRepository<Programa, Integer> {

  Programa findByNombre(String nombre);

}
