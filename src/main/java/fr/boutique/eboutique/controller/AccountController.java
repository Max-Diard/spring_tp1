package fr.boutique.eboutique.controller;

import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/my-account")
    public String getClientByUsername(Model model){
        System.out.println(" /account: La page account ");
        Client client = (Client) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("client", client);
        return "account";
    }

    @GetMapping(value = {  "/create" })
    public String viewCreateClient(Model model){
        System.out.println(" /create: Création d'un compte");
        model.addAttribute("account", new Client());
        return "createAccount";
    }

    @RequestMapping(method = RequestMethod.POST,
                    value ="/create-by-form",
                    consumes = "application/x-www-form-urlencoded")
    public String createByForm(Client client,
                               Model model,
                               BindingResult result) {

        if(result.hasErrors()){
            return "createAccount";
        }

        clientRepository.save(client);
        model.addAttribute("client", client);
        return "home";
    }
}
