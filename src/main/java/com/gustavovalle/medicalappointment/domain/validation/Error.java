package com.gustavovalle.medicalappointment.domain.validation;

public class Error {
    String message;
    public Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
