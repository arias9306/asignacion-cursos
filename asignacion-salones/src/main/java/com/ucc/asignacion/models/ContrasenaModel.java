package com.ucc.asignacion.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ContrasenaModel {

	@NotNull(message = "La contraseña no puede ser nulo...")
	@NotBlank(message = "La contraseña no puede ser vacio...")
	private String nuevaPassword;
	@NotNull(message = "La contraseña no puede ser nulo...")
	@NotBlank(message = "La contraseña no puede ser vacio...")
	private String confirmacionPassword;
	
	public String getNuevaPassword() {
		return nuevaPassword;
	}
	public void setNuevaPassword(String nuevaPassword) {
		this.nuevaPassword = nuevaPassword;
	}
	public String getConfirmacionPassword() {
		return confirmacionPassword;
	}
	public void setConfirmacionPassword(String confirmacionPassword) {
		this.confirmacionPassword = confirmacionPassword;
	}
	
	
	
}
