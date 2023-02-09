package com.gustavovalle.restaurant.infra.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserDto {
	private Long id;
	private String name;
	private String email;
	private String password;
	private LocalDate birthDate;

	public UserDto(Long id, String name, String email, String password, LocalDate birthDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
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
		return "UserDto [id=" + id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + "]";
	}

}
