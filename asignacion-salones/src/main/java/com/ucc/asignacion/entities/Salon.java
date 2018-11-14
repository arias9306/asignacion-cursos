package com.ucc.asignacion.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * The persistent class for the salon database table.
 */
@Entity
public class Salon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_SALON")
	private int idSalon;

	private int bloque;

	private int codigo;

	private String descripcion;

	private boolean estado;

	private String tipo;

	// bi-directional many-to-one association to CaracteristicasXSalon
	@OneToMany(mappedBy = "salon", cascade = CascadeType.REMOVE)
	private List<CaracteristicasXSalon> caracteristicasXSalons;

	// bi-directional many-to-one association to Peticion
	@OneToMany(mappedBy = "salon")
	private List<Peticion> peticions;

	public Salon() {
	}

	public int getIdSalon() {
		return this.idSalon;
	}

	public void setIdSalon(int idSalon) {
		this.idSalon = idSalon;
	}

	public int getBloque() {
		return this.bloque;
	}

	public void setBloque(int bloque) {
		this.bloque = bloque;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getEstado() {
		return this.estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<CaracteristicasXSalon> getCaracteristicasXSalons() {
		return this.caracteristicasXSalons;
	}

	public void setCaracteristicasXSalons(List<CaracteristicasXSalon> caracteristicasXSalons) {
		this.caracteristicasXSalons = caracteristicasXSalons;
	}

	public CaracteristicasXSalon addCaracteristicasXSalon(CaracteristicasXSalon caracteristicasXSalon) {
		getCaracteristicasXSalons().add(caracteristicasXSalon);
		caracteristicasXSalon.setSalon(this);

		return caracteristicasXSalon;
	}

	public CaracteristicasXSalon removeCaracteristicasXSalon(CaracteristicasXSalon caracteristicasXSalon) {
		getCaracteristicasXSalons().remove(caracteristicasXSalon);
		caracteristicasXSalon.setSalon(null);

		return caracteristicasXSalon;
	}

	public List<Peticion> getPeticions() {
		return this.peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	public Peticion addPeticion(Peticion peticion) {
		getPeticions().add(peticion);
		peticion.setSalon(this);

		return peticion;
	}

	public Peticion removePeticion(Peticion peticion) {
		getPeticions().remove(peticion);
		peticion.setSalon(null);

		return peticion;
	}

}