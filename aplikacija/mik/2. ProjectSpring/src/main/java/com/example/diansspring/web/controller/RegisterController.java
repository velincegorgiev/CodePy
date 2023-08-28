package com.example.diansspring.web.controller;


import com.example.diansspring.model.enums.Role;
import com.example.diansspring.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping
    public String register(HttpServletRequest request, Model model) {
        // preku request param
        try {
            String name  = request.getParameter("name");
            String surname  = request.getParameter("surname");
            String username = request.getParameter("username");
            String password  = request.getParameter("password");
            String repeatPassword  = request.getParameter("password-repeat");


            this.userService.register(name,
                    surname,
                    username,
                    password,
                    repeatPassword,
                    Role.ROLE_USER);

            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("hasRegisterError", true);
            model.addAttribute("registerMessageError", e.getMessage());
            return "register";
        }
    }
}
