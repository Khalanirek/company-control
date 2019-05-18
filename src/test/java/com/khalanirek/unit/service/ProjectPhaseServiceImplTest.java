package com.khalanirek.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.exception.notfound.PhaseNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.ProjectPhaseRepository;
import com.khalanirek.service.impl.ProjectPhaseServiceImpl;
import com.khalanirek.service.validation.PhasePersistenceValidator;

@ExtendWith(MockitoExtension.class)
class ProjectPhaseServiceImplTest {

	@Mock
	private ProjectPhaseRepository projectPhaseRepositoryMock;

	@Mock
	private PhasePersistenceValidator phasePersistenceValidator;

	@InjectMocks
	private ProjectPhaseServiceImpl projectPhaseServiceImpl;

	private ProjectPhase projectPhase;

	@BeforeEach
	void init() {
		projectPhase = new ProjectPhase();
		projectPhase.setProjectPhaseId(1);
	}


	@Test
	void whenSaveProjectPhaseThenSetProjectPhaseId0() throws ValidationException {
		projectPhaseServiceImpl.saveProjectPhase(projectPhase);
		assertEquals(0, projectPhase.getProjectPhaseId());
	}

	@Test
	void whenSaveProjectPhaseThenValidate() throws ValidationException {
		projectPhaseServiceImpl.saveProjectPhase(projectPhase);
		verify(phasePersistenceValidator).validate(projectPhase);
	}

	@Test
	void whenSaveProjectPhaseThenRepositorySave() throws ValidationException {
		projectPhaseServiceImpl.saveProjectPhase(projectPhase);
		verify(projectPhaseRepositoryMock).save(projectPhase);
	}

	@Test
	void whenGetProjectPhaseThenRepositoryFindById() throws PhaseNotFoundException {
		when(projectPhaseRepositoryMock.findById(projectPhase.getProjectPhaseId())).thenReturn(Optional.of(projectPhase));
		projectPhaseServiceImpl.getProjectPhase(projectPhase.getProjectPhaseId());
		verify(projectPhaseRepositoryMock).findById(projectPhase.getProjectPhaseId());
	}

	@Test
	void whenGetExistingProjectPhaseThenReturnProjectPhase() throws PhaseNotFoundException {
		when(projectPhaseRepositoryMock.findById(projectPhase.getProjectPhaseId())).thenReturn(Optional.of(projectPhase));
		assertEquals(projectPhase, projectPhaseServiceImpl.getProjectPhase(projectPhase.getProjectPhaseId()));
	}

	@Test
	void whenGetNotExistingProjectPhaseThenThrowProjectPhaseNotFoundException() {
		when(projectPhaseRepositoryMock.findById(projectPhase.getProjectPhaseId())).thenReturn(Optional.empty());
		assertThrows(PhaseNotFoundException.class, () -> projectPhaseServiceImpl.getProjectPhase(projectPhase.getProjectPhaseId()));
	}

	@Test
	void whenGetProjectPhasesThenReposiotryFindAll() {
		projectPhaseServiceImpl.getProjectPhases();
		verify(projectPhaseRepositoryMock).findAll();
	}

	@Test
	void whenUpdateNotExistingProjectPhaseThenThrowValidationExecption() {
		projectPhase.setProjectPhaseId(0);
		assertThrows(ValidationException.class, () -> projectPhaseServiceImpl.updateProjectPhase(projectPhase));
	}

	@Test
	void whenUpdateExistingProjectPhaseThenValidate() throws ValidationException {
		projectPhaseServiceImpl.updateProjectPhase(projectPhase);
		verify(projectPhaseRepositoryMock).save(projectPhase);
	}

	@Test
	void whenUpdateExistingProjectPhaseThenRepositorySave() throws ValidationException {
		projectPhaseServiceImpl.updateProjectPhase(projectPhase);
		verify(projectPhaseRepositoryMock).save(projectPhase);
	}

	@Test
	void whenDeleteNotExistingProjectPhaseThenThrowProjectPhaseNotFoundException() throws PhaseNotFoundException {
		assertThrows(PhaseNotFoundException.class, () -> projectPhaseServiceImpl.deleteProjectPhase(0));
	}

	@Test
	void wheneDeleteExistingProjectPhaseThenRepositoryDelete() throws PhaseNotFoundException {
		when(projectPhaseRepositoryMock.findById(projectPhase.getProjectPhaseId())).thenReturn(Optional.of(projectPhase));
		projectPhaseServiceImpl.deleteProjectPhase(projectPhase.getProjectPhaseId());
		verify(projectPhaseRepositoryMock).delete(projectPhase);
	}
}
