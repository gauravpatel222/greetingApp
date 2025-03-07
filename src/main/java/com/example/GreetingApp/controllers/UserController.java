package com.example.GreetingApp.controllers;

import com.example.GreetingApp.dto.*;
import com.example.GreetingApp.interfaces.IAuthInterface;
//import com.example.SpringBoot3.services.iAuthInterface;
import com.example.GreetingApp.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    EmailService emailService;

    @Qualifier("IAuthInterface")
    @Autowired
    IAuthInterface iAuthInterface;

    //UC9 --> For Registration of a user
    @PostMapping(path = "/register")
    public String register(@RequestBody AuthUserDTO user) {
        return iAuthInterface.register(user);
    }

    //UC10 --> For User Login
    @PostMapping(path = "/login")
    public String login(@RequestBody LoginDTO user) {
        return iAuthInterface.login(user);
    }

    //UC11 --> For sending mail to another person
    @PostMapping(path = "/sendMail")
    public String sendMail(@RequestBody MailDTO message) {
        emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
        return "Mail sent";


    }
    //UC12 --> Added Swagger Config to use Swagger at url(/swagger)

}
