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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private int projectId;

	@Column(name="number")
	private int number;

	@Column(name="name")
	private String name;

	@OneToOne
	@JoinColumn(name="owner_id")
	private User owner;

	@OneToOne
	@JoinColumn(name="creator_id")
	private User creator;

	@Column(name="description")
	private String description;

	@Column(name="start_time")
	private Timestamp startTime;

	@Column(name="end_time")
	private Timestamp endTime;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="project_id")
	private List<ProjectPhase> phases;

	@OneToMany(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="project_id")
	private List<ProjectTask> tasks;

	@OneToMany(fetch=FetchType.LAZY)
	@JsonIgnore
	@JoinColumn(name="project_id")
	private List<ProjectComment> projectComments;

	public Project() {

	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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

	public List<ProjectPhase> getPhases() {
		return phases;
	}

	public void setPhases(List<ProjectPhase> phases) {
		this.phases = phases;
	}

	public List<ProjectTask> getTasks() {
		return tasks;
	}

	public void setTasks(List<ProjectTask> tasks) {
		this.tasks = tasks;
	}

	public List<ProjectComment> getComments() {
		return projectComments;
	}

	public void setComments(List<ProjectComment> comments) {
		this.projectComments = comments;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", number=" + number + ", name=" + name + ", owner=" + owner
				+ ", creator=" + creator + ", description=" + description + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}


}
