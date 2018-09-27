package com.ucc.asignacion.services;

import com.ucc.asignacion.entities.Usuario;

public interface IUsuarioService {

	Usuario buscarUsuarioLogin(String correo, String pass);
}
