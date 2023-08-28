package com.example.diansspring.web.controller;


import com.example.diansspring.model.Podatoci;
import com.example.diansspring.service.PodatociService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = {"/","/pocetna"})
public class HomeController {

    private final PodatociService podatociService;

    public HomeController(PodatociService podatociService) {
        this.podatociService = podatociService;
    }

    @GetMapping
    public String pocetnaPage() {
        return "pocetna";
    }

    @PostMapping
    public String getHomePage() {
        return "home";
    }

    @GetMapping("access_denied")
    public String getAccessDeniedPage() {
        return "access_denied";
    }


    /**
     * za vezhbanje za prikaz na slika e ova napraveno...
     */
//    @GetMapping("/show")
//    public String showPhoto(Model model) {
//        List<Podatoci> podatociList = this.podatociService.getAllInfo();
//        model.addAttribute("podatoci", podatociList);
//        return "example";
//    }
}
