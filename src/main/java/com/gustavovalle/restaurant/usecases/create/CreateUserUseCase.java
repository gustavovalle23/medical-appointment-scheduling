package com.gustavovalle.restaurant.usecases.create;

import com.gustavovalle.restaurant.domain.contracts.repository.UserRepository;
import com.gustavovalle.restaurant.domain.entities.User;
import com.gustavovalle.restaurant.domain.exceptions.DuplicatedEmail;
import com.gustavovalle.restaurant.seedwork.UseCase;


public class CreateUserUseCase implements UseCase<CreateUserCommand, CreateUserOutput> {
    UserRepository userRepository;
    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public CreateUserOutput execute(CreateUserCommand command) {
        User user = User.newUser(command.getName(), command.getEmail(), command.getPassword(), command.getBirthDate(), true);

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw DuplicatedEmail.with(user.getEmail());
        }

        User savedUser = this.userRepository.save(user);

        return CreateUserOutput.with(savedUser.getId().getValue(), savedUser.getName());
    }
}
