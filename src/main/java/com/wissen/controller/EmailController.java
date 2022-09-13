package com.wissen.controller;

import com.wissen.model.Email;
import com.wissen.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Arrays;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public void sendEmail() throws MessagingException {
        Email email = new Email();
        email.setTo("vishaltomar228@gmail.com");
        email.setFrom("employeemanagement321@gmail.com");
        email.setSubject("Welcome Email");
        email.setTemplate("EMAIL_TEMPLATE.html");
        email.getProperties().put("name", "vishal");
        email.getProperties().put("subscriptionDate", LocalDate.now().toString());
        email.getProperties().put("technologies", Arrays.asList("Python", "Go", "C#"));
        email.setProperties(email.getProperties());
        emailService.sendHtmlMessage(email);
    }
}
