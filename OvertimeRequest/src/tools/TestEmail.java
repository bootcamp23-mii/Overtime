/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author milhamafemi
 */
public class TestEmail {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getDefaultInstance(props);
        System.out.println("test");
        try {
            //ganti Email Sendiri buat test
            InternetAddress fromAddress = new InternetAddress("ilhamafemi@gmail.com");
            InternetAddress toAddress = new InternetAddress("ilhamafemi@gmail.com");

            System.out.println("test2");
            Message message = new MimeMessage(session);
            message.setFrom(fromAddress);
            message.setRecipient(Message.RecipientType.TO, toAddress);
            message.setSubject("asdsad");
            message.setText("asdsadadjhasd");
            System.out.println("tes");
            Transport.send(message, "Email Sendiri","Password");
            System.out.println("test3");
        } catch (MessagingException ex) {
            System.out.println("ex");
            ex.printStackTrace();
        }
    }
}
