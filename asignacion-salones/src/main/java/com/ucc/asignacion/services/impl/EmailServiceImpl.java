package com.ucc.asignacion.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {

	private final JavaMailSender emailSender;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender emailSende) {
		this.emailSender = emailSende;
	}
	
	public void enviarCorreo(String to) {
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setTo(to); 
        message.setSubject("Recuperacion Password"); 
        message.setText("Mk le envie un correo");
        emailSender.send(message);
	}

}
