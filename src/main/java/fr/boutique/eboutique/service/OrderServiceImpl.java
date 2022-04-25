package fr.boutique.eboutique.service;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderServiceImpl implements OrderService {

    private List<Order> allOrders = new ArrayList<Order>();

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

            for(int i = 0; i < orderProducts.size(); i++){
                int quantityProduct = orderProducts.get(i).getProduct().getQuantity();
                int quantityOrder = orderProducts.get(i).getQuantity();

                if(quantityProduct - quantityOrder  < 0){
                    throw new StockException("Marche pas");
                } else {
                    order.setStatus("Payée");
                    orderProducts.get(i).getProduct().setQuantity(quantityProduct - quantityOrder);
                }
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
