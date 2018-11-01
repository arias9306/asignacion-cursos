package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.models.ProgramaModel;

public interface IProgramaService {

  List<ProgramaModel> programas();

  void guardarPrograma(ProgramaModel programa);
  
  void eliminarProgramaById(String id);

  ProgramaModel buscarByNombre(String string);
  
  ProgramaModel buscarProgramaById(String id); 

}
