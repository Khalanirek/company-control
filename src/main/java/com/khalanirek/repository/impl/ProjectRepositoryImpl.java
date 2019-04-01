package com.khalanirek.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectComment;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectPhaseComment;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.entity.ProjectTaskComment;
import com.khalanirek.repository.ProjectRepository;

public class ProjectRepositoryImpl implements ProjectRepository {

	private SessionFactory sessionFactory;

	public ProjectRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int saveProject(Project project) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(project);
		return project.getProjectId();
	}

	@Override
	public Project getProject(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Project project = session.get(Project.class, projectId);
		return project;
	}

	@Override
	public List<Project> getProjects() {
		return new ArrayList<Project>();
	}

	@Override
	public int deleteProject(int projectId) {
		Session session = sessionFactory.getCurrentSession();
		Project project = getProject(projectId);
		session.delete(project);
		return projectId;
	}

	@Override
	public int saveProjectPhase(ProjectPhase projectPhase) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(projectPhase);
		return projectPhase.getProjectId();
	}

	@Override
	public ProjectPhase getProjectPhase(int projectPhaseId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ProjectPhase.class, projectPhaseId);
	}

	@Override
	public List<ProjectPhase> getProjectPhases() {
		return new ArrayList<ProjectPhase>();
	}


	@Override
	public int deleteProjectPhase(int projectPhaseId) {
		Session session = sessionFactory.getCurrentSession();
		ProjectPhase projectPhase = session.get(ProjectPhase.class, projectPhaseId);
		session.delete(projectPhase);
		return projectPhaseId;
	}

	@Override
	public int saveProjectTask(ProjectTask projectTask) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(projectTask);
		return projectTask.getId();
	}

	@Override
	public ProjectTask getProjectTask(int projectTaskId) {
		Session session = sessionFactory.getCurrentSession();
		ProjectTask projectTask = session.get(ProjectTask.class, projectTaskId);
		return projectTask;
	}

	@Override
	public List<ProjectTask> getProjectTasks() {
		return new ArrayList<ProjectTask>();
	}

	@Override
	public int deleteProjectTask(int projectTaskId) {
		Session session = sessionFactory.getCurrentSession();
		ProjectTask projectTask = getProjectTask(projectTaskId);
		session.delete(projectTask);
		return projectTaskId;
	}

	@Override
	public int saveProjectComment(ProjectComment projectComment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(projectComment);
		return projectComment.getId();
	}

	@Override
	public ProjectComment getProjectComment(int projectCommentId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ProjectComment.class, projectCommentId);
	}

	@Override
	public List<ProjectComment> getProjectComments() {
		Session session = sessionFactory.getCurrentSession();
		List<ProjectComment> comments = session
				.createQuery("from ProjectComment pc where pc.project_id=2")
				.getResultList();
		return comments;
	}

	@Override
	public int deleteProjectComment(int projectCommentId) {
		Session session = sessionFactory.getCurrentSession();
		ProjectComment project = getProjectComment(projectCommentId);
		session.delete(project);
		return projectCommentId;
	}

	@Override
	public int saveProjectPhaseComment(ProjectPhaseComment projectPhaseComment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(projectPhaseComment);
		return projectPhaseComment.getId();
	}

	@Override
	public ProjectPhaseComment getProjectPhaseComment(int projectPhaseCommentId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ProjectPhaseComment.class, projectPhaseCommentId);
	}

	@Override
	public List<ProjectPhaseComment> getProjectPhaseComments() {
		return new ArrayList<ProjectPhaseComment>();
	}

	@Override
	public int deleteProjectPhaseComment(int projectPhaseCommentId) {
		Session session = sessionFactory.getCurrentSession();
		ProjectPhaseComment projectPhaseComment = getProjectPhaseComment(projectPhaseCommentId);
		session.delete(projectPhaseComment);
		return projectPhaseCommentId;
	}

	@Override
	public int saveProjectTaskComment(ProjectTaskComment projectTaskComment) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(projectTaskComment);
		return projectTaskComment.getId();
	}

	@Override
	public ProjectTaskComment getProjectTaskComment(int projectTaskCommentId) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(ProjectTaskComment.class, projectTaskCommentId);
	}

	@Override
	public List<ProjectTaskComment> getProjectTaskComments() {
		return new ArrayList<ProjectTaskComment>();
	}

	@Override
	public int deleteProjectTaskComment(int projectTaskCommentId) {
		Session session = sessionFactory.getCurrentSession();
		ProjectTaskComment projectTaskComment = getProjectTaskComment(projectTaskCommentId);
		session.delete(projectTaskComment);
		return projectTaskCommentId;
	}
}
