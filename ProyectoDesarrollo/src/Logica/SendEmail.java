package Logica;

import java.util.Properties;
import java.util.Scanner;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
 
public class SendEmail
{
    public void start(String correoLT, String nombre, String cedula)
    {
        Properties props = new Properties();
        
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Scanner scanner = new Scanner(System.in);

//        System.out.println("Please provide your Username for Authentication ...");
        final String Username = "coordinadorabccier@gmail.com";

//        System.out.println("Please provide your Password for Authentication ...");
        final String Password = "UNIVALLE";

//        System.out.println("Please provide Email Address from which you want to send Email ...");
        final String fromEmailAddress = "coordinadorabccier@gmail.com";

//        System.out.println("Please provide Email Address to which you want to send Email ...");
        final String toEmailAddress = correoLT;
 
//        System.out.println("Please provide Subject for your Email ... ");
        final String subject = "Confirmación de participación a los cursos del CIER-SUR";

//        System.out.println("Please provide Text Message for your Email ... ");
        final String textMessage = "Cordial saludo:\n" +
"Nos permitimos informarle a " + nombre + " identificado con la cedula " + cedula +  ", que ha sido elegido para formar parte de los cursos del CIER-SUR; donde una de sus faces es ofrecida en la Universidad del Valle de forma presencial y el resto de fases son dictadas de forma virtual.\n" +
"Muchas gracias por su atención... ";

        // Create a Session object based on the properties and
        // Authenticator object
        Session session = Session.getDefaultInstance(props,
        new LoginAuthenticator(Username,Password));

        try {
            // Create a Message object using the session created above
            Message message = new MimeMessage(session);

            // setting email address to Message from where message is being sent
            message.setFrom(new InternetAddress(fromEmailAddress));

            // setting the email address to which user wants to send message
            message.setRecipients(Message.RecipientType.TO,
             InternetAddress.parse(toEmailAddress));

            // setting the subject for the email
            message.setSubject(subject);

            // setting the text message which user wants to send to recipients
            message.setText(textMessage);

            // Using the Transport class send() method to send message
            Transport.send(message);

            System.out.println("\nYour Message delivered successfully ....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Creating a class for Username and Password authentication
    // provided by the user.
    class LoginAuthenticator extends Authenticator
    {
        PasswordAuthentication authentication = null;
 
        public LoginAuthenticator(String username, String password)
        {
            authentication = new PasswordAuthentication(username,password);
        }

        @Override
        protected PasswordAuthentication getPasswordAuthentication()
        {
        return authentication;
        }
    }
}
