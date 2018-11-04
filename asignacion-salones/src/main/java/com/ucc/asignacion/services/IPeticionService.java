package com.ucc.asignacion.services;

import com.ucc.asignacion.models.PeticionModel;

import java.util.List;

public interface IPeticionService {

    int numeroSalonesOcupados();

    List<PeticionModel> obtenerSolicitudes();
}
