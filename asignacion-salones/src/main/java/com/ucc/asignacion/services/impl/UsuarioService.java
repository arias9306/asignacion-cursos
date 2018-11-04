package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Programa;
import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.models.UsuarioModel;
import com.ucc.asignacion.repository.IUsuarioRepository;
import com.ucc.asignacion.services.IUsuarioService;
import com.ucc.asignacion.util.Converts;

@Service
public class UsuarioService implements IUsuarioService {

  private final IUsuarioRepository usuarioRepository;
  private final BCryptPasswordEncoder passwordEncoder;

  @Autowired
  public UsuarioService(IUsuarioRepository usuarioRepository, BCryptPasswordEncoder passwordEncoder) {
    this.usuarioRepository = usuarioRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public Usuario buscarUsuarioLogin(String correo, String pass) {
    return usuarioRepository.findByCorreoAndPassword(correo, pass);
  }

  @Override
  public Usuario recuperarPassword(String correo) {
    return usuarioRepository.findByCorreo(correo);
  }

  @Override
  public Usuario buscarUsuarioPrimerApellido(String primerApellido) {

    return usuarioRepository.findByPrimerApellido(primerApellido);
  }

  @Override
  public List<UsuarioModel> usuarios() {
    List<UsuarioModel> usuariosModel = new ArrayList<UsuarioModel>();
    Iterable<Usuario> usuarios = usuarioRepository.findAll();
    if (usuarios != null) {
      usuarios.forEach(usuario -> usuariosModel.add(Converts.convertUsuarioToUsuarioModel(usuario)));
    }
    return usuariosModel;
  }

  @Override
  public UsuarioModel buscarUsuarioById(String id) {
    Optional<Usuario> usuario = usuarioRepository.findById(Integer.parseInt(id));
    if (usuario.isPresent()) {
      return Converts.convertUsuarioToUsuarioModel(usuario.get());
    }
    return new UsuarioModel();

  }

  @Override
  public void guardarUsuario(UsuarioModel usuario) {
    if (usuario.getIdUser() != 0) {
      Optional<Usuario> usuarioEntity = usuarioRepository.findById(usuario.getIdUser());
      if (usuarioEntity.isPresent()) {
        Usuario updateUsuario = usuarioEntity.get();
        updateUsuario.setPrimerNombre(usuario.getPrimerNombre());
        updateUsuario.setSegundoNombre(usuario.getSegundoNombre());
        updateUsuario.setPrimerApellido(usuario.getPrimerApellido());
        updateUsuario.setSegundoApellido(usuario.getSegundoApellido());
        updateUsuario.setCorreo(usuario.getCorreo());
        updateUsuario.setCodigo(usuario.getCodigo());
        updateUsuario.setNroIdentificacion(usuario.getNroIdentificacion());
        updateUsuario.setTelefono(usuario.getTelefono());
        updateUsuario.setCambioPassword(usuario.isCambioPassw());
        updateUsuario.setEstado(usuario.getEstado());
        updateUsuario.setRol(new Rol());
        updateUsuario.getRol()
            .setIdRol(usuario.getIdRol());
        updateUsuario.setPrograma(new Programa());
        updateUsuario.getPrograma()
            .setIdPrograma(usuario.getIdPrograma());
        usuarioRepository.save(updateUsuario);
      }
    }
    else {
      Usuario newUsuario = Converts.convertUsuarioModelToUsuario(usuario);
      newUsuario.setPassword(passwordEncoder.encode(String.valueOf(newUsuario.getNroIdentificacion())));
      usuarioRepository.save(newUsuario);
    }

  }

  @Override
  public void eliminarUsuarioById(String id) {
    usuarioRepository.deleteById(Integer.parseInt(id));
  }

  @Override
  public UsuarioModel buscarUsuarioByCorreo(String correo) {
    return Converts.convertUsuarioToUsuarioModel(usuarioRepository.findByCorreo(correo));
  }

  @Override
  public int numeroUsuarios() {
    return 0;
  }

}
