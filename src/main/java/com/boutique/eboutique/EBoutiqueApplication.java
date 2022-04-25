package com.boutique.eboutique;

import com.boutique.eboutique.model.Client;
import com.boutique.eboutique.model.Order;
import com.boutique.eboutique.model.OrderProduct;
import com.boutique.eboutique.model.Product;
import org.springframework.boot.SpringApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
public class EBoutiqueApplication {

    public static void main(String[] args) {
//        SpringApplication.run(EBoutiqueApplication.class, args);

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

//        OrderProduct orderProduct1 = new OrderProduct(5, product1);…
//
//        Order firstOrder = new Order(
//                1L,
//                LocalDate.now(),
//                "En cours",
//                client1,
//                new ArrayList<OrderProduct>());

        System.out.println(client1);
    }


}
