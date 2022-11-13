package com.gustavovalle.medicalappointment.domain.validation;


import java.util.List;

import com.gustavovalle.medicalappointment.domain.exceptions.DomainException;

public class ThrowsValidationHandler implements ValidationHandler {

	@Override
	public ValidationHandler append(final Error anError) {
		throw DomainException.with(anError);
	}

	@Override
	public ValidationHandler append(final ValidationHandler anHandler) {
		throw DomainException.with(anHandler.getErrors());
	}

	@Override
	public <T> T validate(final Validation<T> aValidation) {
		try {
			return aValidation.validate();
		} catch (final Exception ex) {
			throw DomainException.with(new Error(ex.getMessage()));
		}
	}

	@Override
	public List<Error> getErrors() {
		return List.of();
	}
}
