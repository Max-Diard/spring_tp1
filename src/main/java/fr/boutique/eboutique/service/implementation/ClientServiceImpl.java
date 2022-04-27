package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.ResourceNotFoundException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.repository.ClientRepository;
import fr.boutique.eboutique.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("Clients")
public class ClientServiceImpl implements ClientService {
    private final List<Client> allClient = new ArrayList<>();

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(Long clientId) {
        return clientRepository.findById(clientId).orElseThrow(ResourceNotFoundException::new);
//
//        Client client = null;
//
//        for(Client c : allClient){
//            if(Objects.equals(c.getId(), clientId)){
//                client = c;
//                break;
//            }
//        }
//
//        if(client != null){
//            return client;
//        } else {
//            throw new ResourceNotFoundException();
//        }
    }

    @Override
    public Client save(Client client) {
        allClient.add(client);
        clientRepository.save(client);
        return client;
    }
}
