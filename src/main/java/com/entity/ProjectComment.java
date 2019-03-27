package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.entity.abst.CommentAbstract;

@Entity
@Table(name="project_comment")
@AttributeOverride(name="id", column=@Column(name="project_comment_id"))
public class ProjectComment extends CommentAbstract {

	@Column(name="project_id")
	private int projectId;

	public ProjectComment() {

	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
}
