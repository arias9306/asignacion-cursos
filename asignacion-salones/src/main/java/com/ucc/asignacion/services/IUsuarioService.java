package com.ucc.asignacion.services;

import java.util.List;

import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.ContrasenaModel;
import com.ucc.asignacion.models.UsuarioModel;

public interface IUsuarioService {

  List<UsuarioModel> usuarios();

  UsuarioModel buscarUsuarioById(String id);

  Usuario buscarUsuarioLogin(String correo, String pass);

  Usuario recuperarPassword(String correo);
  
  void actualizarPassword(UsuarioModel usuario, ContrasenaModel contra);

  Usuario buscarUsuarioPrimerApellido(String primerApellido);

  void guardarUsuario(UsuarioModel usuario, boolean recordarContrasenia);

  void eliminarUsuarioById(String id);

  UsuarioModel buscarUsuarioByCorreo(String correo);

  long numeroUsuarios();
}
