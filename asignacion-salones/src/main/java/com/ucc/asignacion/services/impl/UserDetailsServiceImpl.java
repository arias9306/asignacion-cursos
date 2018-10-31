package com.ucc.asignacion.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ucc.asignacion.entities.Rol;
import com.ucc.asignacion.entities.Usuario;
import com.ucc.asignacion.repository.IRolRepository;
import com.ucc.asignacion.repository.IUsuarioRepository;

/**
 * @author andres.arias
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private IRolRepository rolRepository;
  private IUsuarioRepository usuarioRepository;

  /**
   * Constructor.
   *
   * @param rolRepository
   * @param usuarioRepository
   */
  @Autowired
  public UserDetailsServiceImpl(IRolRepository rolRepository, IUsuarioRepository usuarioRepository) {
    this.rolRepository = rolRepository;
    this.usuarioRepository = usuarioRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario user = usuarioRepository.findByCorreo(username);

    if (user == null) {
      System.out.println("User not found! " + username);
      throw new UsernameNotFoundException("User " + username + " was not found in the database");
    }

    System.out.println("Found User: " + user.getCorreo() + " / " + user.getPassword());

    // [USER, ADMIN,..]
    Optional<Rol> roleNames = rolRepository.findById(
        user.getRol()
            .getIdRol());

    List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
    if (roleNames.isPresent()) {
      String role = roleNames.get()
          .getNombre();
      // ROLE_USER, ROLE_ADMIN,..
      GrantedAuthority authority = new SimpleGrantedAuthority(role);
      grantList.add(authority);
    }

    UserDetails userDetails = new User(user.getCorreo(), //
        user.getPassword(), grantList);

    return userDetails;
  }

}
