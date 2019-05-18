package com.khalanirek.unit.controller;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.controller.impl.ProjectControllerImpl;
import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.notfound.PhaseNotFoundException;
import com.khalanirek.exception.notfound.ProjectNotFoundException;
import com.khalanirek.exception.notfound.TaskNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.impl.ProjectPhaseServiceImpl;
import com.khalanirek.service.impl.ProjectServiceImpl;
import com.khalanirek.service.impl.ProjectTaskServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProjectControllerImplTest {

	@Mock
	private ProjectServiceImpl projectServiceImplMock;
	@Mock
	private ProjectPhaseServiceImpl projectPhaseServiceImplMock;
	@Mock
	private ProjectTaskServiceImpl projectTaskServiceImplMock;

	@InjectMocks
	private ProjectControllerImpl projectControllerImpl;

	private Project project;
	private ProjectPhase projectPhase;
	private ProjectTask projectTask;

	@BeforeEach
	void init() {
		project = new Project();
		project.setProjectId(1);
		projectPhase = new ProjectPhase();
		projectPhase.setProjectPhaseId(1);
		projectTask = new ProjectTask();
		projectTask.setProjectTaskId(1);
	}

	@Test
	void whenAddProjectThenServiceSaveProject() throws ValidationException {
		projectControllerImpl.addProject(project);
		verify(projectServiceImplMock).saveProject(project);
	}

	/*@Test
	void whenAddProjectThenReturnProject() throws ValidationException {
		when(projectServiceImplMock.saveProject(project)).thenReturn(project);
		assertEquals(project, projectControllerImpl.addProject(project));
	}*/

	@Test
	void whenGetProjectThenServiceGetProject() throws ProjectNotFoundException {
		projectControllerImpl.getProject(project.getProjectId());
		verify(projectServiceImplMock).getProject(project.getProjectId());
	}

	/*@Test
	void whenGetExistingProjectThenReturnProject() throws ProjectNotFoundException {
		when(projectServiceImplMock.getProject(project.getProjectId())).thenReturn(project);
		assertEquals(project, projectControllerImpl.getProject(project.getProjectId()));
	}*/

	@Test
	void whenGetProjectsThenServiceGetProjects() {
		projectControllerImpl.getProjects();
		verify(projectServiceImplMock).getProjects();
	}

	/*@Test
	void whenGetProjectsThenReturnProjects() {
		List<Project> projectsList = new ArrayList<>();
		projectsList.add(new Project());
		projectsList.add(new Project());
		when(projectServiceImplMock.getProjects()).thenReturn(projectsList);
		assertEquals(projectsList, projectControllerImpl.getProjects());
	}*/

	@Test
	void whenUpdateProjectThenServiceUpdateProject() throws ValidationException {
		projectControllerImpl.updateProject(project);
		verify(projectServiceImplMock).updateProject(project);
	}

	/*@Test
	void whenUpdateExistingProjectThenReturnProject() throws ValidationException {
		when(projectServiceImplMock.updateProject(project)).thenReturn(project);
		assertEquals(project, projectControllerImpl.updateProject(project));
	}*/

	@Test
	void whenDeleteProjectThenServiceDeleteProjcet() throws ProjectNotFoundException {
		projectControllerImpl.deleteProject(project.getProjectId());
		verify(projectServiceImplMock).deleteProject(project.getProjectId());
	}

	@Test
	void whenAddProjectPhaseThenServiceSaveProjectPhase() throws ValidationException {
		projectControllerImpl.addProjectPhase(projectPhase);
		verify(projectPhaseServiceImplMock).saveProjectPhase(projectPhase);
	}

	@Test
	void whenGetProjectPhaseThenServiceGetProjectPhase() throws PhaseNotFoundException {
		projectControllerImpl.getProjectPhase(projectPhase.getProjectPhaseId());
		verify(projectPhaseServiceImplMock).getProjectPhase(projectPhase.getProjectPhaseId());
	}

	@Test
	void whenGetProjectPhasesThenServiceGetProjectPhases() {
		projectControllerImpl.getProjectPhases();
		verify(projectPhaseServiceImplMock).getProjectPhases();
	}

	@Test
	void whenUpdateProjectPhaseThenServiceUpdateProjectPhase() throws ValidationException {
		projectControllerImpl.updateProjectPhase(projectPhase);
		verify(projectPhaseServiceImplMock).updateProjectPhase(projectPhase);
	}

	@Test
	void whenDeleteProjectPhaseThenServiceDeleteProjectPhase() throws PhaseNotFoundException {
		projectControllerImpl.deleteProjectPhase(projectPhase.getProjectPhaseId());
		verify(projectPhaseServiceImplMock).deleteProjectPhase(projectPhase.getProjectPhaseId());
	}

	@Test
	void whenAddProjectTaskThenServiceSaveProjectTask() throws ValidationException {
		projectControllerImpl.addProjectTask(projectTask);
		verify(projectTaskServiceImplMock).saveProjectTask(projectTask);
	}

	@Test
	void whenGetProjectTaskThenServiceGetProjectTask() throws TaskNotFoundException {
		projectControllerImpl.getProjectTask(projectTask.getProjectTaskId());
		verify(projectTaskServiceImplMock).getProjectTask(projectTask.getProjectTaskId());
	}

	@Test
	void whenGetProjectTasksThenServiceGetProjectTasks() {
		projectControllerImpl.getProjectTasks();
		verify(projectTaskServiceImplMock).getProjectTasks();
	}

	@Test
	void whenUpdateProjectTaskThenServiceUpdateProjectTask() throws ValidationException {
		projectControllerImpl.updateProjectTask(projectTask);
		verify(projectTaskServiceImplMock).updateProjectTask(projectTask);
	}

	@Test
	void whenDeleteprojectTaskThenServiceDeleteProjectTask() throws TaskNotFoundException {
		projectControllerImpl.deleteProjectTask(projectTask.getProjectTaskId());
		verify(projectTaskServiceImplMock).deleteProjectTask(projectTask.getProjectTaskId());
	}
}
