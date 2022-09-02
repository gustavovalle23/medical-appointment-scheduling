package com.gustavovalle.medicalappointment.domain.entities;

public interface User {

    boolean passwordIsValid();

    String getName();

    String getPassword();
}
