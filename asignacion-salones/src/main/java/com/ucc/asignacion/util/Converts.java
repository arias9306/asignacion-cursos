package com.ucc.asignacion.util;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.models.RolModel;

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

}
