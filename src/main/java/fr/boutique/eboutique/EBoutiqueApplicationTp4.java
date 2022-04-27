package fr.boutique.eboutique;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.OrderService;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EBoutiqueApplicationTp4 {
    public static void main(String[] args) {
        SpringApplication.run(EBoutiqueApplicationTp4.class, args);
    }

    @Bean
    public CommandLineRunner runner(ProductService productService) {
        return args -> {
            Product product1 = new Product(1L, "Plaque de fer", "desc1", 12d, "url1",200);
            Product product2 = new Product(2L, "Tige de fer", "desc2", 32d, "url2",400);
            productService.save(product1);
            productService.save(product2);
        };
    }
}
