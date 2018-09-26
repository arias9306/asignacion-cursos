package com.ucc.asignacion.models;

public class RolModel {

	private int idRol;
	private String descripcion;

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

}
