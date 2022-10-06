package com.codehustle.ems;

import com.codehustle.ems.utils.FileUtils;
import freemarker.template.Configuration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class EmailService {

    public static final String SENDER_ADDRESS = "noreply@emsadmin.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer configuration;

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

    public void sendBirthdayEmail(String receipient,String subject){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try{
            Map<String,Object> content = new HashMap<>();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            mimeMessageHelper.setFrom(SENDER_ADDRESS);
            mimeMessageHelper.setTo(receipient);
            mimeMessageHelper.setSubject(subject);

            String htmlBody = FreeMarkerTemplateUtils.processTemplateIntoString(configuration.getConfiguration().getTemplate("birthday-template.ftl"), content);

            mimeMessageHelper.setText(htmlBody,true);

            mimeMessageHelper.addInline("image",FileUtils.getBirthdayImg());

            javaMailSender.send(mimeMessageHelper.getMimeMessage());

            log.info("Email notification sent to : "+receipient);
        }catch (Exception e){
            log.error("Error sending email");
            e.printStackTrace();
        }

    }
}
