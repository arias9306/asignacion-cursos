package com.ucc.asignacion.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ucc.asignacion.services.impl.UserDetailsServiceImpl;

/**
 * @author andres.arias
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Bean
  public BCryptPasswordEncoder passwordEncoder() {
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    return bCryptPasswordEncoder;
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService)
        .passwordEncoder(passwordEncoder());
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf()
        .disable();

    // Paginas que no requieren login
    http.authorizeRequests()
        .antMatchers("/", "/login", "/iniciarSesion", "/cambioPassw")
        .permitAll();

    // /Dasboard pagina publica que requiere login puede ser admin o usuario
    // si no esta logueado lo redirecciona al login..
    http.authorizeRequests()
        .antMatchers("/dashboard")
        .access("hasAnyRole('USER', 'ADMIN')");

    // solo administradores
    http.authorizeRequests()
        .antMatchers("/admin")
        .access("hasRole('ADMIN')");

    // When the user has logged in as XX.
    // But access a page that requires role YY,
    // AccessDeniedException will be thrown.
    http.authorizeRequests()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/errores/403");

    // Config for Login Form
    http.authorizeRequests()
        .and()
        .formLogin()//
        // Submit URL of login page.
        .loginProcessingUrl("/j_spring_security_check") // Submit URL
        .loginPage("/login")//
        .defaultSuccessUrl("/dashboard/")//
        .failureUrl("/login?error=true")//
        .usernameParameter("username")//
        .passwordParameter("password")
        // Config for Logout Page
        .and()
        .logout()
        .logoutUrl("/logout")
        .logoutSuccessUrl("/");

  }
}
