package com.ucc.asignacion.repository;

import org.springframework.data.repository.CrudRepository;

import com.ucc.asignacion.entities.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {

	Usuario findByCorreoAndPassword(String correo, String password);
	Usuario findByCorreo(String correo);
	Usuario findByPrimerApellido(String PrimerApellido);
}
