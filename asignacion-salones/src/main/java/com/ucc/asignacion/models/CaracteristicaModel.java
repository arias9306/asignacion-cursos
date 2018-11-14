package com.ucc.asignacion.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CaracteristicaModel {

	private int idcaracteristica;
//	@NotBlank(message = "El nombre es obligatorio...")
//	@NotNull(message = "El nombre es obligatorio...")
	private String nombre;
//	@NotNull(message = "El estado es obligatorio...")
//	@NotBlank(message = "El estado es obligatorio...")
	private String estado;
	private boolean editar;
	private Integer cantidad;
	private boolean seleccionada;

	public CaracteristicaModel(int idcaracteristica, String nombre, String estado) {
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
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

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public boolean isSeleccionada() {
		return seleccionada;
	}

	public void setSeleccionada(boolean seleccionada) {
		this.seleccionada = seleccionada;
	}
	
	
	

}
