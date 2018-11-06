package com.ucc.asignacion.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Estado;
import com.ucc.asignacion.repository.IEstadoRepository;
import com.ucc.asignacion.services.IEstadoService;

/**
 * @author andres.arias
 */
@Service
public class EstadoServiceImpl implements IEstadoService {

  private final IEstadoRepository estadoRepository;

  /**
   * Constructor.
   *
   * @param estadoRepository estado repository
   */
  public EstadoServiceImpl(IEstadoRepository estadoRepository) {
    this.estadoRepository = estadoRepository;
  }

  @Override
  public long count() {
    return estadoRepository.count();
  }

  @Override
  public Optional<Estado> findById(int id) {
    return estadoRepository.findById(id);
  }

  @Override
  public void save(Estado newEstado) {
    estadoRepository.save(newEstado);
  }

}
