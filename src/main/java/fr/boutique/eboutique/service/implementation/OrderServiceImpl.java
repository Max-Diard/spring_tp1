package fr.boutique.eboutique.service.implementation;

import fr.boutique.eboutique.exception.StockException;
import fr.boutique.eboutique.model.Order;
import fr.boutique.eboutique.model.OrderProduct;
import fr.boutique.eboutique.model.Product;
import fr.boutique.eboutique.service.interfaceService.OrderService;
import fr.boutique.eboutique.service.interfaceService.ProductService;
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
            List<OrderProduct> orderProducts = order.getOrderProductArrayList();

            for (OrderProduct orderProduct : orderProducts) {
                if (!productService.isProductAvailable(orderProduct.getProduct(), orderProduct.getQuantity())) {
                    throw new StockException("Impossible de valider la commande !\nLe stock serait dans le négatif !");
                }
            }

            order.setStatus("Payée");
            for (OrderProduct orderProduct : orderProducts) {
                productService.removeProduct(orderProduct.getProduct(), orderProduct.getQuantity());
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
