package com.ucc.asignacion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the implementos_x_peticion database table.
 */
@Entity
@Table(name="implementos_x_peticion")
public class ImplementosXPeticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_IMPLEMENTOS_X_PETICION")
	private int idImplementosXPeticion;

	private int cantidad;

	//bi-directional many-to-one association to Implemento
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_IMPLEMENTO")
	private Implemento implemento;

	//bi-directional many-to-one association to Peticion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PETICION")
	private Peticion peticion;

	public ImplementosXPeticion() {
	}

	public int getIdImplementosXPeticion() {
		return this.idImplementosXPeticion;
	}

	public void setIdImplementosXPeticion(int idImplementosXPeticion) {
		this.idImplementosXPeticion = idImplementosXPeticion;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Implemento getImplemento() {
		return this.implemento;
	}

	public void setImplemento(Implemento implemento) {
		this.implemento = implemento;
	}

	public Peticion getPeticion() {
		return this.peticion;
	}

	public void setPeticion(Peticion peticion) {
		this.peticion = peticion;
	}

}