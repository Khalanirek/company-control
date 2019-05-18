package com.khalanirek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalanirek.controller.ProjectController;
import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.notfound.PhaseNotFoundException;
import com.khalanirek.exception.notfound.ProjectNotFoundException;
import com.khalanirek.exception.notfound.TaskNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.ProjectPhaseService;
import com.khalanirek.service.ProjectService;
import com.khalanirek.service.ProjectTaskService;

@RestController
@RequestMapping("/projects")
public class ProjectControllerImpl implements ProjectController {

	@Autowired private ProjectService projectService;
	@Autowired private ProjectPhaseService projectPhaseService;
	@Autowired private ProjectTaskService projectTaskService;

	public ProjectControllerImpl() {

	}

	public ProjectControllerImpl(ProjectService projectService, ProjectPhaseService projectPhaseService, ProjectTaskService projectTaskService) {
		this.projectService = projectService;
		this.projectPhaseService = projectPhaseService;
		this.projectTaskService = projectTaskService;
	}

	@Override
	public Project addProject(Project project) throws ValidationException {
		return projectService.saveProject(project);
	}

	@Override
	public Project getProject(long projectId) throws ProjectNotFoundException {
		return projectService.getProject(projectId);
	}

	@Override
	public Iterable<Project> getProjects() {
		return projectService.getProjects();
	}

	@Override
	public Project updateProject(Project project) throws ValidationException {
		return projectService.updateProject(project);
	}

	@Override
	public void deleteProject(long projectId) throws ProjectNotFoundException {
		projectService.deleteProject(projectId);
	}

	@Override
	public ProjectPhase addProjectPhase(ProjectPhase projectPhase) throws ValidationException {
		return projectPhaseService.saveProjectPhase(projectPhase);
	}

	@Override
	public ProjectPhase getProjectPhase(long projectPhaseId) throws PhaseNotFoundException {
		return projectPhaseService.getProjectPhase(projectPhaseId);
	}

	@Override
	public Iterable<ProjectPhase> getProjectPhases() {
		return projectPhaseService.getProjectPhases();
	}

	@Override
	public ProjectPhase updateProjectPhase(ProjectPhase projectPhase) throws ValidationException {
		return projectPhaseService.updateProjectPhase(projectPhase);
	}

	@Override
	public void deleteProjectPhase(long projectPhaseId) throws PhaseNotFoundException {
		projectPhaseService.deleteProjectPhase(projectPhaseId);
	}

	@Override
	public ProjectTask addProjectTask(ProjectTask projectTask) throws ValidationException {
		return projectTaskService.saveProjectTask(projectTask);
	}

	@Override
	public ProjectTask getProjectTask(long projectTaskId) throws TaskNotFoundException {
		return projectTaskService.getProjectTask(projectTaskId);
	}

	@Override
	public Iterable<ProjectTask> getProjectTasks() {
		return projectTaskService.getProjectTasks();
	}

	@Override
	public ProjectTask updateProjectTask(ProjectTask projectTask) throws ValidationException {
		return projectTaskService.updateProjectTask(projectTask);
	}

	@Override
	public void deleteProjectTask(long projectTaskId) throws TaskNotFoundException {
		projectTaskService.deleteProjectTask(projectTaskId);
	}
}
