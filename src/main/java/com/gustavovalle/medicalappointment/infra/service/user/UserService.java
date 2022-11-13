package com.gustavovalle.medicalappointment.infra.service.user;

import com.gustavovalle.medicalappointment.infra.models.User;
import com.gustavovalle.medicalappointment.application.dtos.UserDto;
import com.gustavovalle.medicalappointment.domain.contracts.repository.UserRepository;
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
