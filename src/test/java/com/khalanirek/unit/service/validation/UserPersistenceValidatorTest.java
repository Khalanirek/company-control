package com.khalanirek.unit.service.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.User;
import com.khalanirek.entity.UserPersonalDetails;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.validation.UserPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class UserPersistenceValidatorTest {

	private User user = new User();

	@InjectMocks
	private UserPersistenceValidator userPersistenceValidator;

	@BeforeEach
	public void init() {
		user.setUserId(1);
		user.setRole("TEST");
		user.setUserPersonalDetails(new UserPersonalDetails());
	}

	@Test
	public void whenWrongUserIdThenThrowValidationException() {
		user.setUserId(-1);
		assertThrows(ValidationException.class, () -> userPersistenceValidator.validate(user));
	}

	@Test
	public void whenEmptyRoleThenThrowValidationException() {
		user.setRole(null);
		assertThrows(ValidationException.class, () -> userPersistenceValidator.validate(user));
	}

	@Test
	public void whenEmptyUserPersonalDetailsIdThenThrowValidationException() {
		user.setUserPersonalDetails(null);
		assertThrows(ValidationException.class, () -> userPersistenceValidator.validate(user));
	}
}
