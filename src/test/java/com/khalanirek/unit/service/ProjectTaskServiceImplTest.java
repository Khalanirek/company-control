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

import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.notfound.TaskNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.ProjectTaskRepository;
import com.khalanirek.service.impl.ProjectTaskServiceImpl;
import com.khalanirek.service.validation.TaskPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class ProjectTaskServiceImplTest {

	@Mock
	private ProjectTaskRepository projectTaskRepositoryMock;

	@Mock
	private TaskPersistenceValidator taskPersistenceValidator;

	@InjectMocks
	private ProjectTaskServiceImpl projectTaskServiceImpl;

	private ProjectTask projectTask;

	@BeforeEach
	void init() {
		projectTask = new ProjectTask();
		projectTask.setProjectTaskId(1);
	}
	@Test
	void whenSaveProjectTaskThenSetProjectTaskId0() throws ValidationException {
		projectTaskServiceImpl.saveProjectTask(projectTask);
		assertEquals(0, projectTask.getProjectTaskId());
	}

	@Test
	void whenSaveProjectTaskThenValidate() throws ValidationException {
		projectTaskServiceImpl.saveProjectTask(projectTask);
		verify(taskPersistenceValidator).validate(projectTask);
	}

	@Test
	void whenSaveProjectTaskThenRepositorySave() throws ValidationException {
		projectTaskServiceImpl.saveProjectTask(projectTask);
		verify(projectTaskRepositoryMock).save(projectTask);
	}

	@Test
	void whenGetProjectTaskThenRepositoryFindById() throws TaskNotFoundException {
		when(projectTaskRepositoryMock.findById(projectTask.getProjectTaskId())).thenReturn(Optional.of(projectTask));
		projectTaskServiceImpl.getProjectTask(projectTask.getProjectTaskId());
		verify(projectTaskRepositoryMock).findById(projectTask.getProjectTaskId());
	}

	@Test
	void whenGetExistingProjectTaskThenReturnProjectTask() throws TaskNotFoundException {
		when(projectTaskRepositoryMock.findById(projectTask.getProjectTaskId())).thenReturn(Optional.of(projectTask));
		assertEquals(projectTask, projectTaskServiceImpl.getProjectTask(projectTask.getProjectTaskId()));
	}

	@Test
	void whenGetNotExistingProjectTaskThenThrowProjectTaskNotFoundException() {
		when(projectTaskRepositoryMock.findById(projectTask.getProjectTaskId())).thenReturn(Optional.empty());
		assertThrows(TaskNotFoundException.class, () -> projectTaskServiceImpl.getProjectTask(projectTask.getProjectTaskId()));
	}

	@Test
	void whenGetProjectTasksThenReposiotryFindAll() {
		projectTaskServiceImpl.getProjectTasks();
		verify(projectTaskRepositoryMock).findAll();
	}

	@Test
	void whenUpdateNotExistingProjectTaskThenThrowValidationExecption() {
		projectTask.setProjectTaskId(0);
		assertThrows(ValidationException.class, () -> projectTaskServiceImpl.updateProjectTask(projectTask));
	}

	@Test
	void whenUpdateExistingProjectTaskThenValidate() throws ValidationException {
		projectTaskServiceImpl.updateProjectTask(projectTask);
		verify(projectTaskRepositoryMock).save(projectTask);
	}

	@Test
	void whenUpdateExistingProjectTaskThenRepositorySave() throws ValidationException {
		projectTaskServiceImpl.updateProjectTask(projectTask);
		verify(projectTaskRepositoryMock).save(projectTask);
	}

	@Test
	void whenDeleteNotExistingProjectTaskThenThrowProjectTaskNotFoundException() throws TaskNotFoundException {
		assertThrows(TaskNotFoundException.class, () -> projectTaskServiceImpl.deleteProjectTask(0));
	}

	@Test
	void wheneDeleteExistingProjectTaskThenRepositoryDelete() throws TaskNotFoundException {
		when(projectTaskRepositoryMock.findById(projectTask.getProjectTaskId())).thenReturn(Optional.of(projectTask));
		projectTaskServiceImpl.deleteProjectTask(projectTask.getProjectTaskId());
		verify(projectTaskRepositoryMock).delete(projectTask);
	}
}
