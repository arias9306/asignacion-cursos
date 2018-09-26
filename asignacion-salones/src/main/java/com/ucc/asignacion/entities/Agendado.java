package com.ucc.asignacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the agendado database table.
 */
@Entity
public class Agendado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_AGENDADO")
	private int idAgendado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private Time hora;

	//bi-directional many-to-one association to Peticion
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ID_PETICION")
	private Peticion peticion;

	public Agendado() {
	}

	public int getIdAgendado() {
		return this.idAgendado;
	}

	public void setIdAgendado(int idAgendado) {
		this.idAgendado = idAgendado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHora() {
		return this.hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Peticion getPeticion() {
		return this.peticion;
	}

	public void setPeticion(Peticion peticion) {
		this.peticion = peticion;
	}

}