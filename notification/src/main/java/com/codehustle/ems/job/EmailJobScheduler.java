package com.codehustle.ems.job;

import com.codehustle.ems.EmailService;
import com.codehustle.ems.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Configuration
@EnableScheduling
public class EmailJobScheduler {

    private static final String BIRTHDAY_SUBJECT = "Happy Birthday to you !!";

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "${ems.cron.email-scheduler}")
    public void sendBirthdayEmail(){
        List<String> emailIds = employeeRepository.getEmployeeEmailIdsByBirthDate(LocalDate.now());
        if(!CollectionUtils.isEmpty(emailIds)){
            emailIds.forEach(id-> {
                log.info("Sending email to : "+id);
                emailService.sendBirthdayEmail(id,BIRTHDAY_SUBJECT);
            });
        }else{
            log.info("No emails found to send email");
        }
    }

}
