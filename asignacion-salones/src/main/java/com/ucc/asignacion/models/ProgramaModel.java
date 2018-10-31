package com.ucc.asignacion.models;

public class ProgramaModel {

  private int idPrograma;
  private String nombre;
  private String facultad;
  private String codigo;

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
