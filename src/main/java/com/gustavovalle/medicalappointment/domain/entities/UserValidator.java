package com.gustavovalle.medicalappointment.domain.entities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gustavovalle.medicalappointment.domain.validation.Error;
import com.gustavovalle.medicalappointment.domain.validation.ValidationHandler;
import com.gustavovalle.medicalappointment.domain.validation.Validator;

public class UserValidator extends Validator {

	private final User user;
	private final String regexEmail = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

	protected UserValidator(final User user, ValidationHandler handler) {
		super(handler);
		this.user = user;
	}

	@Override
	public void validate() {
		Pattern pattern = Pattern.compile(regexEmail);
		Matcher matcher = pattern.matcher(this.user.getEmail());

		if (!matcher.matches())
			this.validationHandler().append(new Error("Should be a valid e-mail!"));
	}

}
