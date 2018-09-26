package com.ucc.asignacion.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the implemento database table.
 */
@Entity
public class Implemento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_IMPLEMENTO")
	private int idImplemento;

	private boolean activo;

	private int cantidad;

	private String nombre;

	//bi-directional many-to-one association to ImplementosXPeticion
	@OneToMany(mappedBy="implemento")
	private List<ImplementosXPeticion> implementosXPeticions;

	public Implemento() {
	}

	public int getIdImplemento() {
		return this.idImplemento;
	}

	public void setIdImplemento(int idImplemento) {
		this.idImplemento = idImplemento;
	}

	public boolean getActivo() {
		return this.activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public int getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<ImplementosXPeticion> getImplementosXPeticions() {
		return this.implementosXPeticions;
	}

	public void setImplementosXPeticions(List<ImplementosXPeticion> implementosXPeticions) {
		this.implementosXPeticions = implementosXPeticions;
	}

	public ImplementosXPeticion addImplementosXPeticion(ImplementosXPeticion implementosXPeticion) {
		getImplementosXPeticions().add(implementosXPeticion);
		implementosXPeticion.setImplemento(this);

		return implementosXPeticion;
	}

	public ImplementosXPeticion removeImplementosXPeticion(ImplementosXPeticion implementosXPeticion) {
		getImplementosXPeticions().remove(implementosXPeticion);
		implementosXPeticion.setImplemento(null);

		return implementosXPeticion;
	}

}