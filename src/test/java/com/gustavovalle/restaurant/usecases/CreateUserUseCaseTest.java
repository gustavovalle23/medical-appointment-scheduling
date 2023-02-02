package com.gustavovalle.restaurant.usecases;

import com.gustavovalle.restaurant.domain.contracts.repository.UserRepository;
import com.gustavovalle.restaurant.domain.entities.User;
import com.gustavovalle.restaurant.domain.entities.UserID;
import com.gustavovalle.restaurant.usecases.create.CreateUserCommand;
import com.gustavovalle.restaurant.usecases.create.CreateUserOutput;
import com.gustavovalle.restaurant.usecases.create.CreateUserUseCase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;


import java.time.Instant;
import java.util.Optional;


@DisplayName("Create User Use Case Unit Tests")
public class CreateUserUseCaseTest {

    @InjectMocks
    private CreateUserUseCase useCase;

    @Mock
    private UserRepository userRepository;


    @Test
    @ExtendWith(MockitoExtension.class)
    void givenAValidCommand_whenCallCreateUserUseCase_thenInstantiateANewUser() throws Exception {
        User user = User.newUserWithId(new UserID(Long.parseLong("123")), "name", "email", "password", Instant.now(), true);

        when(userRepository.save(any())).thenReturn(Optional.of(user));

        final CreateUserCommand command = new CreateUserCommand("name", "email", "password", Instant.now());
        CreateUserOutput output = useCase.execute(command);

        assertEquals(output.getName(), user.getName());
    }


    @Test
    @ExtendWith(MockitoExtension.class)
    void givenADuplicatedEmail_whenCallCreateUserUseCase_thenThrowAnError() throws Exception {
        User user = User.newUserWithId(new UserID(Long.parseLong("123")), "name", "email", "password", Instant.now(), true);

        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));

        final CreateUserCommand command = new CreateUserCommand("name", "email", "password", Instant.now());

        Exception error = assertThrows(Exception.class, () -> useCase.execute(command));
        assertEquals(error.getMessage(), "User Already Registered");
    }
}
