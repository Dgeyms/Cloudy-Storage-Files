package com.example.cloudystoragefiles.controller;

import com.example.cloudystoragefiles.model.User;
import com.example.cloudystoragefiles.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private UserServiceImpl userService;

    public AuthController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/registerUser")
    public String registerUser(User user){
        userService.saveUserInDatabase(user);
        return "ok";
    }


}
