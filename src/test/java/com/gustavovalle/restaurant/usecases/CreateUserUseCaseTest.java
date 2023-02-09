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
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.any;

import java.time.LocalDate;
import java.util.Optional;


@DisplayName("Create User Use Case Unit Tests")
public class CreateUserUseCaseTest {
    final Long id = Long.parseLong("0");
    final String name = "Test Name";
    final String email = "Test Email";
    final String password = "Test Password";
    final LocalDate birthDate = LocalDate.now();

    @InjectMocks
    private CreateUserUseCase useCase;

    @Mock
    private UserRepository userRepository;


    @Test
    @ExtendWith(MockitoExtension.class)
    void givenAValidCommand_whenCallCreateUserUseCase_thenInstantiateANewUser() throws Exception {

        when(userRepository.save(any())).thenAnswer(returnsFirstArg());

        final CreateUserCommand command = new CreateUserCommand(name, email, password, birthDate);
        CreateUserOutput output = useCase.execute(command);

        assertEquals(name, output.getName());
        assertEquals(id, output.getId());
    }


    @Test
    @ExtendWith(MockitoExtension.class)
    void givenADuplicatedEmail_whenCallCreateUserUseCase_thenThrowAnError() {
        User user = User.newUserWithId(new UserID(id), name, email, password, birthDate, true);

        when(userRepository.findByEmail(any())).thenReturn(Optional.of(user));

        final CreateUserCommand command = new CreateUserCommand(name, email, password, birthDate);

        Exception error = assertThrows(Exception.class, () -> useCase.execute(command));
        assertEquals(error.getMessage(), "User with email " + email + " is already registered");
    }
}
