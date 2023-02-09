package com.gustavovalle.restaurant.domain.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gustavovalle.restaurant.domain.validation.Error;
import com.gustavovalle.restaurant.domain.validation.ValidationHandler;
import com.gustavovalle.restaurant.domain.validation.Validator;

public class UserValidator extends Validator {

	private final User user;

	protected UserValidator(final User user, ValidationHandler handler) {
		super(handler);
		this.user = user;
	}

	@Override
	public void validate() {
		String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher = pattern.matcher(this.user.getEmail());

		if (!matcher.matches())
			this.validationHandler().append(new Error("Should be a valid e-mail!"));
	}
}
