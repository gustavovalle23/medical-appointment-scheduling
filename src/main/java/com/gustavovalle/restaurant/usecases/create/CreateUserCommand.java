package com.gustavovalle.restaurant.usecases.create;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class CreateUserCommand {
    @NotNull(message = "name is required")
    private final String name;

    @NotNull(message = "Email is required")
    private final String email;

    @NotNull(message = "Password is required")
    private final String password;

    @NotNull(message = "Birth date is required!")
    private final Instant birthDate;


    public CreateUserCommand(String name, String email, String password, Instant birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Instant getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
