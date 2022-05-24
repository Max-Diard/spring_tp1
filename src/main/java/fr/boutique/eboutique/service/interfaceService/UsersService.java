package fr.boutique.eboutique.service.interfaceService;

import fr.boutique.eboutique.model.Users;

import java.util.List;

public interface UsersService {

    public List<Users> getAllClient();

    public Users getClientById(Long clientId);

    public Users save(Users client);

    public String delete(Long clientId);
}
