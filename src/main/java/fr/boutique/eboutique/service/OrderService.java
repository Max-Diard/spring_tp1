package fr.boutique.eboutique.service;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public Order create(Order order);

    public void update(Order order) throws StockException;
}
