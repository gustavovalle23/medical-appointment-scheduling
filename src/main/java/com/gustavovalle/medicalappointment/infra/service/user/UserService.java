package com.gustavovalle.medicalappointment.infra.service.user;

import com.gustavovalle.medicalappointment.infra.models.User;
import com.gustavovalle.medicalappointment.infra.repositories.UserRepositoryJpa;
import com.gustavovalle.medicalappointment.usecases.dtos.UserDto;
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
