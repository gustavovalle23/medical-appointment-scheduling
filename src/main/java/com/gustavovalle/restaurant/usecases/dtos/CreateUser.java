package com.gustavovalle.restaurant.usecases.dtos;

import javax.validation.constraints.NotNull;
import java.time.Instant;

public class CreateUser {
	@NotNull(message = "Name is required")
	private String name;

	@NotNull(message = "Email is required")
	private String email;

	@NotNull(message = "Password is required")
	private String password;

	@NotNull(message = "Birth date is required!")
	private Instant birthDate;

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

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
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
