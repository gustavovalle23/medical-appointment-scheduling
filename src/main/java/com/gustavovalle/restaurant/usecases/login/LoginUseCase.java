package com.gustavovalle.restaurant.usecases.login;

import com.gustavovalle.restaurant.seedwork.UseCase;

public class LoginUseCase implements UseCase<LoginCommand, LoginOutput> {
    @Override
    public LoginOutput execute(LoginCommand command) {
        return LoginOutput.with("token", "refreshToken");
    }
}
