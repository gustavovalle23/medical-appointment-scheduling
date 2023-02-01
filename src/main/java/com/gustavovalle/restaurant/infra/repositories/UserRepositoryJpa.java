package com.gustavovalle.restaurant.infra.repositories;

import com.gustavovalle.restaurant.infra.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryJpa extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
