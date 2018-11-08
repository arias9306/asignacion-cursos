package com.ucc.asignacion.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the auditoria database table.
 */
@Entity
public class Auditoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUDITORIA")
	private int idAuditoria;

	private String accion;

	@Column(name = "ANTIGUO_VALOR", columnDefinition = "TEXT")
	private String antiguoValor;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FECHA_MODIFICACION")
	private Date fechaModificacion;

	@Column(name = "NUEVO_VALOR", columnDefinition = "TEXT")
	private String nuevoValor;

	private String tabla;

	@Column(name = "ID_USUARIO")
	private String usuario;

	public Auditoria() {
	}

	public int getIdAuditoria() {
		return this.idAuditoria;
	}

	public void setIdAuditoria(int idAuditoria) {
		this.idAuditoria = idAuditoria;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getAntiguoValor() {
		return this.antiguoValor;
	}

	public void setAntiguoValor(String antiguoValor) {
		this.antiguoValor = antiguoValor;
	}

	public Date getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getNuevoValor() {
		return this.nuevoValor;
	}

	public void setNuevoValor(String nuevoValor) {
		this.nuevoValor = nuevoValor;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}