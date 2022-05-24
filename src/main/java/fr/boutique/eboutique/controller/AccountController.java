package fr.boutique.eboutique.controller;

import fr.boutique.eboutique.modelDto.UsersDto;
import fr.boutique.eboutique.security.MyClientPrincipal;
import fr.boutique.eboutique.service.implementation.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UsersServiceImpl clientService;

    @GetMapping("/my-account")
    public String getClientByUsername(Model model){
        System.out.println(" /account: La page account ");
        MyClientPrincipal client = (MyClientPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("client", client);
        return "account";
    }

    @GetMapping(value = {"/registration"})
    public String viewCreateClient(Model model){
        System.out.println(" /create: Création d'un compte");
        model.addAttribute("client", new UsersDto());
        return "registration";
    }

    @RequestMapping(method = RequestMethod.POST,
                    value = "/registration-by-form",
                    consumes = "application/x-www-form-urlencoded")
    public String createByForm(@Valid UsersDto client,
                               Model model,
                               BindingResult result) {
        if(result.hasErrors()){
            return "registration";
        }

        clientService.registerClient(client);
        model.addAttribute("client", client);
        return "home";
    }
}
