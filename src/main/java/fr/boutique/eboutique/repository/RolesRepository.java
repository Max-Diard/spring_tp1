package fr.boutique.eboutique.repository;

import fr.boutique.eboutique.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Collection<Roles> findByName(String role_client);
}
