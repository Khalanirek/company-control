package com.khalanirek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khalanirek.entity.Project;
import com.khalanirek.exception.notfound.ProjectNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.ProjectRepository;
import com.khalanirek.service.ProjectService;
import com.khalanirek.service.validation.ProjectPersistenceValidator;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired private ProjectRepository projectRepository;
	@Autowired private ProjectPersistenceValidator projectPersistenceValidator;

	public ProjectServiceImpl() {

	}

	public ProjectServiceImpl(ProjectRepository projectRepository, ProjectPersistenceValidator projectPersistenceValidator) {
		this.projectRepository = projectRepository;
		this.projectPersistenceValidator = projectPersistenceValidator;
	}

	@Override
	public Project saveProject(Project project) throws ValidationException {
		project.setProjectId(0);
		projectPersistenceValidator.validate(project);
		return projectRepository.save(project);
	}

	@Override
	public Project getProject(long projectId) throws ProjectNotFoundException {
		return projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException(projectId));
	}

	@Override
	public Iterable<Project> getProjects() {
		return projectRepository.findAll();
	}

	@Override
	public Project updateProject(Project project) throws ValidationException {
		if (project.getProjectId() <= 0) {
			throw new ValidationException("ProjectId <= 0 during update");}
		projectPersistenceValidator.validate(project);
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(long projectId) throws ProjectNotFoundException {
		Project project = this.getProject(projectId);
		projectRepository.delete(project);
	}
}
