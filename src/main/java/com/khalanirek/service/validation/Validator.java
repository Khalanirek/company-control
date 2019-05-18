package com.khalanirek.service.validation;

import com.khalanirek.exception.validation.ValidationException;

public interface Validator<T> {

	public void validate(T object) throws ValidationException;
}
