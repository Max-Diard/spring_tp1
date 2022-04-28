package fr.boutique.eboutique.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Double price;

    @Column
    private String picture;

    @Column
    private Integer quantity;

    public Product(){
        super();
    }

    public Product(String name, String description, Double price, String picture, Integer quantity) {
        super();
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice(){
        return this.price;
    }

    public String getPicture(){
        return this.picture;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

//    @Override
//    public String toString() {
//        return  "Le produit: " +
//                this.name +
//                ", à un stock de: " +
//                this.quantity +
//                ". Le prix à l'unité est de: " +
//                this.price +
//                ".";
//    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", picture='" + picture + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public void setQuantity(int quantityProduct) {
        this.quantity = quantityProduct;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }


}
