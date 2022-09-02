package com.gustavovalle.medicalappointment.domain.entities;

public class CommonUser implements User{
    String name;
    String password;

    public CommonUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public CommonUser() {
    }

    @Override
    public boolean passwordIsValid() {
        return password != null && password.length() > 5;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
