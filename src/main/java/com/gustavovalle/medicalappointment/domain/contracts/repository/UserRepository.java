package com.gustavovalle.medicalappointment.domain.contracts.repository;

import com.gustavovalle.medicalappointment.domain.entities.User;
import com.gustavovalle.medicalappointment.seedwork.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User> {
    Optional<User> findByEmail(String email);
}
