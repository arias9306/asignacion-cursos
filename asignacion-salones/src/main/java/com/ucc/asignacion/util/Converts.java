package com.ucc.asignacion.util;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.models.UsuarioModel;

public class Converts {

	/**
	 * Metodo para convertir {@link Rol} a {@link RolModel}.
	 * 
	 * @param rol entidad
	 * @return modelo de rol
	 */
	public static RolModel convertRolToRolModel(Rol rol) {
		RolModel model = null;
		if (rol != null) {
			model = new RolModel(rol.getIdRol(), rol.getNombre());
		}
		return model;
	}

	public static UsuarioModel convertUsuarioToUsuarioModel(Usuario usuario) {
		UsuarioModel model = null;
		if (usuario != null) {
			model = new UsuarioModel();
			model.setIdUser(usuario.getIdUsuario());
			model.setPrimerNombre(usuario.getPrimerNombre());
			model.setSegundoNombre(usuario.getSegundoNombre());
			model.setPrimerApellido(usuario.getPrimerApellido());
			model.setSegundoApellido(usuario.getSegundoApellido());
			model.setCorreo(usuario.getCorreo());
			model.setCodigo(usuario.getCodigo());
			model.setNroIdentificacion(usuario.getNroIdentificacion());
			model.setTelefono(usuario.getTelefono());
			model.setPassword(usuario.getPassword());
			model.setCambioPassw(usuario.getCambioPassword());
			model.setEstado(usuario.getEstado());
			model.setIdRol(usuario.getRol().getIdRol());
			model.setIdPrograma(usuario.getPrograma().getIdPrograma());
			
		}
		return model;
	}

	/**
	 * Metodo para convertir {@link RolModel} a {@link Rol}
	 * 
	 * @param rolModel modelo
	 * @return entidad
	 */
	public static Rol convertRolModelToRol(RolModel rolModel) {
		Rol rol = null;
		if (rolModel != null) {
			rol = new Rol();
			rol.setIdRol(rolModel.getIdRol());
			rol.setNombre(rolModel.getDescripcion());
		}
		return rol;
	}

	public static Usuario convertUsuarioModelToUsuario(UsuarioModel usuarioModel) {

		Usuario usuario = null;
		if (usuarioModel != null) {
			usuario = new Usuario();
			usuario.setIdUsuario(usuarioModel.getIdUser());
			usuario.setPrimerNombre(usuarioModel.getPrimerNombre());
			usuario.setSegundoNombre(usuarioModel.getSegundoNombre());
			usuario.setPrimerApellido(usuarioModel.getPrimerApellido());
			usuario.setSegundoApellido(usuarioModel.getSegundoApellido());

		}

		return usuario;

	}

}
