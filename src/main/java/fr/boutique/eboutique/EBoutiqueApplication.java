package fr.boutique.eboutique;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.ClientService;
import fr.boutique.eboutique.service.ClientServiceImpl;
import fr.boutique.eboutique.service.OrderService;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
public class EBoutiqueApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EBoutiqueApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        System.out.println("-------");

        Client client1 = new Client(2134L, "maxime", "123456");

        ClientService clientService = context.getBean("clients", ClientService.class);

        clientService.save(client1);

        clientService.getAllClient().forEach(System.out::println);

        System.out.println("-------");

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

        Order order = new Order(1l, LocalDate.now(), null, client1, new ArrayList<OrderProduct>());

        order.addProduct(product1, 600);
        order.addProduct(product3, 800);

        System.out.println(order);
        System.out.println("------");

        OrderService orderService = context.getBean("orders", OrderService.class);
        orderService.create(order);
        System.out.println(order);

        System.out.println("------");
        try {
            orderService.update(order);
        } catch (Exception e ){
            System.out.println(e);;
        }
        System.out.println(order);
    }


}
