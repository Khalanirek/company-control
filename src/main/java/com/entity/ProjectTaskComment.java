package com.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.entity.abst.CommentAbstract;

@Entity
@Table(name="project_task_comment")
@AttributeOverride(name="id", column=@Column(name="project_task_comment_id"))
public class ProjectTaskComment extends CommentAbstract {

	@Column(name="task_id")
	private int taskId;

	public ProjectTaskComment() {
		
	}
	
	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
}
