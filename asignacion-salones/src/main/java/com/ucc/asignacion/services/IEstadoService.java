package com.ucc.asignacion.services;

import java.util.Optional;

import com.ucc.asignacion.entities.Estado;

/**
 * @author andres.arias
 *
 */
public interface IEstadoService {

  /**
   * @author: Andrés Arias
   * @since: 6/11/2018 9:40:23 a. m.
   *
   * @return
   */
  long count();

  /**
   * @author: Andrés Arias
   * @since: 6/11/2018 9:41:31 a. m.
   *
   * @param id
   * @return
   */
  Optional<Estado> findById(int id);

  /**
   * @author: Andrés Arias
   * @since: 6/11/2018 9:43:18 a. m.
   *
   * @param newEstado
   */
  void save(Estado newEstado);

}
