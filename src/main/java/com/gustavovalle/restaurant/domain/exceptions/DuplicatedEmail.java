package com.gustavovalle.restaurant.domain.exceptions;

import com.gustavovalle.restaurant.domain.AggregateRoot;
import com.gustavovalle.restaurant.domain.Identifier;
import com.gustavovalle.restaurant.domain.validation.Error;

import java.util.Collections;
import java.util.List;

public class DuplicatedEmail extends DomainException {
    protected DuplicatedEmail(String aMessage, List<Error> anErrors) {
        super(aMessage, anErrors);
    }

    public static DuplicatedEmail with(
            final String email) {
        final var anError = "User with email " + email + " is already registered";
        return new DuplicatedEmail(anError, Collections.emptyList());
    }

}


