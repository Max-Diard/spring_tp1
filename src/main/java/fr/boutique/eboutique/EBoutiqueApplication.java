package fr.boutique.eboutique;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Client;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.ClientService;
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

        Client client1 = new Client(2134L, "Maxime", "123456");

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

        System.out.println("-------");

        ProductService productService = context.getBean("products", ProductService.class);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.save(product4);

        productService.getAllProducts().forEach(System.out::println);

        Order order1 = new Order(1l, LocalDate.now(), null, client1, new ArrayList<OrderProduct>());
        Order order2 = new Order(2l, LocalDate.now(), null, client1, new ArrayList<OrderProduct>());


        order1.addProduct(product1, 50);
        order1.addProduct(product3, 30);
        order1.addProduct(product1, 30);

        System.out.println(order1);
        System.out.println("------");

        OrderService orderService = context.getBean("orders", OrderService.class);
        orderService.create(order1);
        System.out.println(order1);

        System.out.println("------");
        try {
            orderService.update(order1);
            System.out.println(order1);
            System.out.println(product1);

        } catch (StockException e){
            System.out.println(e.getMessage());
        }
        System.out.println("------");

        order2.addProduct(product1, 30);
        System.out.println(order2);
        System.out.println("------");

        orderService.create(order2);
        System.out.println(order2);

        System.out.println("------");
        try {
            orderService.update(order2);
            System.out.println(order2);
            System.out.println(product1);

        } catch (StockException e){
            System.out.println(e.getMessage());
        }





    }


}
