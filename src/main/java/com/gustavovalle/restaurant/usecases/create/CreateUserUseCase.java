package com.gustavovalle.restaurant.usecases.create;

import com.gustavovalle.restaurant.domain.contracts.repository.UserRepository;
import com.gustavovalle.restaurant.domain.entities.User;
import com.gustavovalle.restaurant.seedwork.UseCase;

import java.util.Optional;

public class CreateUserUseCase implements UseCase<CreateUserCommand, CreateUserOutput> {
    UserRepository userRepository;
    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserOutput execute(CreateUserCommand command) throws Exception {
        User user = User.newUser(command.getName(), command.getEmail(), command.getPassword(), command.getBirthDate(), true);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("User Already Registered");
        }

        User savedUser = this.userRepository.save(user);

        return CreateUserOutput.with(savedUser.getId().getValue(), savedUser.getName());
    }
}
