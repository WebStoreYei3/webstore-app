package com.webstore.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by oscar on 22/12/2016.
 */

public class MotorMail
{

    public static void sendMail(String to,String message,String subject)
    {

        String host ="outlook.office365.com";//Suponiendo que el servidor SMTPsea la propia máquina
        String from ="webstorerepository@outlook.com";
        String port ="587";


        System.out.println ("Enviando mail a cliente...." + new java.util.Date());

        Properties prop = new Properties();

        prop.put("mail.smtp.host", host);
        prop.put("mail.smtp.port", port);
        /*Esta línea es la que indica al API que debe autenticarse*/
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.ssl.trust", "*");
        prop.put("mail.smtp.starttls.enable", "true");

        prop.put("mail.debug", "true");

        try{

            SMTPAuthentication auth = new SMTPAuthentication();
            Session session = Session.getInstance(prop , auth );
            Message msg = getMessage(session, from, to, message,subject);
            System.out.println ("Enviando ..." );

            Transport.send(msg);

            System.out.println ("Mensaje enviado!");

        }

        catch (Exception e)
        {

            ExceptionManager.ManageException(e);

        }

    }

    private static MimeMessage getMessage(Session session, String from, String to,String message, String subject)
    {

        try{

            MimeMessage msg = new MimeMessage(session);
            msg.setContent(message, "text/html");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from,"Equipo de WebStore"));
            msg.setSubject(subject);
            return msg;

        }

        catch (java.io.UnsupportedEncodingException ex)
        {

            ExceptionManager.ManageException(ex);
            return null;

        }

        catch (MessagingException ex)
        {

            ExceptionManager.ManageException(ex);
            return null;

        }

    }

}

class SMTPAuthentication extends Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {

        String username = "webstorerepository@outlook.com";

        String password = "a1a2a3a4a5";

        return new PasswordAuthentication(username, password);

    }

}

class ExceptionManager
{

    public static void ManageException (Exception e)
    {

        System.out.println ("Se ha producido una exception");

        System.out.println (e.getMessage());

        e.printStackTrace(System.out);

    }

}