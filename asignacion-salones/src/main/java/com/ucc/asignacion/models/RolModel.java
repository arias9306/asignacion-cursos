package com.ucc.asignacion.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RolModel {

	private int idRol;

	@NotNull(message = "la descripción no puede ser nula..")
	@NotBlank(message = "la descripción no puede estar vacia..")
	private String descripcion;

	private boolean editar;

	public RolModel() {

	}

	public RolModel(int idRol, String descripcion) {
		this.idRol = idRol;
		this.descripcion = descripcion;
	}

	/**
	 * @return the idRol
	 */
	public int getIdRol() {
		return idRol;
	}

	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

}
