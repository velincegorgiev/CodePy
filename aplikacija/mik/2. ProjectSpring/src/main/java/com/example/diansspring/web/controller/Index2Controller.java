package com.example.diansspring.web.controller;

import com.example.diansspring.service.Podatoci1Service;
import com.example.diansspring.service.Podatoci2Service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

import java.io.File;

@Controller
@RequestMapping("/index2")
public class Index2Controller {

    private final Podatoci2Service podatoci2Service;

    public Index2Controller(Podatoci2Service podatoci2Service) {
        this.podatoci2Service = podatoci2Service;
    }


    @GetMapping
    public String getIndex2() {
        return "smart_project/index2";
    }

    @GetMapping("/ciklusi")
    public String getView_Ciklusi() {
        return "smart_project/ciklusi";
    }

    @GetMapping("/funkcii")
    public String getView_Funkcii() {
        return "smart_project/funkcii";
    }

    @GetMapping("/klasi")
    public String getView_Klasi() {
        return "smart_project/klasi";
    }

    @GetMapping("/moduli")
    public String getView_Moduli() {
        return "smart_project/moduli";
    }

    @GetMapping("/vlez-izlez")
    public String getView_VlezIzlez() {
        return "smart_project/vlez-izlez";
    }

    @GetMapping("/smart_plant")
    public String getView_more_page() {
        return "smart_project/smart_plant";
    }


    @GetMapping("/okolina")
    public String getView_okolina() {
        return "smart_project/okolina";
    }

    @GetMapping("/voved")
    public String getView_voved() {
        return "smart_project/voved";
    }

    @GetMapping("/promenlivi")
    public String getView_promenlivi() {
        return "smart_project/promenlivi";
    }

    @GetMapping("/strings")
    public String getView_Strings() {
        return "smart_project/strings";
    }

    @GetMapping("/podatocna")
    public String getView_Podatocna() {
        return "smart_project/podatocna";
    }

    @GetMapping("/izrazi")
    public String getView_Izrazi() {
        return "smart_project/izrazi";
    }


    @GetMapping("/view_moree")
    public String getView_moree_page() {
        return "smart_project/pronajdok";
    }

    @GetMapping("/smart_plant/buy")
    public String getPaymentPage() {
        return "payments/pay1";
    }

    @PostMapping("/idea-for-project")
    public String ideaForProject(

            @RequestParam("contact_name") String name,
            @RequestParam("contact_email") String email,
            @RequestParam("contact_number") String number,
            @RequestParam("contact_message") String description
    ) {

        this.podatoci2Service.ideaForProject(name, email, number, description);

        return "redirect:/index2";

    }
}
