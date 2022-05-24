package fr.boutique.eboutique.security;

import fr.boutique.eboutique.model.Roles;
import fr.boutique.eboutique.model.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyClientPrincipal implements UserDetails {

    private Users client;

    public MyClientPrincipal(Users client) {
        super();
        this.client = client;
    }

    public Users getClient() {
        return client;
    }

    public void setClient(Users client) {
        this.client = client;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<Roles> roles = client.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Roles role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return client.getPassword();
    }

    @Override
    public String getUsername() {
        return client.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
