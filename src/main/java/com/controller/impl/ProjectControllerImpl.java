package com.controller.impl;

import java.util.List;

import com.controller.ProjectController;
import com.entity.Project;
import com.entity.ProjectComment;
import com.entity.ProjectPhase;
import com.entity.ProjectPhaseComment;
import com.entity.ProjectTask;
import com.entity.ProjectTaskComment;
import com.service.ProjectService;

public class ProjectControllerImpl implements ProjectController {

	private ProjectService projectService;

	public ProjectControllerImpl() {

	}

	public ProjectControllerImpl(ProjectService projectService) {
		this.projectService = projectService;
	}

	@Override
	public Project addProject(Project project) {
		return projectService.saveProject(project);
	}

	@Override
	public Project getProject(int projectId) {
		return projectService.getProject(projectId);
	}

	@Override
	public List<Project> getProjects() {
		return projectService.getProjects();
	}

	@Override
	public Project updateProject(Project project) {
		return projectService.saveProject(project);
	}

	@Override
	public int deleteProject(int projectId) {
		return projectService.deleteProject(projectId);
	}

	@Override
	public ProjectPhase addProjectPhase(ProjectPhase projectPhase) {
		return projectService.saveProjectPhase(projectPhase);
	}

	@Override
	public ProjectPhase getProjectPhase(int projectPhaseId) {
		return projectService.getProjectPhase(projectPhaseId);
	}

	@Override
	public List<ProjectPhase> getProjectPhases() {
		return projectService.getProjectPhases();
	}

	@Override
	public ProjectPhase updateProjectPhase(ProjectPhase projectPhase) {
		return projectService.saveProjectPhase(projectPhase);
	}

	@Override
	public int deleteProjectPhase(int projectPhaseId) {
		return projectService.deleteProjectPhase(projectPhaseId);
	}

	@Override
	public ProjectTask addProjectTask(ProjectTask projectTask) {
		return projectService.saveProjectTask(projectTask);
	}

	@Override
	public ProjectTask getProjectTask(int projectTaskId) {
		return projectService.getProjectTask(projectTaskId);
	}

	@Override
	public List<ProjectTask> getProjectTasks() {
		return projectService.getProjectTasks();
	}

	@Override
	public ProjectTask updateProjectTask(ProjectTask projectTask) {
		return projectService.saveProjectTask(projectTask);
	}

	@Override
	public int deleteProjectTask(int projectTaskId) {
		return projectService.deleteProjectPhase(projectTaskId);
	}

	@Override
	public ProjectComment addProjectComment(ProjectComment projectComment) {
		return projectService.saveProjectComment(projectComment);
	}

	@Override
	public ProjectComment getProjectComment(int projectCommentId) {
		return projectService.getProjectComment(projectCommentId);
	}


	@Override
	public List<ProjectComment> getProjectComments() {
		return projectService.getProjectComments();
	}

	@Override
	public ProjectComment updateProjectComment(ProjectComment projectComment) {
		return projectService.saveProjectComment(projectComment);
	}

	@Override
	public int deleteProjectComment(int projectCommentId) {
		return projectService.deleteProjectComment(projectCommentId);
	}

	@Override
	public ProjectPhaseComment addProjectPhaseComment(ProjectPhaseComment projectPhaseComment) {
		return projectService.saveProjectPhaseComment(projectPhaseComment);
	}

	@Override
	public ProjectPhaseComment getProjectPhaseComment(int projectPhaseCommentId) {
		return projectService.getProjectPhaseComment(projectPhaseCommentId);
	}

	@Override
	public List<ProjectPhaseComment> getProjectPhaseComments() {
		return projectService.getProjectPhaseComments();
	}

	@Override
	public ProjectPhaseComment updateProjectPhaseComment(ProjectPhaseComment projectPhaseComment) {
		return projectService.saveProjectPhaseComment(projectPhaseComment);
	}

	@Override
	public int deleteProjectPhaseComment(int projectPhaseCommentId) {
		return projectService.deleteProjectPhaseComment(projectPhaseCommentId);
	}

	@Override
	public ProjectTaskComment addProjectTaskComment(ProjectTaskComment projectTaskComment) {
		return projectService.saveProjectTaskComment(projectTaskComment);
	}

	@Override
	public ProjectTaskComment getProjectTaskComment(int projectTaskCommentId) {
		return projectService.getProjectTaskComment(projectTaskCommentId);
	}

	@Override
	public List<ProjectTaskComment> getProjectTaskComments() {
		return projectService.getProjectTaskComments();
	}

	@Override
	public ProjectTaskComment updateProjectTaskComment(ProjectTaskComment projectTaskComment) {
		return projectService.saveProjectTaskComment(projectTaskComment);
	}

	@Override
	public int deleteProjectTaskComment(int projectTaskCommentId) {
		return projectService.deleteProjectTaskComment(projectTaskCommentId);
	}
}
