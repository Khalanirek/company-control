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
@Table(name="project_task")
public class ProjectTask {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="project_task_id")
	private long projectTaskId;

	@Column(name="tittle")
	private String tittle;

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="project_id")
	private Project project;

	@ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="phase_id", referencedColumnName="project_phase_id")
	private ProjectPhase projectPhase;

	@Column(name="owner_id")
	private long ownerId;

	@Column(name="creator_id")
	private long creatorId;

	@Column(name="description")
	private String description;

	@Column(name="start_time")
	private Timestamp startTime;

	@Column(name="end_time")
	private Timestamp endTime;

	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="task_id")
	@JsonIgnore
	private List<Comment> comments;
}
