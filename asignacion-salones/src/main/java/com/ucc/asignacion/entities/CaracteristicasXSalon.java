package com.ucc.asignacion.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the caracteristicas_x_salon database table.
 */
@Entity
@Table(name="caracteristicas_x_salon")
public class CaracteristicasXSalon implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CARACTERISTICAS_X_SALON")
	private int idCaracteristicasXSalon;

	private String valor;

	//bi-directional many-to-one association to Caracteristica
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_CARACTERISTICAS")
	private Caracteristica caracteristica;

	//bi-directional many-to-one association to Salon
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SALON")
	private Salon salon;

	public CaracteristicasXSalon() {
	}

	public int getIdCaracteristicasXSalon() {
		return this.idCaracteristicasXSalon;
	}

	public void setIdCaracteristicasXSalon(int idCaracteristicasXSalon) {
		this.idCaracteristicasXSalon = idCaracteristicasXSalon;
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

	public Salon getSalon() {
		return this.salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

}