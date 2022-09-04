package com.gustavovalle.medicalappointment.shared;

import com.gustavovalle.medicalappointment.domain.user.User;
import com.gustavovalle.medicalappointment.domain.user.dtos.SaveUser;
import com.gustavovalle.medicalappointment.domain.user.dtos.UserDto;

public final class UserBuilder {
    private static User user;

    public static UserBuilder user() {
        user = new User();
        return new UserBuilder();
    }

    public User build(UserDto userDto) {
        user.setId(userDto.getId());
        user.setBirthDate(userDto.getBirthDate());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }

    public User build(SaveUser saveUser) {
        user.setBirthDate(saveUser.getBirthDate());
        user.setEmail(saveUser.getEmail());
        user.setPassword(saveUser.getPassword());

        return user;
    }
}
