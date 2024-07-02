package com.example.cloudystoragefiles.controller;

import com.example.cloudystoragefiles.model.UserDTO;
import com.example.cloudystoragefiles.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDTO userDTO,
            HttpServletRequest request,
            Error error) {

        try {
            User registered = userService.registerNewUserAccount(userDTO);
        } catch (UserAlreadyExistException uaeEx) {
            mav.addObject("message", "An account for that username already exists.");
            return mav;
        }
        return new ModelAndView("successRegister", "user", userDTO);
    }


}
