package com.telus.testtelus.helper;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * By Github repo: https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java-networking-2/src/main/java/com/baeldung/mail/EmailService.java
 */

import java.util.Properties;



public class EmailService {
	
	

    public static void main(String[] args) {

        final String username = "alexandermejialopez@gmail.com";
        final String password = "password";
        
        final String recipient = "ties_dataintegration@telusinternational.com​";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        prop.setProperty("mail.mime.address.strict", "false");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
        	
        
            String msg = "Resume of committees statictics (10 AM CST)"+
            				"\n\n Dear Mail Crawler," + 
            				"\n\n Please do not spam my email!";

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject("Committiees Statistics - By Josué Mejía");
            message.setText(msg);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
	
	

}
