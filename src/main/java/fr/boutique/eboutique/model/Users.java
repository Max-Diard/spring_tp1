package fr.boutique.eboutique.model;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id")
    )
    private Collection<Roles> roles;

    public Users(){
        super();
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Roles> roles) {
        this.roles = roles;
    }

    public String roleString(){
        StringBuilder allRole = new StringBuilder();
        for (Roles role :  getRoles()){
            allRole.append(role.getName()).append(" ");
        }
        return allRole.toString();
    }

    @Override
    public String toString() {
        return "Le numéro du client: " +
                this.id +
                ", est lié à l'utilisateur: " +
                this.username +
                ", avec les roles: "+ this.roleString();

    }
}