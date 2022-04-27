package fr.boutique.eboutique;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.OrderService;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class EBoutiqueApplicationTp4 {
    public static void main(String[] args) {
        SpringApplication.run(EBoutiqueApplicationTp4.class, args);
    }
}
