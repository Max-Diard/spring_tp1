package fr.boutique.eboutique.service;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Order;

import java.util.List;

public interface OrderService {
    public List<Order> getAllOrders();

    public Order create(Order order);

    public void update(Order order) throws StockException;
}
