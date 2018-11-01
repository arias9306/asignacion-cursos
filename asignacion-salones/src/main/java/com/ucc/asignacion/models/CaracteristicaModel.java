package com.ucc.asignacion.models;

public class CaracteristicaModel {

	private int idcaracteristica;
	private String nombre;
	private boolean estado;
	private boolean editar;
	
	public CaracteristicaModel(int idcaracteristica, String nombre, boolean estado) {
		super();
		this.idcaracteristica = idcaracteristica;
		this.nombre = nombre;
		this.estado = estado;
	}

	public int getIdcaracteristica() {
		return idcaracteristica;
	}

	public void setIdcaracteristica(int idcaracteristica) {
		this.idcaracteristica = idcaracteristica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public CaracteristicaModel() {
		// TODO Auto-generated constructor stub
	}

}
