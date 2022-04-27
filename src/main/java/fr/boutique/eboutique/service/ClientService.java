package fr.boutique.eboutique.service;

import fr.boutique.eboutique.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientService {

    public List<Client> getAllClient();

    public Client getClientById(Long clientId);

    public Client save(Client client);

    public String delete(Long clientId);
}
