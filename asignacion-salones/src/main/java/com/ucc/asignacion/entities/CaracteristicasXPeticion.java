package com.ucc.asignacion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caracteristicas_x_peticion database table.
 */
@Entity
@Table(name="caracteristicas_x_peticion")
public class CaracteristicasXPeticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CARACTERISTICAS_X_PETICION")
	private int idCaracteristicasXPeticion;

	private String valor;

	//bi-directional many-to-one association to Caracteristica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARACTERISTICAS")
	private Caracteristica caracteristica;

	//bi-directional many-to-one association to Peticion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PETICION")
	private Peticion peticion;

	public CaracteristicasXPeticion() {
	}

	public int getIdCaracteristicasXPeticion() {
		return this.idCaracteristicasXPeticion;
	}

	public void setIdCaracteristicasXPeticion(int idCaracteristicasXPeticion) {
		this.idCaracteristicasXPeticion = idCaracteristicasXPeticion;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Caracteristica getCaracteristica() {
		return this.caracteristica;
	}

	public void setCaracteristica(Caracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	public Peticion getPeticion() {
		return this.peticion;
	}

	public void setPeticion(Peticion peticion) {
		this.peticion = peticion;
	}

}