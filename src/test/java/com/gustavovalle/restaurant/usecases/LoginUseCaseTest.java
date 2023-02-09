package com.gustavovalle.restaurant.usecases;


import com.gustavovalle.restaurant.domain.contracts.repository.UserRepository;
import com.gustavovalle.restaurant.usecases.login.LoginCommand;
import com.gustavovalle.restaurant.usecases.login.LoginOutput;
import com.gustavovalle.restaurant.usecases.login.LoginUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DisplayName("Create User Use Case Unit Tests")
public class LoginUseCaseTest {

    @InjectMocks
    private LoginUseCase useCase;


    @Test
    @ExtendWith(MockitoExtension.class)
    void givenAValidCommand_whenCallLoginUseCase_thenReturnCredentials() {
        LoginCommand command = new LoginCommand("Email Test", "Password Test");
        LoginOutput output = useCase.execute(command);

        Assertions.assertEquals("token", output.getToken());
        Assertions.assertEquals("refreshToken", output.getRefreshToken());
    }

}
