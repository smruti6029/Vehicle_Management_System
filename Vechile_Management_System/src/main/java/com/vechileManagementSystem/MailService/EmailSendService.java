package com.vechileManagementSystem.MailService;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.vechileManagementSystem.Entity.AssignVehicleForSubbranch;

@Service
public class EmailSendService {
    
    public void sendEmail(AssignVehicleForSubbranch customer) throws MessagingException {
        String toEmail = customer.getCustomer().getGmail();
        String subject = "Vehicle Assigned Successfully";
        
        String emailContent = "<html><body>" +
                "<h1>Hello " + customer.getCustomer().getName() + "</h1>" +
                "<p>Your vehicle has been assigned successfully. Here are the details:</p>" +
                "<ul>" +
                "<li>Customer Name: " + customer.getCustomer().getName() + "</li>" +
                "<li>Issue Date: " + customer.getCustomer().getIssue_date() + "</li>" +
                "<li>Address: " + customer.getCustomer().getAddress() + "</li>" +
                "<li>Vehicle Name: " + customer.getVechile_name() + "</li>" +
                "<li>Subbrand Name: " + customer.getBrandLocaton().getSubbrand_name() + "</li>" +
                "</ul>" +
                "</body></html>";
        
        JavaMailSender mailSender = new JavaMailSenderImpl();
        ((JavaMailSenderImpl) mailSender).setHost("smtp.gmail.com");
        ((JavaMailSenderImpl) mailSender).setPort(587);
        ((JavaMailSenderImpl) mailSender).setUsername("smrutiranjan.rapidsoft@gmail.com");
        ((JavaMailSenderImpl) mailSender).setPassword("euazxwycfrrdeggt");

        Properties properties = new Properties();
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        ((JavaMailSenderImpl) mailSender).setJavaMailProperties(properties);
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("smrutiranjan.rapidsoft@gmail.com", "euazxwycfrrdeggt");
            }
        });

        MimeMessage message = new MimeMessage(session);

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");

            messageHelper.setFrom("smrutiranjan.rapidsoft@gmail.com");
            messageHelper.setTo(toEmail);
            messageHelper.setSubject(subject);

            // Set the email content
            messageHelper.setText(emailContent, true);

            ((JavaMailSenderImpl) mailSender).send(message);

            System.out.println("Mail sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            System.out.println("Failed to send email: " + e.getMessage());
        }
    }

}


