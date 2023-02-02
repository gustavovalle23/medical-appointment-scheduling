package com.gustavovalle.restaurant.infra.builders;

import com.gustavovalle.restaurant.usecases.dtos.CreateUser;
import com.gustavovalle.restaurant.usecases.dtos.UserDto;
import com.gustavovalle.restaurant.infra.models.User;

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

    public User build(CreateUser createUser) {
        user.setBirthDate(createUser.getBirthDate());
        user.setEmail(createUser.getEmail());
        user.setPassword(createUser.getPassword());

        return user;
    }
}