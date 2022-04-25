package com.boutique.eboutique.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private Long id;
    private LocalDate dateCreated;
    private String status;
    private Client client;
    private ArrayList<OrderProduct> orderProductArrayList = new ArrayList<>();

    public Order(Long id, LocalDate dateCreated, String status, Client client, OrderProduct orderProduct) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.client = client;
        if (orderProduct != null){
            this.orderProductArrayList.add(orderProduct);
        }
    }

    public Long getId(){
        return this.id;
    }

    public LocalDate getDateCreated(){
        return this.dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated){
        this.dateCreated = dateCreated;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public Client getClient(){
        return this.client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    /**
     * Calcule le prix total de cette commande.
     *
     * @return Prix total
     */
    public Double getTotaOrderlPrice(){
        Double total = 0.00;

        for (OrderProduct orderProduct : orderProductArrayList) {
            total += orderProduct.getTotalPrice();
        }

        return total;
    }

    /**
     * Calcule le nombre de types de produits
     *
     * @return int
     */
    public int getNumberOfProducts(){
        ArrayList<Product> total = new ArrayList<>();

        for (OrderProduct orderProduct : orderProductArrayList) {
            Product product = orderProduct.getProduct();
            if (!total.contains(product)){
                total.add(product);
            }
        }

        return total.size();
    }

    /**
     * calcule le nombre total de produits.
     * @return
     */
    public int getTotalNumberOfProducts(){
        int total = 0;

        for (OrderProduct orderProduct : orderProductArrayList) {
            total += orderProduct.getQuantity();
        }

        return total;
    }

    /**
     * ajoute un produit selon une quantité passée en paramètre
     * (créée une instance de OrderProduct et l’ajoute à la liste).
     * }
     */
    public void addProduct(int quantity){
        OrderProduct orderProduct = new OrderProduct(quantity);
        this.orderProductArrayList.add(orderProduct);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", dateCreated=" + dateCreated +
                ", status='" + status + '\'' +
                ", client=" + client +
                ", orderProductArrayList=" + orderProductArrayList +
                '}';
    }
}