package com.ucc.asignacion.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


/**
 * The persistent class for the estado database table.
 */
@Entity
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ESTADO")
	private int idEstado;

	private String descripcion;

	//bi-directional many-to-one association to Peticion
	@OneToMany(mappedBy="estado")
	private List<Peticion> peticions;

	public Estado() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Peticion> getPeticions() {
		return this.peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	public Peticion addPeticion(Peticion peticion) {
		getPeticions().add(peticion);
		peticion.setEstado(this);

		return peticion;
	}

	public Peticion removePeticion(Peticion peticion) {
		getPeticions().remove(peticion);
		peticion.setEstado(null);

		return peticion;
	}

}