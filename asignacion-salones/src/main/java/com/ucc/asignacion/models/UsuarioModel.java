package com.ucc.asignacion.models;

public class UsuarioModel {
	
	private String correo;
	private String password;
	private int idUser;
	private String estado;
	private boolean cambioPassw;
	
	
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public boolean isCambioPassw() {
		return cambioPassw;
	}
	public void setCambioPassw(boolean cambioPassw) {
		this.cambioPassw = cambioPassw;
	}
	
	
	
	

	
	

}
