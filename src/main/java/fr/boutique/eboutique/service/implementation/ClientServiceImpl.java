package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.ResourceNotFoundException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.repository.ClientRepository;
import fr.boutique.eboutique.service.interfaceService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("Clients")
public class ClientServiceImpl implements ClientService, UserDetailsService {
    private final List<Client> allClient = new ArrayList<>();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Le client n'existe pas dans la base."));
    }

    @Override
    public Client save(Client client) {
        allClient.add(client);
        clientRepository.save(client);
        return client;
    }

    @Override
    public String delete(Long clientId) {
        try{
            Client client = this.getClientById(clientId);
            clientRepository.delete(client);
        } catch (ResourceNotFoundException e){
            return e.getMessage();
        }
        return "Client Supprimé.";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Client client = clientRepository.findByUsername(username);

        System.out.println(client);
        if(client != null){
            return client;
        } else {
            throw new UsernameNotFoundException("Ce username n'existe pas");
        }
    }
}
