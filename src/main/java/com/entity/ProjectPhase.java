package com.entity;

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
@Table(name="project_phase")
public class ProjectPhase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_phase_id")
	private int projectPhaseId;

	@Column(name="project_id")
	private int projectId;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="start_time")
	private Timestamp startTime;

	@Column(name="end_time")
	private Timestamp endTime;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="phase_id")
	private List<ProjectTask> tasks;

	@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="phase_id")
	private List<ProjectPhaseComment> phaseComments;
	public ProjectPhase() {

	}

	public int getProjectPhaseId() {
		return projectPhaseId;
	}

	public void setProjectPhaseId(int projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getStartTime() {
		return startTime;
	}

	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public List<ProjectTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<ProjectTask> tasks) {
		this.tasks = tasks;
	}

	public List<ProjectPhaseComment> getPhaseComments() {
		return phaseComments;
	}

	public void setPhaseComments(List<ProjectPhaseComment> phaseComments) {
		this.phaseComments = phaseComments;
	}

	@Override
	public String toString() {
		return "ProjectPhase [projectPhaseId=" + projectPhaseId + ", projectId=" + projectId + ", name=" + name
				+ ", description=" + description + ", startTime=" + startTime + ", endTime=" + endTime + "]";
	}


}
