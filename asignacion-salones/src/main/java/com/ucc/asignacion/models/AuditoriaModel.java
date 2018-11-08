package com.ucc.asignacion.models;

import java.util.Date;

public class AuditoriaModel {
	
	private String AntiguoValor;
	private Date fechaModificacion;
	private String nuevoValor;
	private String tabla;
	private String Accion;
	
	
	public AuditoriaModel() {
		// TODO Auto-generated constructor stub
	}

	public String getAntiguoValor() {
		return AntiguoValor;
	}


	public void setAntiguoValor(String antiguoValor) {
		AntiguoValor = antiguoValor;
	}


	public Date getFechaModificacion() {
		return fechaModificacion;
	}


	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}


	public String getNuevoValor() {
		return nuevoValor;
	}


	public void setNuevoValor(String nuevoValor) {
		this.nuevoValor = nuevoValor;
	}


	public String getTabla() {
		return tabla;
	}


	public void setTabla(String tabla) {
		this.tabla = tabla;
	}


	public String getAccion() {
		return Accion;
	}


	public void setAccion(String accion) {
		Accion = accion;
	}
	
	
	
	

}
