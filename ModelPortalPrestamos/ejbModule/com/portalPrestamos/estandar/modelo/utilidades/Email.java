package com.portalPrestamos.estandar.modelo.utilidades;

import java.util.List;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

import javax.mail.BodyPart;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	private Session sessionSmtp;
	private Session sessionImap;
	private Session sessionPop3;
	private String server;
	private String paswd;
	private String host;
	private String port;
	private Store store;
	private Folder folder;

	public Email() throws Exception {

		this.server = "portalprestamo@gmail.com";
		this.paswd = "Portal1354";
		this.host = "smtp.gmail.com";
		this.port = "587";
	}

	// public static void main(String[] args) throws Exception {
	// List<String> rem = new ArrayList<String>();
	// rem.add("diegoluis1993@gmail.com");
	//
	// Email x=new Email();
	//
	// x.init();
	// x.sendMailSimple("diegoluis1993@gmail.com", "Pruebas", "Texto");
	//
	// System.out.println("termino proceso");
	// }

	public Email(String server, String paswd) {
		this.server = server;
		this.paswd = paswd;
	}

	public void init() {
		Session session;
		Properties props;

		if (host.indexOf("smtp") != -1) {
			props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.socketFactory.port", port);
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.port", port);

			session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(server, paswd);
				}
			});

			setSessionSmtp(session);
		} else if (host.indexOf("pop3") != -1) {

			props = new Properties();

			props.put("mail.pop3.host", host);
			props.setProperty("mail.pop3.port", "995");
			props.setProperty("mail.pop3.socketFactory.port", "995");
			props.setProperty("mail.pop3.starttls.enable", "false");
			props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.setProperty("mail.pop3.socketFactory.fallback", "false");

			session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(server, paswd);
				}
			});

			setSessionPop3(session);
		} else if (host.indexOf("imap") != -1) {
			props = new Properties();
			props.put("mail.imap.host", host);
			props.put("mail.imap.socketFactory.port", port);
			props.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.imap.auth", "true");
			props.put("mail.imap.port", port);

			session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(server, paswd);
				}
			});

			setSessionImap(session);

		}
	}

	public int sendMailSimple(List<String> destinatarios, String suject, String text) {
		Message message;
		int valor = 0;
		try {
			init();
			message = new MimeMessage(sessionSmtp);
			message.setFrom(new InternetAddress(server));
			for (String d : destinatarios) {
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(d));
			}
			message.setSubject(suject);
			message.setText(text.toString());

			Transport.send(message);
			valor = 1;
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return valor;
	}

	public void sendMailFile(String to, String suject, String text, List files) {
		Message message;
		String filename;

		try {
			init();

			message = new MimeMessage(sessionSmtp);
			message.setFrom(new InternetAddress(server));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(suject);

			// message.setText(text.toString());
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setText(text.toString());

			// Se crea el objeto Multipart y se le a�ade el contenido
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			// Se adjunta el archivo
			messageBodyPart = new MimeBodyPart();

			for (int i = 0; i < files.size(); i++) {
				DataSource source = null;
				source = new FileDataSource(files.get(i).toString());
				messageBodyPart.setDataHandler(new DataHandler(source));
				messageBodyPart.setFileName(files.get(i).toString());
				multipart.addBodyPart(messageBodyPart);
			}

			// Se incluye en el objeto Multipart y se env�a
			message.setContent(multipart);
			Transport.send(message);

			System.out.println("Done");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public Message[] getMessages(String protocol, String box) {

		Message[] mensajes = null;

		try {
			store = sessionImap.getStore(protocol);

			if (protocol.equals("imap"))
				store.connect(sessionImap.getProperty(sessionImap.getProperty("mail.imap.host")), server, paswd);
			else
				store.connect(sessionImap.getProperty(sessionImap.getProperty("mail.pop3.host")), server, paswd);

			folder = store.getFolder(box);
			folder.open(Folder.READ_ONLY);
			mensajes = folder.getMessages();

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return mensajes;

	}

	public void setSessionSmtp(Session sessionSmtp) {
		this.sessionSmtp = sessionSmtp;
	}

	public Session getSessionSmtp() {
		return sessionSmtp;
	}

	public void setSessionImap(Session sessionImap) {
		this.sessionImap = sessionImap;
	}

	public Session getSessionImap() {
		return sessionImap;
	}

	public void setSessionPop3(Session sessionPop3) {
		this.sessionPop3 = sessionPop3;
	}

	public Session getSessionPop3() {
		return sessionPop3;
	}

	public void closeFolder() {
		try {
			folder.close(false);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public void closeStore() {
		try {
			store.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
