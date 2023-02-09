package com.gustavovalle.restaurant.usecases.create;

public class CreateUserOutput {
    private final Long id;

    private final String name;

    private CreateUserOutput(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static CreateUserOutput with(Long id, String name) {
        return new CreateUserOutput(id, name);
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
