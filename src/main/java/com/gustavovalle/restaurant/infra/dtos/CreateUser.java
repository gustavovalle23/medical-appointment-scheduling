package com.gustavovalle.restaurant.infra.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateUser {
	@NotNull(message = "Name is required")
	private String name;

	@NotNull(message = "Email is required")
	private String email;

	@NotNull(message = "Password is required")
	private String password;

	@NotNull(message = "Birth date is required!")
	private LocalDate birthDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreateUser{" +
				"name='" + name + '\'' +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", birthDate=" + birthDate +
				'}';
	}
}
