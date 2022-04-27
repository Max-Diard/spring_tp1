//package fr.boutique.eboutique;
//
//import fr.boutique.eboutique.exception.StockException;
//import fr.boutique.eboutique.model.Client;
//import fr.boutique.eboutique.model.Order;
//import fr.boutique.eboutique.model.OrderProduct;
//import fr.boutique.eboutique.model.Product;
//import fr.boutique.eboutique.service.OrderService;
//import fr.boutique.eboutique.service.ProductService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//@ComponentScan("fr.*")
//public class EBoutiqueApplicationTp3 {
//    public static void main(String[] args) {
//        AnnotationConfigApplicationContext context = new
//                AnnotationConfigApplicationContext(EBoutiqueApplicationTp3.class);
//
////        Client client1 = new Client(2134L, "Maxime", "123456");
//
//        Product product1 = new Product(
//                1L,
//                "Plaque de fer",
//                "Création depuis un minerai de métal",
//                5D,
//                "plaque_de_fer.jpg",
//                100);
//
//        ProductService productService = context.getBean("products", ProductService.class);
//
//        productService.save(product1);
//
////        Order order1 = new Order(1l, LocalDate.now(), null, client1, new ArrayList<OrderProduct>());
//
//        order1.addProduct(product1, 50);
//
//        OrderService orderService = context.getBean("orders", OrderService.class);
//
//        orderService.create(order1);
//        System.out.println(order1);
//
//        System.out.println("------");
//        try {
//            orderService.update(order1);
//            System.out.println(order1);
//            System.out.println(product1);
//
//        } catch (StockException e){
//            System.out.println(e.getMessage());
//        }
//    }
//}
