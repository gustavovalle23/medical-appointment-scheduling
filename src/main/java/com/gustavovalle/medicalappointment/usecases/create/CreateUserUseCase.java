package com.gustavovalle.medicalappointment.usecases.create;

import com.gustavovalle.medicalappointment.domain.contracts.repository.UserRepository;
import com.gustavovalle.medicalappointment.domain.entities.User;
import com.gustavovalle.medicalappointment.seedwork.UseCase;

import java.util.Optional;

public class CreateUserUseCase implements UseCase<CreateUserCommand, CreateUserOutput> {
    UserRepository userRepository;
    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserOutput execute(CreateUserCommand command) {
        User user = User.newUser(command.getName(), command.getEmail(), command.getPassword(), command.getBirthDate(), true);
        Optional<User> savedUser = this.userRepository.save(user);
        return savedUser.map(value -> CreateUserOutput.with(value.getName())).orElse(null);
    }
}
