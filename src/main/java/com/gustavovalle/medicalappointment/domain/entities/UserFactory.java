package com.gustavovalle.medicalappointment.domain.entities;

public interface UserFactory {
    User create(String name, String password);
}
