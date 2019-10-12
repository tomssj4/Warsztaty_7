package pl.coderslab.game.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

public class UserPasswordFormDTO {

    @Size(min = 8)
    private String password;
    @NotBlank
    @Size(min = 8)
    private String rePassword;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
