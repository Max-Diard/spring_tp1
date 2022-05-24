package fr.boutique.eboutique.modelDto;

import fr.boutique.eboutique.annotation.PasswordMatches;
import fr.boutique.eboutique.annotation.PasswordValid;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordMatches
@PasswordValid
public class UsersDto {

    @NotNull
    @NotEmpty
    @Size(min=4)
    private String username;

    @NotNull
    @NotEmpty
    @Size(min=6)
    private String password;

    @NotNull
    @NotEmpty
    @Size(min=6)
    private String passwordMatches;

    public UsersDto() {
        super();
    }

    public UsersDto(String username, String password, String passwordMatches) {
        this.username = username;
        this.password = password;
        this.passwordMatches = passwordMatches;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMatches() {
        return passwordMatches;
    }

    public void setPasswordMatches(String passwordMatches) {
        this.passwordMatches = passwordMatches;
    }
}
