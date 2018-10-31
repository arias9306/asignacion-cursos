package com.ucc.asignacion;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ucc.asignacion.models.ProgramaModel;
import com.ucc.asignacion.models.RolModel;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.services.IProgramaService;
import com.ucc.asignacion.services.IRolService;
import com.ucc.asignacion.services.IUsuarioService;

/**
 * @author andres.arias
 */
@Component
@Order(Integer.MIN_VALUE)
public class DeveloperSettings implements CommandLineRunner {

  private final IUsuarioService usuarioService;
  private final IRolService rolService;
  private final IProgramaService programaService;
  private int codigo;

  /**
   * Constructor.
   *
   * @param usuarioService
   * @param rolService
   * @param programaService
   */
  public DeveloperSettings(IUsuarioService usuarioService, IRolService rolService, IProgramaService programaService) {
    this.usuarioService = usuarioService;
    this.rolService = rolService;
    this.programaService = programaService;
    codigo++;
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println(args.length);
    System.err.println("INICIAR CONFIGURACION PRINCIPAL");
    crearRolesPrincipales();
    crearProgramaIng();
    crearUsuario("admin@correo.co", "admin", "ADMIN");
    crearUsuario("user@correo.co", "user", "USER");

  }

  /**
   * @author: Andrés Arias
   * @since: 31/10/2018 9:09:39 a. m.
   */
  private void crearProgramaIng() {
    if (programaService.buscarByNombre("Ing. Sistemas") == null) {
      ProgramaModel programa = new ProgramaModel();
      programa.setCodigo("ING");
      programa.setFacultad("Ingenieria");
      programa.setNombre("Ing. Sistemas");
      programaService.guardarPrograma(programa);
    }

  }

  /**
   * @author: Andrés Arias
   * @since: 31/10/2018 8:53:53 a. m.
   */
  private void crearUsuario(String correo, String nombre, String rol) {
    if (!verificarSiExisteUsuario(correo)) {
      guardarUsuario(correo, nombre, rol);
    }

  }

  private void guardarUsuario(String correo, String nombre, String rol) {
    UsuarioModel usuario = new UsuarioModel();
    usuario.setIdUser(0);
    usuario.setPrimerNombre(nombre);
    usuario.setPrimerApellido(nombre);
    usuario.setCorreo(correo);
    usuario.setCodigo(codigo++);
    usuario.setNroIdentificacion(123456);
    usuario.setTelefono("6543211");
    usuario.setCambioPassw(true);
    usuario.setEstado("Activo");
    usuario.setIdPrograma(
        programaService.buscarByNombre("Ing. Sistemas")
            .getIdPrograma());
    usuario.setIdRol(
        rolService.buscarByNombre(rol)
            .getIdRol());
    usuarioService.guardarUsuario(usuario);
  }

  /**
   * si es diferente de null existe (true), si es null no existe (false).
   *
   * @author: Andrés Arias
   * @since: 31/10/2018 9:03:44 a. m.
   *
   * @param correo
   * @return
   */
  private boolean verificarSiExisteUsuario(String correo) {
    UsuarioModel usuario = usuarioService.buscarUsuarioByCorreo(correo);
    return usuario != null;
  }

  /**
   * @author: Andrés Arias
   * @since: 31/10/2018 8:53:24 a. m.
   */
  private void crearRolesPrincipales() {
    List<String> roles = Arrays.asList("ADMIN", "USER");
    for (String rol : roles) {
      if (rolService.buscarByNombre(rol) == null)
        rolService.guardarRol(new RolModel(0, rol));
    }
  }
}
