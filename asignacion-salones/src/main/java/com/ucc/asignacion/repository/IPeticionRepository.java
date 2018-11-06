package com.ucc.asignacion.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ucc.asignacion.entities.Peticion;

/**
 * @author andres.arias
 *
 */
public interface IPeticionRepository extends CrudRepository<Peticion, Integer> {

  /**
   * @param estado
   * @return numero de salones por estado.
   */
  @Query("select count(p.idPeticion) from Peticion p WHERE p.estado.id = ?1 ")
  long numeroSalonesByEstado(int estado);
}
