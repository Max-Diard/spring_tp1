package fr.boutique.eboutique.model;

public class OrderProduct {

    private Integer quantity;
    private Product product;
    private Order order;

    public OrderProduct(){
        super();
    }

    public OrderProduct(Integer quantity, Product product, Order order) {
        super();
        this.quantity = quantity;
        this.product = product;
        this.order = order;
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
        return this.getQuantity() + " - " + this.getProduct().getName() + " . ";
    }
}