package com.ucc.asignacion.models;

public class CaracteristicaModel {

	private int Idcaracteristica;
	private String Nombre;
	private boolean Estado;

	public int getIdCaracteristica() {
		return Idcaracteristica;
	}

	public void setIdCaracteristica(int idcaracteristica) {
		Idcaracteristica = idcaracteristica;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

	public CaracteristicaModel(int idcaracteristica, String nombre, boolean estado) {
		super();
		Idcaracteristica = idcaracteristica;
		Nombre = nombre;
		Estado = estado;
	}

	public CaracteristicaModel() {
		// TODO Auto-generated constructor stub
	}

}
