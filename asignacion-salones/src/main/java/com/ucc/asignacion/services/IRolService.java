package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.models.RolModel;

public interface IRolService {

  List<RolModel> roles();

  void guardarRol(RolModel rol);

  RolModel buscarRolById(String id);

  void eliminarRolById(String id);
}
