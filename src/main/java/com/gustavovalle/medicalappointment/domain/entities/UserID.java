package com.gustavovalle.medicalappointment.domain.entities;

import java.util.Objects;

import com.gustavovalle.medicalappointment.domain.Identifier;


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
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

}
