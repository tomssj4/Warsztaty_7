package pl.coderslab.game.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class LoginFormDTO {

    @NotBlank
    private String login;
    @NotBlank
    @Size(min = 8)
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
