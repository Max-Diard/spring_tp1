package fr.boutique.eboutique.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Order {

    private Long id;
    private LocalDate dateCreated;
    private String status;
    private Client client;
    private ArrayList<OrderProduct> orderProductArrayList;

    public Order(){
        super();
    }

    public Order(Long id, LocalDate dateCreated, String status, Client client, ArrayList<OrderProduct> orderProduct) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.client = client;
        this.orderProductArrayList = orderProduct;

    }

    public Client getClient(){
        return this.client;
    }

    public void setClient(Client client){
        this.client = client;
    }

    public Long getId(){
        return this.id;
    }

    public LocalDate getDateCreated(){
        return this.dateCreated;
    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    /**
     * Calcule le prix total de cette commande.
     *
     * @return Prix total
     */
    public Double getTotaOrderlPrice(){
        Double total = 0D;

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
        return this.orderProductArrayList.size();
    }

    /**
     * calcule le nombre total de produits.
     *
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
    public void addProduct(Product product, int quantity){
        OrderProduct orderProduct = null;

        // On regarde si le produit est déjà dans la commande, dans ce cas on ajoute seulement la quantité
        for (OrderProduct op: orderProductArrayList) {
            if (op.getProduct().equals(product)) {
                orderProduct = op;
                orderProduct.setQuantity(op.getQuantity() + quantity);
                break;
            }
        }

        // Sinon on ajoute une nouvelle ligne de commande
        if (orderProduct == null) {
            orderProduct = new OrderProduct(quantity, product, this);
            orderProductArrayList.add(orderProduct);
        }
    }

    @Override
    public String toString() {
        return
                "Le client: " +
                this.client.getUsername() +
                " à commandé " +
                this.getNumberOfProducts() +
                " produits : " + this.orderProductArrayList.toString() +
//                ;
//
//        for (OrderProduct orderProduct : orderProductArrayList) {
//            string.append(orderProduct.toString());
//        }
//
//        return string +
                ". La commande est au statut: " +
                this.getStatus() +
                "." ;
    }
}