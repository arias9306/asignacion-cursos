package com.ucc.asignacion.util;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Salon;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.models.SalonModel;

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

	/**
	 * Metodo para convertir SalonModel a Salon
	 * 
	 * @param salonModel
	 * @return
	 */
	public static Salon convertSalonModelToSalon(SalonModel salonModel) {
		Salon salon = null;
		if (salonModel != null) {
			salon = new Salon();
			salon.setIdSalon(salonModel.getIdSalon());
			salon.setBloque(salonModel.getBloque());
			salon.setCodigo(salonModel.getCodigo());
			salon.setDescripcion(salonModel.getDescripcion());
			salon.setEstado(salonModel.isEstado());
			salon.setTipo(salonModel.getTipo());
		}
		return salon;
	}

	/**
	 * Metodo para convertir salon a SalonModel
	 * 
	 * @param salon
	 * @return
	 */

	public static SalonModel convertsalonToSalonModel(Salon salon) {
		SalonModel model = null;
		if (salon != null) {
			model = new SalonModel();
			model.setIdSalon(salon.getIdSalon());
			model.setBloque(salon.getBloque());
			model.setCodigo(salon.getCodigo());
			model.setDescripcion(salon.getDescripcion());
			model.setEstado(salon.getEstado());
			model.setTipo(salon.getTipo());
		}
		return model;
	}
}
