package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class FeedbackMailSender {
    @Autowired
    private JavaMailSender javaMailSender;
 /*   private JavaMailSenderImpl mailSender;
    public FeedbackMailSender(Environment environment){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("mounirrouissi2@gmail.com");
        mailSender.setPassword("password");
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
    }*/

    public void sendFeedback(String from, String name, String feedbackbody){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("mounirrouissi2@gmail.com");
        message.setSubject("New feedback from " + name);
        message.setSubject( feedbackbody);
        message.setFrom(from);

        this.javaMailSender.send(message);
    }
}
