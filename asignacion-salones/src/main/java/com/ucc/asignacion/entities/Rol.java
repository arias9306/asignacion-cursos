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
 * The persistent class for the rol database table.
 */
@Entity
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_ROL")
	private int idRol;

	private String nombre;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="rol")
	private List<Usuario> usuarios;

	public Rol() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setRol(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setRol(null);

		return usuario;
	}

}