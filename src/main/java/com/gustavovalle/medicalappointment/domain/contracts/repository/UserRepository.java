package com.gustavovalle.medicalappointment.domain.contracts.repository;

import com.gustavovalle.medicalappointment.infra.models.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
}
