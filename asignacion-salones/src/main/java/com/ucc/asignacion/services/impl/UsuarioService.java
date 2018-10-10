package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.repository.IUsuarioRepository;
import com.ucc.asignacion.services.IUsuarioService;

@Service
public class UsuarioService implements IUsuarioService {

	private final IUsuarioRepository usuarioRepository;

	@Autowired
	public UsuarioService(IUsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario buscarUsuarioLogin(String correo, String pass) {
		return usuarioRepository.findByCorreoAndPassword(correo, pass);
	}

	@Override
	public Usuario recuperarPassword(String correo) {
		
		return usuarioRepository.findByCorreo(correo);
	}

	@Override
	public Usuario buscarUsuarioPrimerApellido(String primerApellido) {
		
		return usuarioRepository.findByPrimerApellido(primerApellido);
	}
	
	

	
	

}
