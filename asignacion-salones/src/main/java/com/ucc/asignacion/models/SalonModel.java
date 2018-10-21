package com.ucc.asignacion.models;

public class SalonModel {

	private int idSalon;

	private int bloque;

	private int codigo;

	private String descripcion;

	private boolean estado;

	private String tipo;

	public SalonModel() {
		this.idSalon = idSalon;
		this.bloque = bloque;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.estado = estado;
		this.tipo = tipo;
	}

	public int getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public int getBloque() {
		return bloque;
	}

	public void setBloque(int bloque) {
		this.bloque = bloque;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
