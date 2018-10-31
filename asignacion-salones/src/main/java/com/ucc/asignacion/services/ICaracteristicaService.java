package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.models.CaracteristicaModel;

public interface ICaracteristicaService {

  List<CaracteristicaModel> caracteristica();

  void guardarCaracteristica(CaracteristicaModel caracteristica);

  CaracteristicaModel buscarCaractById(String id);

  void eliminarCaractById(String id);
  
  List<CaracteristicaModel> caracteristicasActivas();
  
}
