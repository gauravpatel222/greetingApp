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
    public String register(@RequestBody AuthUserDTO user){
        return iAuthInterface.register(user);
    }


}
