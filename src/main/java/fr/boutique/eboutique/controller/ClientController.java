package fr.boutique.eboutique.controller;

import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.service.interfaceService.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public List<Client> getClient(){
        return clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @RequestMapping("/create")
    public Client createClient(@RequestParam("username") String username,
                               @RequestParam("password") String password){
        return clientService.save(new Client(username, password));
    }

    @RequestMapping("/delete/{id}")
    public String deleteClientById(@PathVariable("id") Long id){
        return clientService.delete(id);
    }

    @GetMapping("")
    public String getClienByUsername(@RequestParam("username") String username){
        return username;
    }
}
