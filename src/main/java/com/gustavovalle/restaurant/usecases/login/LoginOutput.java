package com.gustavovalle.restaurant.usecases.login;

public class LoginOutput {
    private final String token;
    private final String refreshToken;

    private LoginOutput(String token, String refreshToken) {
        this.token = token;
        this.refreshToken = refreshToken;
    }

    static LoginOutput with(String token, String refreshToken) {
        return new LoginOutput(token, refreshToken);
    }

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
