package com.gustavovalle.medicalappointment.domain.entities;

import java.time.Instant;

import com.gustavovalle.medicalappointment.domain.AggregateRoot;
import com.gustavovalle.medicalappointment.domain.validation.ValidationHandler;

public class User extends AggregateRoot<UserID> {
	private String name;
	private final String email;
	private final String password;
	private final Instant birthDate;
	private boolean active;
	private final Instant createdAt;
	private Instant updatedAt;
	private Instant deletedAt;

	private User(UserID id, String name, String email, String password, Instant birthDate, boolean active,
			Instant createdAt, Instant updatedAt, Instant deletedAt) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
		this.birthDate = birthDate;
		this.active = active;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
	}

	public static User newUser(final Long id, final String name, final String email, final String password,
			final Instant birthDate, final Boolean isActive) {
		final Instant now = Instant.now();
		final Instant deletedAt = Boolean.TRUE.equals(isActive) ? null : now;
		return new User(new UserID(id), name, email, password, birthDate, isActive, now, now, deletedAt);
	}

	@Override
	public void validate(ValidationHandler handler) {
		new UserValidator(this, handler).validate();
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", active=" + active
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}

	public User activate() {
		this.deletedAt = null;
		this.active = true;
		this.updatedAt = Instant.now();
		return this;
	}

	public User deactivate() {
		if (getDeletedAt() == null) {
			this.deletedAt = Instant.now();
		}

		this.active = false;
		this.updatedAt = Instant.now();
		return this;
	}

	public User update(final String name, final Boolean isActive) {
		this.name = name;
		this.active = isActive;

		return this;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public boolean isActive() {
		return active;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public Instant getDeletedAt() {
		return deletedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + ((name == null) ? 0 : name.hashCode());
		result = (prime * result) + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (email == null) {
			return other.email == null;
		} else return email.equals(other.email);
	}

}