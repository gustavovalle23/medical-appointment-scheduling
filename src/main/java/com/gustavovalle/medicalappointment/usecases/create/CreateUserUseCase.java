package com.gustavovalle.medicalappointment.usecases.create;

import com.gustavovalle.medicalappointment.infra.repositories.UserRepository;
import com.gustavovalle.medicalappointment.seedwork.UseCase;

public class CreateUserUseCase implements UseCase<CreateUserCommand, CreateUserOutput> {
    UserRepository userRepository;
    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserOutput execute(CreateUserCommand anIn) {
        return null;
    }
}
