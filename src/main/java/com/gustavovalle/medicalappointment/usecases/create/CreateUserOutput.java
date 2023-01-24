package com.gustavovalle.medicalappointment.usecases.create;

public class CreateUserOutput {
    private final String name;

    private CreateUserOutput(String name) {
        this.name = name;
    }


    static CreateUserOutput with(String name) {
        return new CreateUserOutput(name);
    }

    public String getName() {
        return name;
    }
}
