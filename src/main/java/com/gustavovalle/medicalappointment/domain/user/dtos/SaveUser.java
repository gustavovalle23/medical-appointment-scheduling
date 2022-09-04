package com.gustavovalle.medicalappointment.domain.user.dtos;

import com.gustavovalle.medicalappointment.domain.address.Address;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class SaveUser {

    @NotNull(message = "Email is required")
    private String email;

    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Birth date is required!")
    private LocalDateTime birthDate;

    @NotNull(message = "Address is required!")
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
