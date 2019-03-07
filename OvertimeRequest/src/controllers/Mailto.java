/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;
//import model.Master.ModelEmail;

/**
 *
 * @author Lusiana
 */
public class Mailto {

    public String kirim(String judul, String username, String password, String email) {

        try {
            final String from = "tarilaalala@gmail.com"; //email pengirim
            String to = email; // email penerima
            String host = "127.0.0.1"; //alamat server SMTP
            String subject = judul; //subject
            final String pass = "tralalala2345"; //diisi password email
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.port", "465");//default port dari smptp

            Session session = Session.getDefaultInstance(properties,
                    new javax.mail.Authenticator() {

                protected PasswordAuthentication getPasswordAuthentication() {

                    return new PasswordAuthentication(
                            from, pass);

                }

            });
            try {
                MimeMessage message = new MimeMessage(session); // email message
                message.setFrom(new InternetAddress(from));   // setting header fields
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject(subject); // subject line
                // Create the message body part
                BodyPart messageBodyPart = new MimeBodyPart();

                // Fill the message
//                messageBodyPart.setText("" + sdf.format(tgl.getTime()));
                messageBodyPart.setText("username: " + username + "\n" + "Password: " + password );
//                messageBodyPart.setText("Haloo " + Judul);
                Multipart multipart = new MimeMultipart();
                multipart.addBodyPart(messageBodyPart);
//        messageBodyPart = new MimeBodyPart();
//         String filename = "D:/data/"+Judul+awal+"-"+Akhir+".pdf";
//         DataSource source = new FileDataSource(filename);
//         messageBodyPart.setDataHandler(new DataHandler(source));
//         messageBodyPart.setFileName(filename);
//         multipart.addBodyPart(messageBodyPart);
                // actual email body

                message.setContent(multipart);
                // Send message
                Transport.send(message);
                return "Email Terkirim!!";
            } catch (MessagingException me) {
                me.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Gagal";
    }
}
