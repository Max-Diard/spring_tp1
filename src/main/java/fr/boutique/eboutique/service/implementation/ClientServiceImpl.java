package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.ResourceNotFoundException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.service.ClientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ClientServiceImpl implements ClientService {
    private final List<Client> allClient = new ArrayList<>();

    @Override
    public List<Client> getAllClient() {
        return allClient;
    }

    @Override
    public Client getClientById(Long clientId) {
        Client client = null;

        for(Client c : allClient){
            if(Objects.equals(c.getId(), clientId)){
                client = c;
                break;
            }
        }

        if(client != null){
            return client;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Client save(Client client) {
        allClient.add(client);
        return client;
    }
}
