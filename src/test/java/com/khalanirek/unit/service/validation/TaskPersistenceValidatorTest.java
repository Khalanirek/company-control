package com.khalanirek.unit.service.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.validation.TaskPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class TaskPersistenceValidatorTest {

	private ProjectTask projectTask = new ProjectTask();

	@InjectMocks
	TaskPersistenceValidator taskPersistenceValidator;

	@BeforeEach
	public void init() {
		projectTask.setProjectTaskId(1);
		projectTask.setTittle("TEST");
		projectTask.setProject(new Project());
		projectTask.setOwnerId(1);
		projectTask.setCreatorId(1);
		projectTask.setStartTime(new Timestamp(1));
		projectTask.setEndTime(new Timestamp(1));
	}

	@Test
	public void whenWrongProjectTaskIdThenThrowValidationException() {
		projectTask.setProjectTaskId(-1);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}

	@Test
	public void whenEmptyTittleThenThrowValidationException() {
		projectTask.setTittle(null);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}

	@Test
	public void whenEmptyProjectThenThrowValidationException() {
		projectTask.setProject(null);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}

	@Test
	public void whenWrongOwnerIdThenThrowValidationException() {
		projectTask.setOwnerId(-1);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}

	@Test
	public void whenWrongCreatorIdThenThrowValidationException() {
		projectTask.setCreatorId(-1);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}

	@Test
	public void whenEmptyStartTimeThenThrowValidationException() {
		projectTask.setStartTime(null);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}

	@Test
	public void whenEmptyEndTimeThenThrowValidationException() {
		projectTask.setEndTime(null);
		assertThrows(ValidationException.class, () -> taskPersistenceValidator.validate(projectTask));
	}
}