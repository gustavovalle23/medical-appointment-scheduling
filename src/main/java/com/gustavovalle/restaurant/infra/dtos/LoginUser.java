package com.gustavovalle.restaurant.infra.dtos;

import jakarta.validation.constraints.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


public class LoginUser {
	@NotNull(message = "Email is required")
	private String email;

	@NotNull(message = "Password is required")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}


	@Override
	public String toString() {
		return "LoginUser{" +
				"email='" + email + '\'' +
				", password='" + password + '\'' +
				'}';
	}

	public UsernamePasswordAuthenticationToken convert() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}
}
