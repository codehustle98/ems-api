package com.codehustle.ems;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public static final String SENDER_ADDRESS = "noreply@emsadmin.com";

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String receipient,String subject,String body){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(SENDER_ADDRESS);
        simpleMailMessage.setTo(receipient);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(body);
        javaMailSender.send(simpleMailMessage);
    }

}
