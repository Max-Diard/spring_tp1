package fr.boutique.eboutique.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="table_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dateCreated;

    private String status;

    @ManyToOne
    private Users client;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private List<OrderProduct> orderProducts;

    public Order(){
        super();
    }

    public Order(Long id, LocalDate dateCreated, String status, Users client, List<OrderProduct> orderProduct) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.client = client;
        this.orderProducts = orderProduct;
    }

    public Users getClient(){
        return this.client;
    }

    public void setClient(Users client){
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

    public List<OrderProduct> getOrderProductArrayList() {
        return orderProducts;
    }

    /**
     * Calcule le prix total de cette commande.
     *
     * @return Prix total
     */
    public Double getTotaOrderlPrice(){
        Double total = 0D;

        for (OrderProduct orderProduct : orderProducts) {
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
        return this.orderProducts.size();
    }

    /**
     * calcule le nombre total de produits.
     *
     * @return
     */
    public int getTotalNumberOfProducts(){
        int total = 0;

        for (OrderProduct orderProduct : orderProducts) {
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
        for (OrderProduct op: orderProducts) {
            if (op.getProduct().equals(product)) {
                orderProduct = op;
                orderProduct.setQuantity(op.getQuantity() + quantity);
                break;
            }
        }

        // Sinon on ajoute une nouvelle ligne de commande
        if (orderProduct == null) {
            OrderProductId orderProductId = new OrderProductId(product.getId(), id);

            orderProduct = new OrderProduct(orderProductId, this, product, quantity);
            orderProducts.add(orderProduct);
        }
    }

    @Override
    public String toString() {
        return
                "Le client: " +
                this.client.getUsername() +
                " à commandé " +
                this.getNumberOfProducts() +
                " produits : " + this.orderProducts.toString() +
                ". La commande est au statut: " +
                this.getStatus() +
                "." ;
    }
}