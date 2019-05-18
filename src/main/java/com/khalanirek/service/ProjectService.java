package com.khalanirek.service;

import org.springframework.stereotype.Service;

import com.khalanirek.entity.Project;
import com.khalanirek.exception.notfound.ProjectNotFoundException;
import com.khalanirek.exception.validation.ValidationException;

@Service
public interface ProjectService {

	public Project saveProject(Project project) throws ValidationException;

	public Project getProject(long projectId) throws ProjectNotFoundException;

	public Iterable<Project> getProjects();

	public Project updateProject(Project project) throws ValidationException;

	public void deleteProject(long projectId) throws ProjectNotFoundException;
}
