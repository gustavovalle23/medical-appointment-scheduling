package com.gustavovalle.medicalappointment.domain.contracts.repository;

import com.gustavovalle.medicalappointment.infra.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
