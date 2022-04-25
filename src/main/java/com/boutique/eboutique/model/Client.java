package com.boutique.eboutique.model;

import java.util.Base64;

public class Client {

    private Long id;
    private String username;
    private String password;

    public Client(){
        super();
    }

    public Client(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = Base64.getEncoder().encodeToString(password.getBytes());
    }

    public Long getId(){
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}