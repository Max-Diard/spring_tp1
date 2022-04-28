package fr.boutique.eboutique;

import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EBoutiqueApplicationTp4 {
    public static void main(String[] args) {
        SpringApplication.run(EBoutiqueApplicationTp4.class, args);
    }

//    @Bean
//    public CommandLineRunner runner(ProductService productService) {
//        return args -> {
//            Product product1 = new Product("Plaque de fer", "Ce fabrique à partir de minerai de fer", 12d, "https://static.wikia.nocookie.net/satisfactory_gamepedia_en/images/5/51/Iron_Plate.png",200);
//            Product product2 = new Product("Tige de fer", "Ce fabrique à partir d'une plaque de fer", 32d, "https://static.wikia.nocookie.net/satisfactory_gamepedia_en/images/5/5f/Iron_Rod.png",400);
//            productService.getAllProducts();
//        };
//    }
}
