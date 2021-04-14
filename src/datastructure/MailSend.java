package datastructure;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

class MailSend {
    public static void send(String from, String password, String to, String sub, String msg) {
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "lloydsbanking.mail.protection.outlook.com");
        props.put("mail.smtp.port", "25");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.enable", "true");
        //get Session
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress("Arun.Varathapillai@lloydsbanking.com"));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        //from,password,to,subject,message
        MailSend.send("Arun.Varathapillai@lloydsbanking.com", "ARdec2020!", "Arun.Varathapillai@lloydsbanking.com", "hello arun", "");
        //change from, password and to
    }
}