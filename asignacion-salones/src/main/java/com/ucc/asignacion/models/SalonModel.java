package com.ucc.asignacion.models;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class SalonModel {

	private int idSalon;

	private int bloque;

	@NotNull(message = "El codigo no puede ser nulo...")
	@Min(value = 1, message = "El codigo no puede ser cero..")
	private int codigo;

	private String descripcion;

	@NotNull(message = "El estado no puede ser nulo...")
	private boolean estado;

	@NotNull(message = "El tipo no puede ser nulo...")
	@NotBlank(message = "El tipo no puede estar vacio")
	private String tipo;

	private boolean editar;

	private List<CaracteristicaModel> caracteristicas;

	public SalonModel() {

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

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public List<CaracteristicaModel> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(List<CaracteristicaModel> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

}
