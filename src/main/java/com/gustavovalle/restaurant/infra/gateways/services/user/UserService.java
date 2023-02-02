package com.gustavovalle.restaurant.infra.gateways.services.user;

import com.gustavovalle.restaurant.infra.models.User;
import com.gustavovalle.restaurant.infra.gateways.repositories.UserRepositoryJpa;
import com.gustavovalle.restaurant.usecases.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepositoryJpa userRepositoryJpa;

    public UserService(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }

    public UserDto saveUser(User newUser) {
        return userRepositoryJpa.save(newUser).toDto();
    }
}
