package com.khalanirek.unit.service.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.validation.PhasePersistenceValidator;

@ExtendWith(MockitoExtension.class)
class PhasePersistenceValidatorTest {

	private ProjectPhase projectPhase = new ProjectPhase();

	@InjectMocks
	private PhasePersistenceValidator phasePersistenceValidator;

	@BeforeEach
	public void init() {
		projectPhase.setProjectPhaseId(1);
		projectPhase.setProject(new Project());
		projectPhase.setName("TEST");
		projectPhase.setStartTime(new Timestamp(1));
		projectPhase.setEndTime(new Timestamp(1));
	}

	@Test
	public void whenWrongProjectPhaseIdThenThrowValidationException() {
		projectPhase.setProjectPhaseId(-1);
		assertThrows(ValidationException.class, () -> phasePersistenceValidator.validate(projectPhase));
	}

	@Test
	public void whenEmptyProjectThenThrowValidationException() {
		projectPhase.setProject(null);
		assertThrows(ValidationException.class, () -> phasePersistenceValidator.validate(projectPhase));
	}

	@Test
	public void whenEmptyNameThenThrowValidationException() {
		projectPhase.setName(null);
		assertThrows(ValidationException.class, () -> phasePersistenceValidator.validate(projectPhase));
	}

	@Test
	public void whenEmptyStartTimeThenThrowValidationException() {
		projectPhase.setStartTime(null);
		assertThrows(ValidationException.class, () -> phasePersistenceValidator.validate(projectPhase));
	}

	@Test
	public void whenEmptyEndTimeThenThrowValidationException() {
		projectPhase.setEndTime(null);
		assertThrows(ValidationException.class, () -> phasePersistenceValidator.validate(projectPhase));
	}
}
