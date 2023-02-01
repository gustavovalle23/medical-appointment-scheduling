package com.gustavovalle.restaurant.usecases.create;

import java.time.Instant;

public class CreateUserCommand {
    private final String name;
    private final String email;
    private final String password;
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
