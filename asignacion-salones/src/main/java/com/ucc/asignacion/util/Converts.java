package com.ucc.asignacion.util;

import com.ucc.asignacion.entities.Auditoria;
import com.ucc.asignacion.entities.Caracteristica;
import com.ucc.asignacion.entities.Programa;
import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Salon;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.AuditoriaModel;
import com.ucc.asignacion.models.CaracteristicaModel;
import com.ucc.asignacion.models.ProgramaModel;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.models.SalonModel;
import com.ucc.asignacion.models.UsuarioModel;

public class Converts {

  /**
   * Metodo para convertir {@link Rol} a {@link RolModel}.
   *
   * @param rol entidad
   * @return modelo de rol
   */
  public static RolModel convertRolToRolModel(Rol rol) {
    RolModel model = null;
    if (rol != null) {
      model = new RolModel(rol.getIdRol(), rol.getNombre());
    }
    return model;
  }

  public static UsuarioModel convertUsuarioToUsuarioModel(Usuario usuario) {
    UsuarioModel model = null;
    if (usuario != null) {
      model = new UsuarioModel();
      model.setIdUser(usuario.getIdUsuario());
      model.setPrimerNombre(usuario.getPrimerNombre());
      model.setSegundoNombre(usuario.getSegundoNombre());
      model.setPrimerApellido(usuario.getPrimerApellido());
      model.setSegundoApellido(usuario.getSegundoApellido());
      model.setCorreo(usuario.getCorreo());
      model.setCodigo(usuario.getCodigo());
      model.setNroIdentificacion(usuario.getNroIdentificacion());
      model.setTelefono(usuario.getTelefono());
      model.setPassword(usuario.getPassword());
      model.setCambioPassw(usuario.getCambioPassword());
      model.setEstado(usuario.getEstado());
      model.setIdRol(
          usuario.getRol()
              .getIdRol());
      model.setIdPrograma(
          usuario.getPrograma()
              .getIdPrograma());

    }
    return model;
  }

  /**
   * Metodo para convertir {@link RolModel} a {@link Rol}
   *
   * @param rolModel modelo
   * @return entidad
   */
  public static Rol convertRolModelToRol(RolModel rolModel) {
    Rol rol = null;
    if (rolModel != null) {
      rol = new Rol();
      rol.setIdRol(rolModel.getIdRol());
      rol.setNombre(rolModel.getDescripcion());
    }
    return rol;
  }

  /**
   * Metodo para convertir SalonModel a Salon
   *
   * @param salonModel
   * @return
   */
  public static Salon convertSalonModelToSalon(SalonModel salonModel) {
    Salon salon = null;
    if (salonModel != null) {
      salon = new Salon();
      salon.setIdSalon(salonModel.getIdSalon());
      salon.setBloque(salonModel.getBloque());
      salon.setCodigo(salonModel.getCodigo());
      salon.setDescripcion(salonModel.getDescripcion());
      salon.setEstado(salonModel.isEstado());
      salon.setTipo(salonModel.getTipo());
    }
    return salon;
  }

  /**
   * Metodo para convertir salon a SalonModel
   *
   * @param salon
   * @return
   */

  public static SalonModel convertsalonToSalonModel(Salon salon) {
    SalonModel model = null;
    if (salon != null) {
      model = new SalonModel();
      model.setIdSalon(salon.getIdSalon());
      model.setBloque(salon.getBloque());
      model.setCodigo(salon.getCodigo());
      model.setDescripcion(salon.getDescripcion());
      model.setEstado(salon.getEstado());
      model.setTipo(salon.getTipo());
    }
    return model;
  }

  public static ProgramaModel convertprogramaToProgramaModel(Programa programa) {
    ProgramaModel model = null;
    if (programa != null) {
      model = new ProgramaModel();
      model.setIdPrograma(programa.getIdPrograma());
      model.setNombre(programa.getNombre());
      model.setFacultad(programa.getFacultad());
      model.setCodigo(programa.getCodigo());
    }

    return model;
  }
  
