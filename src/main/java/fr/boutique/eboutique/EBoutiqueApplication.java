package fr.boutique.eboutique;

import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
public class EBoutiqueApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EBoutiqueApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        Client client1 = new Client(2134L, "maxime", "123456");

        Product product1 = new Product(
                1L,
                "Plaque de fer",
                "Création depuis un minerai de métal",
                5D,
                "plaque_de_fer.jpg",
                100);

        Product product2 = new Product(
                2L,
                "Tige de fer",
                "Création depuis une plaque de fer",
                10D,
                "tige_de_fer.jpg",
                100);

        Product product3 = new Product(
                3L,
                "Vis",
                "Création depuis une tige de fer",
                15D,
                "vis.jpg",
                100);

        Product product4 = new Product(
                4L,
                "Béton",
                "Création depuis un minerai de calcaire",
                5D,
                "beton.jpg",
                100);

        ProductService productService = context.getBean("products", ProductService.class);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);

        productService.getAllProducts().forEach(System.out::println);
    }


}
