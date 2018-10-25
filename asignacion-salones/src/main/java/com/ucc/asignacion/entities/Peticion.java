package com.ucc.asignacion.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the peticion database table.
 */
@Entity
public class Peticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PETICION")
	private int idPeticion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_FINAL")
	private Date fechaFinal;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_INICIO")
	private Date fechaInicio;

	@Column(columnDefinition= "TEXT")
	private String observacion;

	//bi-directional many-to-one association to Agendado
	@OneToMany(mappedBy="peticion")
	private List<Agendado> agendados;

	//bi-directional many-to-one association to CaracteristicasXPeticion
	@OneToMany(mappedBy="peticion")
	private List<CaracteristicasXPeticion> caracteristicasXPeticions;

	//bi-directional many-to-one association to ImplementosXPeticion
	@OneToMany(mappedBy="peticion")
	private List<ImplementosXPeticion> implementosXPeticions;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_ESTADO")
	private Estado estado;

	//bi-directional many-to-one association to Salon
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_SALON")
	private Salon salon;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_USUARIO")
	private Usuario usuario;

	public Peticion() {
	}

	public int getIdPeticion() {
		return this.idPeticion;
	}

	public void setIdPeticion(int idPeticion) {
		this.idPeticion = idPeticion;
	}

	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<Agendado> getAgendados() {
		return this.agendados;
	}

	public void setAgendados(List<Agendado> agendados) {
		this.agendados = agendados;
	}

	public Agendado addAgendado(Agendado agendado) {
		getAgendados().add(agendado);
		agendado.setPeticion(this);

		return agendado;
	}

	public Agendado removeAgendado(Agendado agendado) {
		getAgendados().remove(agendado);
		agendado.setPeticion(null);

		return agendado;
	}

	public List<CaracteristicasXPeticion> getCaracteristicasXPeticions() {
		return this.caracteristicasXPeticions;
	}

	public void setCaracteristicasXPeticions(List<CaracteristicasXPeticion> caracteristicasXPeticions) {
		this.caracteristicasXPeticions = caracteristicasXPeticions;
	}

	public CaracteristicasXPeticion addCaracteristicasXPeticion(CaracteristicasXPeticion caracteristicasXPeticion) {
		getCaracteristicasXPeticions().add(caracteristicasXPeticion);
		caracteristicasXPeticion.setPeticion(this);

		return caracteristicasXPeticion;
	}

	public CaracteristicasXPeticion removeCaracteristicasXPeticion(CaracteristicasXPeticion caracteristicasXPeticion) {
		getCaracteristicasXPeticions().remove(caracteristicasXPeticion);
		caracteristicasXPeticion.setPeticion(null);

		return caracteristicasXPeticion;
	}

	public List<ImplementosXPeticion> getImplementosXPeticions() {
		return this.implementosXPeticions;
	}

	public void setImplementosXPeticions(List<ImplementosXPeticion> implementosXPeticions) {
		this.implementosXPeticions = implementosXPeticions;
	}

	public ImplementosXPeticion addImplementosXPeticion(ImplementosXPeticion implementosXPeticion) {
		getImplementosXPeticions().add(implementosXPeticion);
		implementosXPeticion.setPeticion(this);

		return implementosXPeticion;
	}

	public ImplementosXPeticion removeImplementosXPeticion(ImplementosXPeticion implementosXPeticion) {
		getImplementosXPeticions().remove(implementosXPeticion);
		implementosXPeticion.setPeticion(null);

		return implementosXPeticion;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Salon getSalon() {
		return this.salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}