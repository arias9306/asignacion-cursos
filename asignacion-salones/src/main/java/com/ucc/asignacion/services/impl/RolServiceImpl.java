package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.repository.IRolRepository;
import com.ucc.asignacion.services.IRolService;
import com.ucc.asignacion.util.Converts;

@Service
public class RolServiceImpl implements IRolService {

  private final IRolRepository rolRepository;

  @Autowired
  public RolServiceImpl(IRolRepository rolRepository) {
    this.rolRepository = rolRepository;
  }

  @Override
  public List<RolModel> roles() {
    List<RolModel> rolsModel = new ArrayList<RolModel>();
    Iterable<Rol> roles = rolRepository.findAll();
    if (roles != null) {
      roles.forEach(rol -> rolsModel.add(Converts.convertRolToRolModel(rol)));
    }
    return rolsModel;
  }

  @Override
  public void guardarRol(RolModel rol) {
    // si el idrol es diferente de 0, entonces ya existe en la base
    if (rol.getIdRol() != 0) {
      //Consulto el rol ya guardado
      Optional<Rol> rolEntity = rolRepository.findById(rol.getIdRol());
      if (rolEntity.isPresent()) {
        //Actualizo los valores que se pueden actualizar (el id NO)
        Rol updateRol = rolEntity.get();
        updateRol.setNombre(rol.getDescripcion());
        rolRepository.save(updateRol);
      }
    }
    else {
      // si el idrol es 0 es nuevo
      rolRepository.save(Converts.convertRolModelToRol(rol));
    }
  }

  @Override
  public RolModel buscarRolById(String id) {
    Optional<Rol> rol = rolRepository.findById(Integer.parseInt(id));
    if (rol.isPresent()) {
      return Converts.convertRolToRolModel(rol.get());
    }
    return new RolModel();
  }

  @Override
  public void eliminarRolById(String id) {
    rolRepository.deleteById(Integer.parseInt(id));
  }

  @Override
  public RolModel buscarByNombre(String rol) {
    return Converts.convertRolToRolModel(rolRepository.findByNombre(rol));
  }

}
