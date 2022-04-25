package com.boutique.eboutique.model;

public class OrderProduct {

    private Integer quantity;
    private Long idProduct;
    private Long idOrder;

    public OrderProduct(Integer quantity, Long idProduct, Long idOrder) {
        this.quantity = quantity;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
    }

    public Integer getQuantity(){
        return this.quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public Long getIdProduct(){
        return this.idProduct;
    }

    public Long getIdOrder(){
        return this.idOrder
    }

}