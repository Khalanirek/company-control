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

import com.khalanirek.entity.Project;
import com.khalanirek.exception.notfound.ProjectNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.ProjectRepository;
import com.khalanirek.service.impl.ProjectServiceImpl;
import com.khalanirek.service.validation.ProjectPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

	@Mock
	private ProjectRepository projectRepositoryMock;

	@Mock
	private ProjectPersistenceValidator projectPersistenceValidator;

	@InjectMocks
	private ProjectServiceImpl projectServiceImpl;

	private Project project;

	@BeforeEach
	void init() {
		project = new Project();
		project.setProjectId(1);
	}

	@Test
	void whenSaveProjectThenSetProjectId0() throws ValidationException {
		projectServiceImpl.saveProject(project);
		assertEquals(0, project.getProjectId());
	}

	@Test
	void whenSaveProjectThenValidate() throws ValidationException {
		projectServiceImpl.saveProject(project);
		verify(projectPersistenceValidator).validate(project);
	}

	@Test
	void whenSaveProjectThenRepositorySave() throws ValidationException {
		projectServiceImpl.saveProject(project);
		verify(projectRepositoryMock).save(project);
	}

	@Test
	void whenGetProjectThenRepositoryFindById() throws ProjectNotFoundException {
		when(projectRepositoryMock.findById(project.getProjectId())).thenReturn(Optional.of(project));
		projectServiceImpl.getProject(project.getProjectId());
		verify(projectRepositoryMock).findById(project.getProjectId());
	}

	@Test
	void whenGetExistingProjectThenReturnProject() throws ProjectNotFoundException {
		when(projectRepositoryMock.findById(project.getProjectId())).thenReturn(Optional.of(project));
		assertEquals(project, projectServiceImpl.getProject(project.getProjectId()));
	}

	@Test
	void whenGetNotExistingProjectThenThrowProjectNotFoundException() {
		when(projectRepositoryMock.findById(project.getProjectId())).thenReturn(Optional.empty());
		assertThrows(ProjectNotFoundException.class, () -> projectServiceImpl.getProject(project.getProjectId()));
	}

	@Test
	void whenGetProjectsThenReposiotryFindAll() {
		projectServiceImpl.getProjects();
		verify(projectRepositoryMock).findAll();
	}

	@Test
	void whenUpdateNotExistingProjectThenThrowValidationExecption() {
		project.setProjectId(0);
		assertThrows(ValidationException.class, () -> projectServiceImpl.updateProject(project));
	}

	@Test
	void whenUpdateExistingProjectThenValidate() throws ValidationException {
		projectServiceImpl.updateProject(project);
		verify(projectRepositoryMock).save(project);
	}

	@Test
	void whenUpdateExistingProjectThenRepositorySave() throws ValidationException {
		projectServiceImpl.updateProject(project);
		verify(projectRepositoryMock).save(project);
	}

	@Test
	void whenDeleteNotExistingProjectThenThrowProjectNotFoundException() throws ProjectNotFoundException {
		assertThrows(ProjectNotFoundException.class, () -> projectServiceImpl.deleteProject(0));
	}

	@Test
	void wheneDeleteExistingProjectThenRepositoryDelete() throws ProjectNotFoundException {
		when(projectRepositoryMock.findById(project.getProjectId())).thenReturn(Optional.of(project));
		projectServiceImpl.deleteProject(project.getProjectId());
		verify(projectRepositoryMock).delete(project);
	}
}
