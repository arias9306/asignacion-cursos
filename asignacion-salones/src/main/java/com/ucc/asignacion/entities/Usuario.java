package com.ucc.asignacion.entities;

import java.io.Serializable;
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

/**
 * The persistent class for the usuario database table.
 */
@Entity
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USUARIO")
	private int idUsuario;

	@Column(name = "CAMBIO_PASSWORD")
	private boolean cambioPassword;

	private int codigo;

	private String correo;

	private String estado;

	@Column(name = "NRO_IDENTIFICACION")
	private int nroIdentificacion;

	private String password;

	@Column(name = "PRIMER_APELLIDO")
	private String primerApellido;

	@Column(name = "PRIMER_NOMBRE")
	private String primerNombre;

	@Column(name = "SEGUNDO_APELLIDO")
	private String segundoApellido;

	@Column(name = "SEGUNDO_NOMBRE")
	private String segundoNombre;

	private String telefono;

	// bi-directional many-to-one association to Auditoria
	@OneToMany(mappedBy = "usuario")
	private List<Auditoria> auditorias;

	// bi-directional many-to-one association to Peticion
	@OneToMany(mappedBy = "usuario")
	private List<Peticion> peticions;

	// bi-directional many-to-one association to Programa
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PROGRAMA")
	private Programa programa;

	// bi-directional many-to-one association to Rol
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_ROL")
	private Rol rol;

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public boolean getCambioPassword() {
		return this.cambioPassword;
	}

	public void setCambioPassword(boolean cambioPassword) {
		this.cambioPassword = cambioPassword;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNroIdentificacion() {
		return this.nroIdentificacion;
	}

	public void setNroIdentificacion(int nroIdentificacion) {
		this.nroIdentificacion = nroIdentificacion;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrimerApellido() {
		return this.primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getPrimerNombre() {
		return this.primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoApellido() {
		return this.segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getSegundoNombre() {
		return this.segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Auditoria> getAuditorias() {
		return this.auditorias;
	}

	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

	public List<Peticion> getPeticions() {
		return this.peticions;
	}

	public void setPeticions(List<Peticion> peticions) {
		this.peticions = peticions;
	}

	public Peticion addPeticion(Peticion peticion) {
		getPeticions().add(peticion);
		peticion.setUsuario(this);

		return peticion;
	}

	public Peticion removePeticion(Peticion peticion) {
		getPeticions().remove(peticion);
		peticion.setUsuario(null);

		return peticion;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public Rol getRol() {
		return this.rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

}