package com.wissen.controller;

import com.wissen.model.Email;
import com.wissen.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping
    public void sendEmail(@RequestParam("name") final String name) throws MessagingException {
        Email email = new Email();

        /* When we will add scheduler will remove all this and add details through properties file and
        database.
         */
        email.setTo("vishaltomar228@gmail.com");
        email.setFrom("vishal.tomar@wissen.com");
        email.setCc("vishal.tomar@wissen.com");
        email.setSubject("Welcome Email");
        email.setTemplate("EMAIL_TEMPLATE.html");
        email.getProperties().put("name", name);

        email.setProperties(email.getProperties());
        emailService.sendHtmlMessage(email);
    }
}
