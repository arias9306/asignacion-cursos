package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.models.PeticionModel;

public interface IPeticionService {

  long numeroSalonesOcupados();

  List<PeticionModel> obtenerSolicitudes();
  
  void crearPeticion(PeticionModel peticionModel);
}
