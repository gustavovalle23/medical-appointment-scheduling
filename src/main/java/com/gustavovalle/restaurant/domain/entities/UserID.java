package com.gustavovalle.restaurant.domain.entities;

import java.util.Objects;

import com.gustavovalle.restaurant.domain.Identifier;


public class UserID extends Identifier {
	private final Long value;

	public UserID(final Long value) {
		Objects.requireNonNull(value);
		this.value = value;
	}

	@Override
	public Long getValue() {
		return value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserID other = (UserID) obj;
		return value.equals(other.value);
	}

}
