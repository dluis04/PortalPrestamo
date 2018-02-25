package com.portalPrestamos.estandar.modelo.utilidades;

import java.util.ArrayList;

import java.util.List;
import java.util.Properties;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

public class EmailUtil {

	public static void enviarMailSimple(String[] destinatarios, String asunto,
			String texto) throws Exception {
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("avalweb.fenalcovalle@gmail.com", "fenalcovalle"));
		
		
//		setAuthenticator(new DefaultAuthenticator(
//				"avalweb.fenalcovalle@gmail.com", "fenalcovalle"));
		email.setSSLOnConnect(true);
		email.setFrom("avalweb.fenalcovalle@gmail.com");
		email.setSubject(asunto);
		email.setMsg(texto);
		for (String d : destinatarios) {
			email.addTo(d);
		}
		email.send();
	}

	public static void enviarMailAdjunto(String[] destinatarios, String asunto,
			String texto, String[] archivos) throws Exception {

		/*for(String ar:archivos){
			EmailAttachment attachment = new EmailAttachment();
			attachment.setPath(ar);
			attachment.setDisposition(EmailAttachment.ATTACHMENT);
			attachment.setDescription("Picture of John");
			attachment.setName("John");
		}

		// Create the email message
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("mail.myserver.com");
		email.addTo("jdoe@somewhere.org", "John Doe");
		email.setFrom("me@apache.org", "Me");
		email.setSubject("The picture");
		email.setMsg("Here is the picture you wanted");

		// add the attachment
		email.attach(attachment);

		// send the email
		email.send();*/
	}
	
	public static void enviarMailHTML(List<String> destinatarios, String asunto,
			String textoHTML) throws Exception {
		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthentication("avalweb.fenalcovalle@gmail.com", "fenalcovalle");
		email.setSSLOnConnect(true);
		email.getMailSession().getProperties().put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		email.setFrom("avalweb.fenalcovalle@gmail.com");
		email.setSubject(asunto);
		for (String d : destinatarios) {
			email.addTo(d);
		}
	  
	  // set the html message
	  email.setHtmlMsg(textoHTML);
	  email.setCharset("UTF-8");

	  // set the alternative message
	  email.setTextMsg("Su cliente de correo no soporta mensajes en formato HTML");

	  // send the email
	  email.send();
	}
	
	
	public static void main(String[] args)  throws Exception{
		List<String> rem=new ArrayList<String>();
		rem.add("jhonandrey@hotmail.com");
		enviarMailHTML(rem, "Pruebas", "<h3>Texto</h3>");
	}
}
