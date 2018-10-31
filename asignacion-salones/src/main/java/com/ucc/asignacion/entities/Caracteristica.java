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
 * The persistent class for the caracteristica database table.
 */
@Entity
public class Caracteristica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CARACTERISTICA")
	private int idCaracteristica;

	private boolean estado;

	private String nombre;

	//bi-directional many-to-one association to CaracteristicasXPeticion
	@OneToMany(mappedBy="caracteristica")
	private List<CaracteristicasXPeticion> caracteristicasXPeticions;

	//bi-directional many-to-one association to CaracteristicasXSalon
	@OneToMany(mappedBy="caracteristica")
	private List<CaracteristicasXSalon> caracteristicasXSalons;

	public Caracteristica() {
	}

	public int getIdCaracteristica() {
		return this.idCaracteristica;
	}

	public void setIdCaracteristica(int idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<CaracteristicasXPeticion> getCaracteristicasXPeticions() {
		return this.caracteristicasXPeticions;
	}

	public void setCaracteristicasXPeticions(List<CaracteristicasXPeticion> caracteristicasXPeticions) {
		this.caracteristicasXPeticions = caracteristicasXPeticions;
	}

	public CaracteristicasXPeticion addCaracteristicasXPeticion(CaracteristicasXPeticion caracteristicasXPeticion) {
		getCaracteristicasXPeticions().add(caracteristicasXPeticion);
		caracteristicasXPeticion.setCaracteristica(this);

		return caracteristicasXPeticion;
	}

	public CaracteristicasXPeticion removeCaracteristicasXPeticion(CaracteristicasXPeticion caracteristicasXPeticion) {
		getCaracteristicasXPeticions().remove(caracteristicasXPeticion);
		caracteristicasXPeticion.setCaracteristica(null);

		return caracteristicasXPeticion;
	}

	public List<CaracteristicasXSalon> getCaracteristicasXSalons() {
		return this.caracteristicasXSalons;
	}

	public void setCaracteristicasXSalons(List<CaracteristicasXSalon> caracteristicasXSalons) {
		this.caracteristicasXSalons = caracteristicasXSalons;
	}

	public CaracteristicasXSalon addCaracteristicasXSalon(CaracteristicasXSalon caracteristicasXSalon) {
		getCaracteristicasXSalons().add(caracteristicasXSalon);
		caracteristicasXSalon.setCaracteristica(this);

		return caracteristicasXSalon;
	}

	public CaracteristicasXSalon removeCaracteristicasXSalon(CaracteristicasXSalon caracteristicasXSalon) {
		getCaracteristicasXSalons().remove(caracteristicasXSalon);
		caracteristicasXSalon.setCaracteristica(null);

		return caracteristicasXSalon;
	}

}