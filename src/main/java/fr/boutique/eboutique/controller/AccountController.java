package fr.boutique.eboutique.controller;

import fr.boutique.eboutique.model.Users;
import fr.boutique.eboutique.service.implementation.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private UsersServiceImpl clientService;

    @GetMapping("/my-account")
    public String getClientByUsername(Model model){
        System.out.println(" /account: La page account ");
        Users client = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("client", client);
        return "account";
    }

    @GetMapping(value = {  "/create" })
    public String viewCreateClient(Model model){
        System.out.println(" /create: Création d'un compte");
        model.addAttribute("client", new Users());
        return "createAccount";
    }

    @RequestMapping(method = RequestMethod.POST,
                    value ="/create-by-form",
                    consumes = "application/x-www-form-urlencoded")
    public String createByForm(Users client,
                               Model model,
                               BindingResult result) {

        if(result.hasErrors()){
            return "createAccount";
        }

        clientService.save(client);
        model.addAttribute("client", client);
        return "home";
    }
}
