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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="project_phase")
public class ProjectPhase {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_phase_id")
	private long projectPhaseId;

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="project_id")
	private Project project;

	@Column(name="name")
	private String name;

	@Column(name="description")
	private String description;

	@Column(name="start_time")
	private Timestamp startTime;

	@Column(name="end_time")
	private Timestamp endTime;

	@JsonIgnore
	@OneToMany(mappedBy="projectPhase", fetch=FetchType.LAZY, cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private List<ProjectTask> tasks;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="phase_id")
	@JsonIgnore
	private List<Comment> comments;
}
