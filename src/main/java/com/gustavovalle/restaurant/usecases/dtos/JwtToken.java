package com.gustavovalle.restaurant.usecases.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JwtToken {
	private String token;

	public JwtToken(String token) {
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
