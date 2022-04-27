package fr.boutique.eboutique.model;


import javax.persistence.*;
import java.util.Base64;

@Entity
@Table(name="clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    public Client(){
        super();
    }

    public Client( String username, String password) {
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
        return "Le numéro du client: " +
                this.id +
                ", est lié à l'utilisateur: " +
                this.username;
    }
}