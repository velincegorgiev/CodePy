package com.example.diansspring.web.controller;


import com.example.diansspring.model.User;
import com.example.diansspring.model.exceptions.InvalidUserCredentialsException;
import com.example.diansspring.service.AuthService;
import com.example.diansspring.service.Podatoci1Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model) {
        User user = null;
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            user = this.authService.login(username, password);

            request.getSession().setAttribute("user",user);
            return "redirect:/pocetna";
        } catch (InvalidUserCredentialsException e) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
}