  public static Programa convertProgramaModelToPrograma(ProgramaModel programaModel) {
	    Programa programa = null;
	    if (programaModel != null) {
	      programa = new Programa();
	      programa.setIdPrograma(programaModel.getIdPrograma());
	      programa.setNombre(programaModel.getNombre());
	      programa.setFacultad(programaModel.getFacultad());
	      programa.setCodigo(programaModel.getCodigo());
	    }
	    return programa;
	  }
  

  public static Usuario convertUsuarioModelToUsuario(UsuarioModel usuarioModel) {
    Usuario usuario = null;
    if (usuarioModel != null) {
      usuario = new Usuario();
      usuario.setIdUsuario(usuarioModel.getIdUser());
      usuario.setPrimerNombre(usuarioModel.getPrimerNombre());
      usuario.setSegundoNombre(usuarioModel.getSegundoNombre());
      usuario.setPrimerApellido(usuarioModel.getPrimerApellido());
      usuario.setSegundoApellido(usuarioModel.getSegundoApellido());
      usuario.setCorreo(usuarioModel.getCorreo());
      usuario.setCodigo(usuarioModel.getCodigo());
      usuario.setTelefono(usuarioModel.getTelefono());
      usuario.setEstado(usuarioModel.getEstado());
      usuario.setCambioPassword(usuarioModel.isCambioPassw());
      usuario.setNroIdentificacion(usuarioModel.getNroIdentificacion());
      usuario.setPassword(
          usuarioModel.getNroIdentificacion()
              .toString());
      usuario.setRol(new Rol());
      usuario.getRol()
          .setIdRol(usuarioModel.getIdRol());
      usuario.setPrograma(new Programa());
      usuario.getPrograma()
          .setIdPrograma(usuarioModel.getIdPrograma());
    }

    return usuario;

  }

  public static CaracteristicaModel convertCaracteristicaToCaracteristicaModel(Caracteristica caracteristica) {
    CaracteristicaModel model = null;
    if (caracteristica != null) {
      model = new CaracteristicaModel(caracteristica.getIdCaracteristica(), caracteristica.getNombre(), caracteristica.getEstado());
    }
    return model;
  }

  public static Caracteristica convertCaracteriscitcaModelToCaracteristica(CaracteristicaModel caracteristicamodel) {
    Caracteristica caracteristica = null;
    if (caracteristicamodel != null) {
      caracteristica = new Caracteristica();
      caracteristica.setIdCaracteristica(caracteristicamodel.getIdcaracteristica());
      caracteristica.setNombre(caracteristicamodel.getNombre());
      caracteristica.setEstado(caracteristicamodel.isEstado());
    }
    return caracteristica;
  }
  
  public static AuditoriaModel convertAuditoriaToAuditoriaModel(Auditoria auditoria) {
	    AuditoriaModel model = null;
	    if (auditoria != null) {
	      model = new AuditoriaModel();
	      model.setAccion(auditoria.getAccion());
	      model.setAntiguoValor(auditoria.getAntiguoValor());
	      model.setFechaModificacion(auditoria.getFechaModificacion());	     
	      model.setNuevoValor(auditoria.getNuevoValor());
	      model.setTabla(auditoria.getTabla());
	    }
	    return model;
  }
  
  public static Auditoria convertAuditoriaModelToAuditoria(AuditoriaModel auditoriamodel) {
	    Auditoria auditoria = null;
	    if (auditoriamodel != null) {
	    	auditoria = new Auditoria();
	    	auditoria.setAccion(auditoriamodel.getAccion());
	        auditoria.setAntiguoValor(auditoria.getAntiguoValor());
	        auditoria.setFechaModificacion(auditoriamodel.getFechaModificacion());
	        auditoria.setNuevoValor(auditoria.getNuevoValor());
	        auditoria.setTabla(auditoria.getTabla());
	        auditoria.setUsuario(auditoria.getUsuario());
	    }
	    return auditoria;
	  }
  
}
