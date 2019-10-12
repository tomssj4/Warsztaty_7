package pl.coderslab.game.dto;

import org.hibernate.validator.constraints.NotBlank;

public class UserLoginFormDTO {

    @NotBlank
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
