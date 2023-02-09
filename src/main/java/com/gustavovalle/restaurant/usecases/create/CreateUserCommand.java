package com.gustavovalle.restaurant.usecases.create;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class CreateUserCommand {
    @NotNull(message = "name is required")
    private final String name;

    @NotNull(message = "Email is required")
    private final String email;

    @NotNull(message = "Password is required")
    private final String password;

    @NotNull(message = "Birth date is required!")
    private final LocalDate birthDate;


    public CreateUserCommand(String name, String email, String password, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
