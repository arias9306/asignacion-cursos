package com.ucc.asignacion.util;

/**
 * @author andres.arias
 *
 */
public enum EnumEstadoPeticion {

  /**
   * Estado inicial.
   */
  ENVIADA(1),
  /**
   * Estado cuando es agendado el salon.
   */
  ASIGNADO(2),
  /**
   * Estado cuando es rechazado del salon.
   */
  RECHAZADO(3);

  private int id;

  private EnumEstadoPeticion(int value) {
    this.id = value;
  }

  /**
   * @return id
   */
  public int getId() {
    return id;
  }
}
