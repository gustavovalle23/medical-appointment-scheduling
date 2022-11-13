package com.gustavovalle.medicalappointment.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.gustavovalle.medicalappointment.infra.models.User;

@DisplayName("User Unit Tests")
public class UserTest {

    @Test
    public void givenAValidParams_whenCallsUser_thenInstantiateUser() {
        new User();
    }

}
