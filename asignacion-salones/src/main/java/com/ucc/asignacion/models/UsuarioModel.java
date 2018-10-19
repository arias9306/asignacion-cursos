package com.ucc.asignacion.models;

public class UsuarioModel {
	
	private String correo;
	private String password;
	private int idUser;
	private int codigo;
	private int  idRol;
	private int idPrograma;
	private Integer nroIdentificacion;
	private String estado, telefono;
	private String primerApellido, segundoApellido, primerNombre, segundoNombre;
	private boolean cambioPassw;
	
	public UsuarioModel() {
		
		
	}
	
	public UsuarioModel(int idUser, String primerApellido, String segundoApellido, String primerNombre,
			String segundoNombre) {
		super();
		this.idUser = idUser;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
	}
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getIdRol() {
		return idRol;
	}


	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}


	public int getIdPrograma() {
		return idPrograma;
	}


	public void setIdPrograma(int idPrograma) {
		this.idPrograma = idPrograma;
	}


	public Integer getNroIdentificacion() {
		return nroIdentificacion;
	}


	public void setNroIdentificacion(Integer nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}


	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}
	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}
	public String getSegundoApellido() {
		return segundoApellido;
	}
	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}
	public String getPrimerNombre() {
		return primerNombre;
	}
	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
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
