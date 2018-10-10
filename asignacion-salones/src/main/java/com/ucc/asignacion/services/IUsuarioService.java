package com.ucc.asignacion.services;
import java.util.List;


import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.UsuarioModel;

public interface IUsuarioService {

	Usuario buscarUsuarioLogin(String correo, String pass);
    Usuario recuperarPassword(String correo);
	
}
