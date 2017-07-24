package com.webstore;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class SendAuthentication
{

    public static void Send()
    {

        String host ="webstore.mx";//Suponiendo que el servidor SMTPsea la propia máquina
        String from ="supportgemobile@webstore.mx";
        String to = "oscar.rg@outlook.com";


        System.out.println ("Prueba para enviar un mail..." + new java.util.Date());

        Properties prop = new Properties();

        prop.put("mail.smtp.host", host);
        /*Esta línea es la que indica al API que debe autenticarse*/
        prop.put("mail.smtp.auth", "true");

        /*Añadir esta linea si queremos ver una salida detallada del programa*/
        //prop.put("mail.debug", "true");

        try{

            SMTPAuthentication auth = new SMTPAuthentication();
            Session session = Session.getInstance(prop , auth );
            Message msg = getMessage(session, from, to);
            System.out.println ("Enviando ..." );

            Transport.send(msg);

            System.out.println ("Mensaje enviado!");

        }

        catch (Exception e)
        {

            ExceptionManager.ManageException(e);

        }

    }

    private static MimeMessage getMessage(Session session, String from, String to)
    {

        try{

            MimeMessage msg = new MimeMessage(session);
            msg.setText("El mail desde java. Este mensaje a utilizado autenticacion en el servidor.");
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            msg.setFrom(new InternetAddress(from,"JavaMail en accion"));
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

class SMTPAuthentication extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {

        String username = "supportgemobile@webstore.mx";

        String password = "@a1a2a3a4a5@";

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