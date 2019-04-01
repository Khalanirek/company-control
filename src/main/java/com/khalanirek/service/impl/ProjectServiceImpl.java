package com.khalanirek.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectComment;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectPhaseComment;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.entity.ProjectTaskComment;
import com.khalanirek.repository.ProjectRepository;
import com.khalanirek.service.ProjectService;

@Transactional
public class ProjectServiceImpl implements ProjectService {

	private ProjectRepository projectRepository;

	public ProjectServiceImpl() {

	}

	public ProjectServiceImpl(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public Project saveProject(Project project) {
		project.setProjectId(0);
		int projectId = projectRepository.saveProject(project);
		return projectRepository.getProject(projectId);
	}

	@Override
	public Project getProject(int projectId) {
		return projectRepository.getProject(projectId);
	}

	@Override
	public List<Project> getProjects() {
		return projectRepository.getProjects();
	}

	@Override
	public Project updateProject(Project project) {
		if (project == null || project.getProjectId() == 0) {
			throw new IllegalArgumentException("Project is null or try to update project with id = 0");
		}
		int projectId = projectRepository.saveProject(project);
		return projectRepository.getProject(projectId);
	}

	@Override
	public int deleteProject(int projectId) {
		return projectRepository.deleteProject(projectId);
	}

	@Override
	public ProjectPhase saveProjectPhase(ProjectPhase projectPhase) {
		int projectPhaseId = projectRepository.saveProjectPhase(projectPhase);
		return projectRepository.getProjectPhase(projectPhaseId);
	}

	@Override
	public ProjectPhase getProjectPhase(int projectPhaseId) {
		return projectRepository.getProjectPhase(projectPhaseId);
	}

	@Override
	public List<ProjectPhase> getProjectPhases() {
		return projectRepository.getProjectPhases();
	}

	@Override
	public ProjectPhase updateProjectPhase(ProjectPhase projectPhase) {
		if (projectPhase == null || projectPhase.getProjectId() == 0) {
			throw new IllegalArgumentException("ProjectPhase is null or try to update project phase with id = 0");
		}
		int projectPhaseId = projectRepository.saveProjectPhase(projectPhase);
		return projectRepository.getProjectPhase(projectPhaseId);
	}

	@Override
	public int deleteProjectPhase(int projectPhaseId) {
		return projectRepository.deleteProjectPhase(projectPhaseId);
	}

	@Override
	public ProjectTask saveProjectTask(ProjectTask projectTask) {
		projectTask.setId(0);;
		int projectTaskId = projectRepository.saveProjectTask(projectTask);
		return projectRepository.getProjectTask(projectTaskId);
	}

	@Override
	public ProjectTask getProjectTask(int id) {
		return projectRepository.getProjectTask(id);
	}

	@Override
	public List<ProjectTask> getProjectTasks() {
		return projectRepository.getProjectTasks();
	}

	@Override
	public ProjectTask updateProjectTask(ProjectTask projectTask) {
		if (projectTask == null || projectTask.getId() == 0) {
			throw new IllegalArgumentException("ProjectTask is null or try to update projectTask with id = 0");
		}
		int projectTaskId = projectRepository.saveProjectTask(projectTask);
		return projectRepository.getProjectTask(projectTaskId);
	}

	@Override
	public int deleteProjectTask(int id) {
		return projectRepository.deleteProjectTask(id);
	}

	@Override
	public ProjectComment saveProjectComment(ProjectComment projectComment) {
		projectComment.setId(0);
		int projectCommentId = projectRepository.saveProjectComment(projectComment);
		return projectRepository.getProjectComment(projectCommentId);
	}

	@Override
	public ProjectComment getProjectComment(int projectCommentId) {
		return projectRepository.getProjectComment(projectCommentId);
	}

	@Override
	public List<ProjectComment> getProjectComments() {
		return projectRepository.getProjectComments();
	}

	@Override
	public ProjectComment updateProjectComment(ProjectComment projectComment) {
		if (projectComment == null || projectComment.getId() == 0) {
			throw new IllegalArgumentException("ProjectComment is null or try to update project comment with id = 0");
		}
		int projectCommentId = projectRepository.saveProjectComment(projectComment);
		return projectRepository.getProjectComment(projectCommentId);
	}

	@Override
	public int deleteProjectComment(int projectCommentId) {
		return projectRepository.deleteProjectComment(projectCommentId);
	}

	@Override
	public ProjectPhaseComment saveProjectPhaseComment(ProjectPhaseComment projectPhaseComment) {
		projectPhaseComment.setId(0);
		int projectPhaseCommentId = projectRepository.saveProjectPhaseComment(projectPhaseComment);
		return projectRepository.getProjectPhaseComment(projectPhaseCommentId);
	}

	@Override
	public ProjectPhaseComment getProjectPhaseComment(int projectPhaseCommentId) {
		return projectRepository.getProjectPhaseComment(projectPhaseCommentId);
	}

	@Override
	public List<ProjectPhaseComment> getProjectPhaseComments() {
		return projectRepository.getProjectPhaseComments();
	}

	@Override
	public ProjectPhaseComment updateProjectPhaseComment(ProjectPhaseComment projectPhaseComment) {
		if (projectPhaseComment == null || projectPhaseComment.getId() == 0) {
			throw new IllegalArgumentException("ProjectPhaseComment is null or try to update project phase comment with id = 0");
		}
		int projectPhaseCommentId = projectRepository.saveProjectPhaseComment(projectPhaseComment);
		return projectRepository.getProjectPhaseComment(projectPhaseCommentId);
	}

	@Override
	public int deleteProjectPhaseComment(int projectPhaseCommentId) {
		return projectRepository.deleteProjectPhaseComment(projectPhaseCommentId);
	}

	@Override
	public ProjectTaskComment saveProjectTaskComment(ProjectTaskComment projectTaskComment) {
		projectTaskComment.setId(0);
		int projectTaskCommentId = projectRepository.saveProjectTaskComment(projectTaskComment);
		return projectRepository.getProjectTaskComment(projectTaskCommentId);
	}

	@Override
	public ProjectTaskComment getProjectTaskComment(int projectTaskCommentId) {
		return projectRepository.getProjectTaskComment(projectTaskCommentId);
	}

	@Override
	public List<ProjectTaskComment> getProjectTaskComments() {
		return projectRepository.getProjectTaskComments();
	}

	@Override
	public ProjectTaskComment updateProjectTaskComment(ProjectTaskComment projectTaskComment) {
		if (projectTaskComment == null || projectTaskComment.getId() == 0) {
			throw new IllegalArgumentException("ProjectTaskComment is null or try to update project task comment with id = 0");
		}
		int projectTaskCommentId = projectRepository.saveProjectTaskComment(projectTaskComment);
		return projectRepository.getProjectTaskComment(projectTaskCommentId);
	}

	@Override
	public int deleteProjectTaskComment(int projectTaskCommentId) {
		return projectRepository.deleteProjectTaskComment(projectTaskCommentId);
	}
}
