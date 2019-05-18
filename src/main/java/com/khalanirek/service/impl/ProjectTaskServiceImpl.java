package com.khalanirek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.notfound.TaskNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.ProjectTaskRepository;
import com.khalanirek.service.ProjectTaskService;
import com.khalanirek.service.validation.TaskPersistenceValidator;

public class ProjectTaskServiceImpl implements ProjectTaskService {

	@Autowired private ProjectTaskRepository projectTaskRepository;
	@Autowired private TaskPersistenceValidator taskPersistanceValidator;


	public ProjectTaskServiceImpl() {

	}

	public ProjectTaskServiceImpl(ProjectTaskRepository projectTaskRepository, TaskPersistenceValidator taskPersistanceValidator) {
		this.projectTaskRepository = projectTaskRepository;
		this.taskPersistanceValidator = taskPersistanceValidator;
	}

	@Override
	public ProjectTask saveProjectTask(ProjectTask projectTask) throws ValidationException {
		projectTask.setProjectTaskId(0);
		taskPersistanceValidator.validate(projectTask);
		return projectTaskRepository.save(projectTask);
	}

	@Override
	public ProjectTask getProjectTask(long projectTaskId) throws TaskNotFoundException {
		return projectTaskRepository.findById(projectTaskId).orElseThrow(() -> new TaskNotFoundException(projectTaskId));
	}

	@Override
	public Iterable<ProjectTask> getProjectTasks() {
		return projectTaskRepository.findAll();
	}

	@Override
	public ProjectTask updateProjectTask(ProjectTask projectTask) throws ValidationException {
		if (projectTask.getProjectTaskId() == 0) {
			throw new ValidationException("TaskId = 0 during update");
		}
		taskPersistanceValidator.validate(projectTask);
		return projectTaskRepository.save(projectTask);
	}

	@Override
	public void deleteProjectTask(long projectTaskId) throws TaskNotFoundException {
		ProjectTask projectTask = this.getProjectTask(projectTaskId);
		projectTaskRepository.delete(projectTask);
	}

}
