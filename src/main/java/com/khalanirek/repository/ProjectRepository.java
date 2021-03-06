package com.khalanirek.repository;

import java.util.List;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectComment;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectPhaseComment;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.entity.ProjectTaskComment;

public interface ProjectRepository {

	public int saveProject(Project project);

	public Project getProject(int projectId);

	public List<Project> getProjects();

	public int deleteProject(int projectId);

	public int saveProjectPhase(ProjectPhase projectPhase);

	public ProjectPhase getProjectPhase(int projectPhaseId);

	public List<ProjectPhase> getProjectPhases();

	public int deleteProjectPhase(int projectPhaseId);

	public int saveProjectTask(ProjectTask projectTask);

	public ProjectTask getProjectTask(int projectTaskId);

	public List<ProjectTask> getProjectTasks();

	public int deleteProjectTask(int projectTaskId);

	public int saveProjectComment(ProjectComment projectComment);

	public ProjectComment getProjectComment(int projectCommentId);

	public List<ProjectComment> getProjectComments();

	public int deleteProjectComment(int projectCommentId);

	public int saveProjectPhaseComment(ProjectPhaseComment projectPhaseComment);

	public ProjectPhaseComment getProjectPhaseComment(int projectPhaseCommentId);

	public List<ProjectPhaseComment> getProjectPhaseComments();

	public int deleteProjectPhaseComment(int projectPhaseCommentId);

	public int saveProjectTaskComment(ProjectTaskComment projectTaskComment);

	public ProjectTaskComment getProjectTaskComment(int projectTaskCommentId);

	public List<ProjectTaskComment> getProjectTaskComments();

	public int deleteProjectTaskComment(int projectTaskCommentId);


}
