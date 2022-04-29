package fr.boutique.eboutique.model;

import javax.persistence.*;

@Entity
@Table(name="table_order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order order;

    private int quantity;


    public OrderProduct(){
        super();
    }

    public OrderProduct(OrderProductId id, Order order, Product product, int quantity) {
        super();
        this.id = id;
        this.product = product;
        this.order = order;
        this.quantity = quantity;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public Order getOrder(){
        return this.order;
    }


    /**
     * Calcule le prix de cette ligne de commande.
     *
     * @return Le pirx total
     */
    public Double getTotalPrice(){
        return ((double) this.quantity * this.product.getQuantity());
    }

    @Override
    public String toString() {
        return this.getQuantity() + " - " + this.getProduct().getName();
    }
}