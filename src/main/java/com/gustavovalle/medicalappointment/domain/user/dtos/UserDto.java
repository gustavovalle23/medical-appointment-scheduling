package com.gustavovalle.medicalappointment.domain.user.dtos;

import java.time.LocalDateTime;

public class UserDto {
    private Long id;
    private String email;
    private String password;
    private LocalDateTime birthDate;

    public UserDto(Long id, String email, String password, LocalDateTime birthDate) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
