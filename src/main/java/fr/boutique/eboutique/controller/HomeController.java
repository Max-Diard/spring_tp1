package fr.boutique.eboutique.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        System.out.println("/ : Home page");
        return "home";
    }

    @GetMapping("/bonjour")
    public String printBonjour() {
        return "Ici on dit bonjour";
    }
}
