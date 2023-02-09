package com.gustavovalle.restaurant.usecases.login;

import javax.validation.constraints.NotNull;

public class LoginCommand {
    @NotNull
    private final String email;

    @NotNull
    private final String password;

    public LoginCommand(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
