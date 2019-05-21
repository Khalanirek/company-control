package com.khalanirek.service.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.khalanirek.entity.User;
import com.khalanirek.exception.validation.ValidationException;

@Component
public class UserPersistenceValidator implements Validator<User> {

	private List<String> errors = new ArrayList<>();

	@Override
	public void validate(User user) throws ValidationException {
		if (user.getUserId() < 0) {
			errors.add("User id is wrong: " + user.getUserId());
		}
		if (user.getRole() == null || user.getRole().isEmpty()) {
			errors.add("User role is empty");
		}
		if (user.getUserPersonalDetails() == null) {
			errors.add("UserPersonalDetails is null");
		}
		if (!errors.isEmpty()) {
			StringBuilder errorsString = new StringBuilder();
			for(String error : errors){
				errorsString.append(error + "\n");
			}
			throw new ValidationException(errorsString.toString());
		}
	}
}
