package com.khalanirek.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="project_task")
public class ProjectTask {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_task_id")
	private int id;

	@Column(name="tittle")
	private String tittle;

	@Column(name="project_id")
	private int projectId;

	@Column(name="phase_id")
	private int phaseId;

	@Column(name="owner_id")
	private int ownterId;

	@Column(name="creator_id")
	private int creatorId;

	@Column(name="description")
	private String description;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="endDate")
	private Timestamp endDate;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="task_id")
	private List<ProjectTaskComment> taskComments;

	public ProjectTask() {

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getPhaseId() {
		return phaseId;
	}

	public void setPhaseId(int phaseId) {
		this.phaseId = phaseId;
	}

	public int getOwnterId() {
		return ownterId;
	}

	public void setOwnterId(int ownterId) {
		this.ownterId = ownterId;
	}

	public int getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public List<ProjectTaskComment> getTaskComments() {
		return taskComments;
	}

	public void setTaskComments(List<ProjectTaskComment> taskComments) {
		this.taskComments = taskComments;
	}




}
