package com.gustavovalle.medicalappointment.usecases;

import com.gustavovalle.medicalappointment.usecases.create.CreateUserCommand;
import com.gustavovalle.medicalappointment.usecases.create.CreateUserOutput;
import com.gustavovalle.medicalappointment.usecases.create.CreateUserUseCase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;


@DisplayName("Create User Use Case Unit Tests")
public class CreateUserUseCaseTest {
    @Test
    void givenAValidCommand_whenCallCreateUserUseCase_thenInstantiateANewUser() {
        final CreateUserUseCase useCase = new CreateUserUseCase(null);
        final CreateUserCommand command = new CreateUserCommand("name", "email", "password", Instant.now());
//        CreateUserOutput output = useCase.execute(command);
    }
}
