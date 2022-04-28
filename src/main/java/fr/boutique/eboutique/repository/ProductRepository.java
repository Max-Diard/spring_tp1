package fr.boutique.eboutique.repository;

import fr.boutique.eboutique.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
