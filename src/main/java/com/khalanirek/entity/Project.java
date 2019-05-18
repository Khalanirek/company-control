package com.khalanirek.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
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

import lombok.Data;

@Data
@Entity
@Table(name="project")
public class Project {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_id")
	private long projectId;

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

	@OneToMany(mappedBy="project", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private List<ProjectPhase> phases;

	@OneToMany(mappedBy="project", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnore
	private List<ProjectTask> tasks;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="project_id")
	@JsonIgnore
	private List<Comment> comments;
}
