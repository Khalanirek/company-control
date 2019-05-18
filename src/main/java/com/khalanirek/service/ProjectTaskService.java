package com.khalanirek.service;

import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.notfound.TaskNotFoundException;
import com.khalanirek.exception.validation.ValidationException;

public interface ProjectTaskService {
	public ProjectTask saveProjectTask(ProjectTask projectTask) throws ValidationException;

	public ProjectTask getProjectTask(long projectTaskId) throws TaskNotFoundException;

	public Iterable<ProjectTask> getProjectTasks();

	public ProjectTask updateProjectTask(ProjectTask projectTask) throws ValidationException;

	public void deleteProjectTask(long projectTaskId) throws TaskNotFoundException;
}
