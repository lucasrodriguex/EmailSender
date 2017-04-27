package br.com.emailsender.service;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void send(String name, String guestEmail) {
		try{
			Email email = new SimpleEmail();
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("email", "password"));
			email.setSSLOnConnect(true);
			
			email.setFrom("email");
			email.setSubject("You just have been invited by VIPList!");
	        email.setMsg("Hello " + name + ". You just have been invited by VIPList!");
	        email.addTo(guestEmail);
	        email.send();
			
		} catch (EmailException e) {
			e.printStackTrace();
		}
		
		
	}
}
