package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.OrderService;
import fr.boutique.eboutique.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("orders")
public class OrderServiceImpl implements OrderService {

    private List<Order> allOrders = new ArrayList<Order>();

    @Autowired
    private ProductService productService;

    @Override
    public List<Order> getAllOrders() {
        return allOrders;
    }

    @Override
    public Order create(Order order) {
        order.setStatus("En cours");
        return order;
    }

    @Override
    public void update(Order order) throws StockException {
        if(!Objects.equals(order.getStatus(), "Payée")){
            ArrayList<OrderProduct> orderProducts = order.getOrderProductArrayList();

            for (OrderProduct orderProduct : orderProducts) {
                Product product = productService.getProductById(orderProduct.getProduct().getId());

                int quantityProduct = product.getQuantity();
                int quantityOrder = orderProduct.getQuantity();

                int newQuantity = quantityProduct - quantityOrder;

                if (newQuantity < 0) {
                    throw new StockException("Impossible de valider la commande !\nLe stock serait dans le négatif !");
                }
            }

            order.setStatus("Payée");
            for (OrderProduct orderProduct : orderProducts) {
                Product product = productService.getProductById(orderProduct.getProduct().getId());

                int quantityProduct = product.getQuantity();
                int quantityOrder = orderProduct.getQuantity();

                int newQuantity = quantityProduct - quantityOrder;
                product.setQuantity(newQuantity);

                productService.save(product);
            }

        }
    }

    public void setProductService(ProductServiceImpl productService){
        this.productService = productService;
    }

    public ProductService getProductService(){
        return productService;
    }
}
