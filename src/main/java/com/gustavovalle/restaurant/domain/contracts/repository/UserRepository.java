package com.gustavovalle.restaurant.domain.contracts.repository;

import com.gustavovalle.restaurant.domain.entities.User;
import com.gustavovalle.restaurant.seedwork.Repository;

import java.util.Optional;

public interface UserRepository extends Repository<User> {
    Optional<User> findByEmail(String email);
}
