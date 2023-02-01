package com.gustavovalle.restaurant.infra.service.user;

import com.gustavovalle.restaurant.infra.models.User;
import com.gustavovalle.restaurant.infra.repositories.UserRepositoryJpa;
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
