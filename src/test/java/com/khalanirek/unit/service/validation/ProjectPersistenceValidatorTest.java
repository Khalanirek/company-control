package com.khalanirek.unit.service.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.User;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.validation.ProjectPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class ProjectPersistenceValidatorTest {

	private Project project = new Project();

	@InjectMocks
	private ProjectPersistenceValidator projectPersistenceValidator;

	@BeforeEach
	public void init() {
		project.setProjectId(1);
		project.setNumber(1);
		project.setName("TEST");
		project.setOwner(new User());
		project.setCreator(new User());
		project.setStartTime(new Timestamp(1));
		project.setEndTime(new Timestamp(1));
	}

	@Test
	public void whenWrongProjectIdThenThrowValidationException() {
		project.setProjectId(-1);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}

	@Test
	public void whenWrongNumberThenThrowValidationException() {
		project.setNumber(-1);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}

	@Test
	public void whenEmptyNameThenThrowValidationException() {
		project.setName(null);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}

	@Test
	public void whenEmptyOwnerThenThrowValidationException() {
		project.setOwner(null);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}

	@Test
	public void whenEmptyCreatorThenThrowValidationException() {
		project.setCreator(null);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}

	@Test
	public void whenEmptyStartTimeThenThrowValidationException() {
		project.setStartTime(null);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}

	@Test
	public void whenEmptyEndTimeThenThrowValidationException() {
		project.setEndTime(null);
		assertThrows(ValidationException.class, () -> projectPersistenceValidator.validate(project));
	}
}
