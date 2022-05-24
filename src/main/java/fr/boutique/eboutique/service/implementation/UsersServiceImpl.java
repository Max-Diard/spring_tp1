package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.ResourceNotFoundException;
import fr.boutique.eboutique.model.Users;
import fr.boutique.eboutique.modelDto.UsersDto;
import fr.boutique.eboutique.repository.RolesRepository;
import fr.boutique.eboutique.repository.UsersRepository;
import fr.boutique.eboutique.security.MyClientPrincipal;
import fr.boutique.eboutique.service.interfaceService.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("Clients")
public class UsersServiceImpl implements UsersService, UserDetailsService {
    private final List<Users> allClient = new ArrayList<>();

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> getAllClient() {
        return usersRepository.findAll();
    }

    @Override
    public Users getClientById(Long clientId) {
        return usersRepository.findById(clientId).orElseThrow(() -> new ResourceNotFoundException("Le client n'existe pas dans la base."));
    }

    @Override
    public Users save(Users client) {
        client.setPassword(passwordEncoder.encode(client.getPassword()));
        client.setRoles(rolesRepository.findByName("ROLE_CLIENT"));
        usersRepository.save(client);
        return client;
    }

    @Override
    public String delete(Long clientId) {
        try {
            Users client = this.getClientById(clientId);
            usersRepository.delete(client);
        } catch (ResourceNotFoundException e) {
            return e.getMessage();
        }
        return "Client Supprimé.";
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Users> client = usersRepository.findByUsername(username);

        System.out.println(client);
        if (client.isPresent()) {
            return new MyClientPrincipal(client.get());
        } else {
            throw new UsernameNotFoundException("Ce username n'existe pas");
        }
    }

    public void registerClient(UsersDto usersDto){
        Users user = new Users();
        user.setUsername(usersDto.getUsername());
        user.setPassword(passwordEncoder.encode(usersDto.getPassword()));
        user.setRoles(rolesRepository.findByName("ROLE_CLIENT"));
        usersRepository.save(user);
    }

}
