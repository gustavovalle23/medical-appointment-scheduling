package com.gustavovalle.medicalappointment.service.user;

import com.gustavovalle.medicalappointment.domain.user.User;
import com.gustavovalle.medicalappointment.domain.user.dtos.UserDto;
import com.gustavovalle.medicalappointment.repository.UserRepository;
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
