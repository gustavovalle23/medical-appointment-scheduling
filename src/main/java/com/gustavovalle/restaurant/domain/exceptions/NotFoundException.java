package com.gustavovalle.restaurant.domain.exceptions;

import java.util.Collections;
import java.util.List;

import com.gustavovalle.restaurant.domain.AggregateRoot;
import com.gustavovalle.restaurant.domain.Identifier;
import com.gustavovalle.restaurant.domain.validation.Error;

public class NotFoundException extends DomainException {

	protected NotFoundException(final String aMessage, final List<Error> anErrors) {
		super(aMessage, anErrors);
	}

	public static NotFoundException with(
			final Class<? extends AggregateRoot<?>> anAggregate,
			final Identifier id) {
		final var anError = id.getValue() + " with ID %s " + anAggregate.getSimpleName() + " was not found";
		return new NotFoundException(anError, Collections.emptyList());
	}
}
