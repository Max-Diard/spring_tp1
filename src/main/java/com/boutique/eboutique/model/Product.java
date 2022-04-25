package com.boutique.eboutique.model;

public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String picture;
    private Integer quantity;

    public Product(){
        super();
    }

    public Product(Long id, String name, String description, Double price, String picture, Integer quantity) {
        super();
        this.id = id;
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
}