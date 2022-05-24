package fr.boutique.eboutique.controller;

import fr.boutique.eboutique.model.Users;
import fr.boutique.eboutique.service.interfaceService.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class UsersController {

    private UsersService clientService;

    public UsersController(UsersService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Users> getClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Users getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @RequestMapping("/create")
    public Users createClient(@RequestParam("username") String username,
                              @RequestParam("password") String password){
        return clientService.save(new Users(username, password));
    }

    @RequestMapping("/delete/{id}")
    public String deleteClientById(@PathVariable("id") Long id){
        return clientService.delete(id);
    }

}
