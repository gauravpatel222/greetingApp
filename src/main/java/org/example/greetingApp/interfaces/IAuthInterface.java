package org.example.greetingApp.interfaces;

import org.example.greetingApp.dto.AuthUserDTO;
import org.example.greetingApp.dto.LoginDTO;
import org.example.greetingApp.dto.PassDTO;
import org.springframework.stereotype.Service;

@Service
public interface IAuthInterface {

    public String register(AuthUserDTO user);


    public String login(LoginDTO user);

    public AuthUserDTO forgotPassword(PassDTO pass, String email);

    public String resetPassword(String email, String currentPass, String newPass);
}
