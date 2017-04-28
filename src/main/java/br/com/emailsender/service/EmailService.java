package br.com.emailsender.service;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	public void send(String name, String guestEmail) {
		try{
			Email email = new SimpleEmail();
			email.setHostName("smtp-mail.outlook.com");
			email.setSmtpPort(587);
			email.setStartTLSEnabled(true);
			email.setAuthentication("email", "password");
			email.setFrom("email", "yourname");
			email.setSubject("You just have been invited by VIPList!");
	        email.setMsg("Hello " + name + ". You just have been invited by VIPList!");
	        email.addTo(guestEmail);
	        email.send();
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
}
