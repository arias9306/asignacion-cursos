package com.ucc.asignacion.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ProgramaModel {

  private int idPrograma;
  @NotNull(message = "El nombre no puede ser nulo...")
  @NotBlank(message = "El nombre no puede estar vacio...")
  private String nombre;
  @NotNull(message = "La facultad no puede ser nulo...")
  @NotBlank(message = "La facultad no puede estar vacio...")
  private String facultad;
  @NotNull(message = "El codigo no puede ser nulo...")
  @NotBlank(message = "El codigo no puede estar vacio...")
  @Size(min = 2, max = 10, message = "El código no es valido, debe tener entre dos y maximo diez caracteres.")
  private String codigo;
  private boolean editar;

  public boolean isEditar() {
	return editar;
}

public void setEditar(boolean editar) {
	this.editar = editar;
}

public ProgramaModel() {
  }

  public int getIdPrograma() {
    return idPrograma;
  }

  public void setIdPrograma(int idPrograma) {
    this.idPrograma = idPrograma;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getFacultad() {
    return facultad;
  }

  public void setFacultad(String facultad) {
    this.facultad = facultad;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

}
