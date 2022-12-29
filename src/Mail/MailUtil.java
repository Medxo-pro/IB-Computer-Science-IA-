/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mail;

import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Atmani
 */


public class MailUtil {
    
    public static void sendMail(String recepient, String mensaje, String Type) throws Exception {
        
        Properties properties = new Properties();
        //https://www.youtube.com/watch?v=L_QCGUkVmUg
        //https://www.youtube.com/watch?v=A7HAB5whD6I
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");
        
        //String myAccountEmail = "computer.science.ia@hotmail.com"; //Email
        //String password = "MehdiEMISIA"; //Password
        //String myAccountEmail = "mehdi.a@em-is.org"; //Email
        //String password = "Space-x2004"; //Password
        String myAccountEmail = "cs.ia.emaling@outlook.com";
        String password = "Mehdi12122004";

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }            
        });
        
        if (Type.equals("Password")){
           Message message = prepareMessage(session, myAccountEmail, recepient, mensaje); 
           Transport.send(message);
           System.out.println("Email sent");
        }
        
        if (Type.equals("ChangePassword")){
           Message message = prepareMessage2(session, myAccountEmail, recepient, mensaje); 
           Transport.send(message);
           System.out.println("Email sent");    
        }
         
        if (Type.equals("ChangeUserName")){
           Message message = prepareMessage3(session, myAccountEmail, recepient, mensaje); 
           Transport.send(message);
           System.out.println("Email sent");    
        }
        
        if (Type.equals("ChangeEmail")){
           Message message = prepareMessage4(session, myAccountEmail, recepient, mensaje); 
           Transport.send(message);
           System.out.println("Email sent");    
        }
    }
    
  
     public static void sendMailListPeople(ArrayList<String> recepients, String mensaje, String Type) throws Exception {
        //Set up the protocols/settings of the SMTP server using JavaMail API and (javax.mail) JAR 
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");//It is given by the Outlook setting system.
        properties.put("mail.smtp.port", "587"); //Outlook access port
        String myAccountEmail = "cs.ia.emaling@outlook.com"; // Email address used to email users.
        String password = "Mehdi12122004"; // Password to access the email address account through Outlook.
        //create the "Session" object
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }            
        });
        //Those control flow statements allow having one "Send email function" for several types of emails -> 
        //In this case, there can be two types: "Groups" & "Tutoring" ->
        //Each type will lead to a different "Prepare Message" including a unique "Subject" and "Message" per email.
        if (Type.equals("Groups")){
           Message message = prepareMessageGroups(session, myAccountEmail, recepients, mensaje); 
           Transport.send(message);
           System.out.println("Email sent");//Allows to confirm the sending of an email. 
        }
        if (Type.equals("Tutoring")){
           Message message = prepareMessageTutoring1(session, myAccountEmail, recepients, mensaje); 
           Transport.send(message);
           System.out.println("Email sent");//Allows to confirm the sending of an email. 
        }
     }
     
      public static void sendMailListPeople1(ArrayList<String> recepients, String mensaje, String Type, String emitentUserName, String recipientUserName ) throws Exception {
        
        Properties properties = new Properties();
        //https://www.youtube.com/watch?v=L_QCGUkVmUg
        //https://www.youtube.com/watch?v=A7HAB5whD6I
        //https://stackoverflow.com/questions/59675176/exception-java-lang-classnotfoundexception-javax-activation-datahandler-even-t
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.office365.com");
        properties.put("mail.smtp.port", "587");
        
       //String myAccountEmail = "cs.ia.emis@hotmail.com"; //Email
       //String password = "MehdiEMISIA"; //Password
       //String myAccountEmail = "computer.science.ia@hotmail.com"; //Email
       //String password = "MehdiEMISIA"; //Password
       //String myAccountEmail = "mehdi.a@em-is.org"; //Email
       //String password = "Space-x2004"; //Password
       String myAccountEmail = "cs.ia.emaling@outlook.com";
       String password = "Mehdi12122004";
 
         
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, password);
            }            
        });
        
      
         if (Type.equals("Tutoring")){
           Message message = prepareMessageTutoring2(session, myAccountEmail, recepients, mensaje,  emitentUserName, recipientUserName); 
           Transport.send(message);
           System.out.println("Email sent"); 
            
        }
        
    }
     
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String mensaje) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Retrive Password");
            message.setText("Your password is ["+ mensaje + "]");
            return message;
        } catch (Exception e) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    private static Message prepareMessageGroups(Session session, String myAccountEmail, ArrayList<String> recepients, String mensaje) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            //This loop allows sending emails to a group of users, by iterating through the Array List of recipients:
           for(int i = 0; i < recepients.size(); i ++){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepients.get(i)));         
           }
            message.setSubject("New group"); //Sets the "Subject" of the email.
            //Sets the message of the email:
            message.setText("A new group has been created including at least one of your subjects: ["+ mensaje + "]");  
            return message;
         //If for any reason the previous steps end up not working, the error handling catch method is activated:
        } catch (Exception e) { 
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
      
    private static Message prepareMessageTutoring1(Session session, String myAccountEmail, ArrayList<String> recepients, String mensaje) {
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            
           for(int i = 0; i < recepients.size(); i ++){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepients.get(i)));         
           }
           
            message.setSubject("New Tutoring Demand");
            message.setText("A new demand for help has been created including at least one of your subjects. Message from user: ["+ mensaje + "]");
            return message;
        } catch (Exception e) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     
    private static Message prepareMessageTutoring2(Session session, String myAccountEmail, ArrayList<String> recepients, String mensaje, String emitentUserName, String recipientUserName) {
        try {
            
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            
           for(int i = 0; i < recepients.size(); i ++){
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepients.get(i)));         
           }
           
            message.setSubject("Help Recieved!");
            message.setText(""+ emitentUserName + " has offered his help! this is a message from the emitent: ["+ mensaje + "]");
            return message;
        } catch (Exception e) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
     private static Message prepareMessage2(Session session, String myAccountEmail, String recepient, String mensaje) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("New Password");
            message.setText("Your new password is ["+ mensaje + "]");
            return message;
        } catch (Exception e) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
     
    private static Message prepareMessage3(Session session, String myAccountEmail, String recepient, String mensaje) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("New UserName");
            message.setText("Your new UserName is ["+ mensaje + "]");
            return message;
        } catch (Exception e) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    private static Message prepareMessage4(Session session, String myAccountEmail, String recepient, String mensaje) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("New Email");
            message.setText("Your new  registered Email is ["+ mensaje + "]");
            return message;
        } catch (Exception e) {
            Logger.getLogger(MailUtil.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
}
