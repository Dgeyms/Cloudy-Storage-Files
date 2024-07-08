package com.example.cloudystoragefiles.controller;

import com.example.cloudystoragefiles.dto.UserDto;
import com.example.cloudystoragefiles.exception.UserAlradyExistException;
import com.example.cloudystoragefiles.model.User;
import com.example.cloudystoragefiles.service.IUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    private final IUserService IUserService;

    @Autowired
    public  AuthController(IUserService IUserService) {
        this.IUserService = IUserService;
    }

    /*
    Этот метод обрабатывает HTTP GET запросы на URL /login и подготавливает данные для отображения формы входа пользователя.
     */
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        UserDto userDto = new UserDto();

        // add new object in model
        model.addAttribute("user", userDto);
        return "login";
    }

    /*
    Он отвечает за обработку HTTP GET запроса на URL /user/register и подготавливает данные для отображения формы регистрации пользователя.
     */
    @GetMapping("/user/register")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDto userDto = new UserDto();

        // Добавление объекта пользователя в модель
        model.addAttribute("user", userDto);
        return "register";
    }

    /*
    Он отвечает за обработку HTTP POST запросов, которые отправляются при регистрации нового пользователя.
     */
    @PostMapping("/user/registration")
    public ModelAndView registerUserAccount(
            @ModelAttribute("user") @Valid UserDto userDto,
            HttpServletRequest request,
            Error error) {

        ModelAndView mav = new ModelAndView();
        try {
            // Trying to register a new user
            User registered = IUserService.registerNewUserAccount(userDto);

            // Установка имени представления для успешной регистрации
            mav.setViewName("successRegister");

            // Добавление объекта userDto в модель представления
            mav.addObject("user", userDto);

        } catch (UserAlradyExistException uaeEx) {
            // Обработка исключения при существующем пользователе
            mav.setViewName("errorPage");

            // Добавление сообщения об ошибке в модель представления
            mav.addObject("message", "An account for that username already exists.");
        }
        return mav;
    }
}
