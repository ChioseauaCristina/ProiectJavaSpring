package com.Chioseaua.springbootsecondapp;
/*
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class Mail {

    //SETUP MAIL SERVER PROPERTIES;
    //DRAFT AN EMAIL
    //SEND AN EMAIL

    Session newSession = null;
    MimeMessage mimeMessage = null;

    public static void main(String[] args) throws MessagingException {
        Mail mail = new Mail();
        mail.setupServerProperties();
        mail.draftEmail();
        mail.sendEmail();
    }

    private void sendEmail() throws MessagingException {
        String fromUser = "chioseauachioseaua15@gmail.com";
        String fromUserPassword = "Chiti Steluat15";
        String emailHost = "smtp.gmail.com";
        Transport transport = newSession.getTransport("smtp");
        transport.connect(emailHost, fromUser, fromUserPassword);
        transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
        transport.close();
        System.out.println("Email successfully sent");
    }

    private MimeMessage draftEmail() throws MessagingException {
        String[] emailRecipients = {"chioseauachioseaua15@gmail.com"};
        String emailSubject = "Test Mail";
        String emailBody = "Test Body";
        mimeMessage = new MimeMessage(newSession);

        for(int i = 0; i<emailRecipients.length; i++) {
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailRecipients[i]));
        }
        mimeMessage.setSubject(emailSubject);

        MimeBodyPart bodyPart = new MimeBodyPart();
        bodyPart.setContent(emailBody, "html/text");
        MimeMultipart multiPart = new MimeMultipart();
        multiPart.addBodyPart(bodyPart);
        mimeMessage.setContent(multiPart);
        return mimeMessage;

        //CREATE MIMEMESSAGE;
        //CREATE MESSAGE BODY PARTS
        //CREATE MESSAGE MULTIPART
        //ADD MESSAGE BODY PARTS -> MULTIPART
        //FINALLY ADD MULTIPART TO MESSAGE CONTENT
    }

    private void setupServerProperties() {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        newSession = Session.getDefaultInstance(properties, null);
    }
}
*/