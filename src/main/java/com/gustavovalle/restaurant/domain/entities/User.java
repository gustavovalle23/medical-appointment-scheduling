package com.gustavovalle.restaurant.domain.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;

import com.gustavovalle.restaurant.domain.Entity;
import com.gustavovalle.restaurant.domain.validation.ValidationHandler;

public class User extends Entity<UserID> {
    private String name;
    private final String email;
    private final String password;
    private final LocalDate birthDate;
    private boolean active;
    private final Instant createdAt;
    private Instant updatedAt;
    private Instant deletedAt;

    private User(String name, String email, String password, LocalDate birthDate, boolean active,
                 Instant createdAt, Instant updatedAt, Instant deletedAt) {
        super(new UserID(Long.parseLong("0")));
        this.name = name;
        this.email = email;
        this.password = password;
        this.birthDate = birthDate;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.deletedAt = deletedAt;
    }

    private User(UserID id, String name, String email, String password, LocalDate birthDate, boolean active,
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

    public static User newUser(final String name, final String email, final String password,
                               final LocalDate birthDate, final Boolean isActive) {
        final Instant now = Instant.now();
        final Instant deletedAt = Boolean.TRUE.equals(isActive) ? null : now;
        return new User(name, email, password, birthDate, isActive, now, now, deletedAt);
    }

	public static User newUserWithId(final UserID id, final String name, final String email, final String password,
                                     final LocalDate birthDate, final Boolean isActive) {

		final Instant now = Instant.now();
		final Instant deletedAt = Boolean.TRUE.equals(isActive) ? null : now;
		return new User(id, name, email, password, birthDate, isActive, now, now, deletedAt);
	}

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

    public LocalDate getBirthDate() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(this.getId(), user.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
}