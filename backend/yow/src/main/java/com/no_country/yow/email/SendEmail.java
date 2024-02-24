package com.no_country.yow.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class SendEmail {
    private String myEmail = "proengra@gmail.com"; // Dirección de correo electrónico desde la cual se enviarán los correos
    private String passwordEmail = "kohubzgzldaymzyx"; // Contraseña de la cuenta de correo electrónico
    private String emailTo; // Dirección de correo electrónico del destinatario
    private String subject; // Asunto del correo electrónico
    private String content; // Contenido del correo electrónico

    private Properties properties; // Propiedades para la configuración del servidor SMTP
    private Session session; // Sesión para enviar el correo electrónico
    private MimeMessage email; // Objeto para representar el correo electrónico a enviar

    public SendEmail() {
        this.properties = new Properties(); // Inicialización de las propiedades
    }

    public void createEmail(String emailSend, String newPassword) {
        emailTo = emailSend; // Asignación del destinatario
        subject = "Restablecimiento de Contraseña"; // Asunto del correo
        content = "Su nueva contraseña es: " + newPassword; // Contenido del correo

        // Configuración de las propiedades del servidor SMTP de Gmail
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.user", myEmail);
        properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");
        properties.setProperty("mail.smtp.auth", "true");

        // Creación de la sesión para enviar el correo electrónico
        session = Session.getDefaultInstance(properties);
        email = new MimeMessage(session);
        try {
            email.setFrom(new InternetAddress(emailTo)); // Establecer la dirección del remitente
            email.setRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(emailTo))); // Establecer el destinatario
            email.setSubject(subject); // Establecer el asunto
            email.setText(content, "ISO-8859-1", "html"); // Establecer el contenido del correo nos permite diferenciar el codigo hmtl
        } catch (MessagingException e) {
            System.out.println("Error al crear el correo: " + e.getMessage()); // Manejo de excepciones
        }
    }

    public void sendEmail() {
        try {
            Transport transport = session.getTransport("smtp"); // Obtener el transporte SMTP
            transport.connect(myEmail, passwordEmail); // Conectar al servidor SMTP de Gmail
            transport.sendMessage(email, email.getRecipients(Message.RecipientType.TO)); // Enviar el correo electrónico
            transport.close(); // Cerrar la conexión
        } catch (NoSuchProviderException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage()); // Manejo de excepciones
        } catch (MessagingException e) {
            System.out.println("Error al conectar el servidor para enviar correo: " + e.getMessage()); // Manejo de excepciones
        }
    }
}
