package com.boutique.eboutique.model;

import java.time.LocalDate;

public class Order {

    private Long id;
    private LocalDate dateCreated;
    private String status;
    private Long idClient;

    public Order(Long id, LocalDate dateCreated, String status, Long idClient) {
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.idClient = idClient;
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

    public Long getIdClient(){
        return this.idClient;
    }

    public void setIdClient(Long idClient){
        this.idClient = idClient;
    }
}