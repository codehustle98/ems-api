package com.codehustle.ems;

import com.codehustle.ems.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Slf4j
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
        log.info("Email notification sent to : "+receipient);
    }

    public void sendEmailWithAttachment(String receipient,String subject,String body) throws MessagingException, IOException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(SENDER_ADDRESS);
        helper.setTo(receipient);
        helper.setSubject(subject);
        helper.setText(body);

        helper.addAttachment("img", FileUtils.getBirthdayImg());

        javaMailSender.send(message);

        log.info("Email notification sent to : "+receipient);
    }

}
