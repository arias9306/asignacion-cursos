package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.models.PeticionModel;
import com.ucc.asignacion.repository.IPeticionRepository;
import com.ucc.asignacion.services.IPeticionService;
import com.ucc.asignacion.util.EnumEstadoPeticion;

@Service
public class PeticionServiceImpl implements IPeticionService {

  private final IPeticionRepository peticionRepository;

  @Autowired
  public PeticionServiceImpl(IPeticionRepository peticionRepository) {
    this.peticionRepository = peticionRepository;
  }

  @Override
  public long numeroSalonesOcupados() {
    return peticionRepository.numeroSalonesByEstado(EnumEstadoPeticion.ASIGNADO.getId());
  }

  @Override
  public List<PeticionModel> obtenerSolicitudes() {
    return new ArrayList<>();
  }

  @Override
  public void crearPeticion(PeticionModel peticionModel) {
    // TODO Auto-generated method stub
    System.err.println(peticionModel);

  }
}
