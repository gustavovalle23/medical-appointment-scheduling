package com.gustavovalle.customauthentication.shared;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtTokenDTO {
    private String token;

    public JwtTokenDTO(String token) {
        this.token = token;
    }

    @JsonProperty("token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
