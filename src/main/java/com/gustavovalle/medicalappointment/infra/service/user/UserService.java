package com.gustavovalle.medicalappointment.infra.service.user;

import com.gustavovalle.medicalappointment.infra.models.User;
import com.gustavovalle.medicalappointment.infra.repositories.UserRepository;
import com.gustavovalle.medicalappointment.usecases.dtos.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto saveUser(User newUser) {
        return userRepository.save(newUser).toDto();
    }
}
