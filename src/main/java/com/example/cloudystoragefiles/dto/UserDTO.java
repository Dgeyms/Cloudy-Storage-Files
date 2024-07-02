package com.example.cloudystoragefiles.dto;

import jakarta.validation.constraints.NotEmpty;
import org.springframework.lang.NonNull;

public class UserDTO {

    @NonNull
    @NotEmpty
    private String login;

    @NonNull
    @NotEmpty
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
