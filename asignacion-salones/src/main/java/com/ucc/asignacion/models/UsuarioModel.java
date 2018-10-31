package com.ucc.asignacion.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UsuarioModel {

  @NotNull(message = "El correo no puede ser nulo...")
  @NotBlank(message = "El correo no puede estar vacio...")
  @Email(message = "Debe ingresar un correo valido.")
  private String correo;

  private String password;

  private int idUser;

  @NotNull(message = "El código no puede ser nulo...")
  private int codigo;

  @NotNull(message = "El rol no puede ser nulo...")
  @Min(value = 1, message = "Debe seleccionar un rol...")
  private int idRol;

  @NotNull(message = "El programa no puede ser nulo...")
  @Min(value = 1, message = "Debe seleccionar un programa...")
  private int idPrograma;

  @NotNull(message = "El número de identificación no puede ser nulo...")
  private Integer nroIdentificacion;

  @NotNull(message = "El estado no puede ser nulo...")
  @NotBlank(message = "El estado no puede estar vacio...")
  private String estado;

  @NotNull(message = "El teléfono no puede ser nulo...")
  @NotBlank(message = "El teléfono no puede estar vacio...")
  @Size(min = 7, max = 10, message = "El teléfono no es valido.")
  @Pattern(regexp = "[0-9]+", message = "Ingresar solamente números.")
  private String telefono;

  @NotNull(message = "El primer apellido no puede ser nulo...")
  @NotBlank(message = "El primer apellido no puede estar vacio...")
  private String primerApellido;

  private String segundoApellido;

  @NotNull(message = "El primer nombre no puede ser nulo...")
  @NotBlank(message = "El primer nombre no puede estar vacio...")
  private String primerNombre;

  private String segundoNombre;

  private boolean cambioPassw;

  private boolean editar;

  public UsuarioModel() {

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

  public boolean isEditar() {
    return editar;
  }

  public void setEditar(boolean editar) {
    this.editar = editar;
  }

}
