package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.entity.abst.CommentAbstract;

@Entity
@Table(name="project_pahse_comment")
@AttributeOverride(name="id", column=@Column(name="phase_comment_id"))
public class ProjectPhaseComment extends CommentAbstract {

	@Column(name="project_phase_id")
	private int projectPhaseId;

	public ProjectPhaseComment() {

	}

	public int getProjectPhaseId() {
		return projectPhaseId;
	}

	public void setProjectPhaseId(int projectPhaseId) {
		this.projectPhaseId = projectPhaseId;
	}
}
