package com.khalanirek.service;

import java.util.List;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectComment;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectPhaseComment;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.entity.ProjectTaskComment;

public interface ProjectService {

	public Project saveProject(Project project);

	public Project getProject(int projectId);

	public List<Project> getProjects();

	public Project updateProject(Project project);

	public int deleteProject(int projectId);

	public ProjectPhase saveProjectPhase(ProjectPhase projectPhase);

	public ProjectPhase getProjectPhase(int projectPhaseId);

	public List<ProjectPhase> getProjectPhases();

	public ProjectPhase updateProjectPhase(ProjectPhase projectPhase);

	public int deleteProjectPhase(int projectPhaseId);

	public ProjectTask saveProjectTask(ProjectTask projectTask);

	public ProjectTask getProjectTask(int projectTaskId);

	public List<ProjectTask> getProjectTasks();

	public ProjectTask updateProjectTask(ProjectTask projectTask);

	public int deleteProjectTask(int projectTaskId);

	public ProjectComment saveProjectComment(ProjectComment projectComment);

	public ProjectComment getProjectComment(int projectCommentId);

	public List<ProjectComment> getProjectComments();

	public ProjectComment updateProjectComment(ProjectComment projectComment);

	public int deleteProjectComment(int projectCommentId);

	public ProjectPhaseComment saveProjectPhaseComment(ProjectPhaseComment projectPhaseComment);

	public ProjectPhaseComment getProjectPhaseComment(int projectPhaseCommentId);

	public List<ProjectPhaseComment> getProjectPhaseComments();

	public ProjectPhaseComment updateProjectPhaseComment(ProjectPhaseComment projectPhaseComment);

	public int deleteProjectPhaseComment(int projectPhaseCommentId);

	public ProjectTaskComment saveProjectTaskComment(ProjectTaskComment projectTaskComment);

	public ProjectTaskComment getProjectTaskComment(int projectTaskCommentId);

	public List<ProjectTaskComment> getProjectTaskComments();

	public ProjectTaskComment updateProjectTaskComment(ProjectTaskComment projectTaskComment);

	public int deleteProjectTaskComment(int projectTaskCommentId);


}
