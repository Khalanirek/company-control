package com.entity.abst;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

//@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@MappedSuperclass
public abstract class CommentAbstract {

	@Id
	@TableGenerator(name="comment_generator",
					schema="pro001",
					table="sequence",
					pkColumnName="sequance_name",
					pkColumnValue="comment_sequence",
					valueColumnName="allocated_id",
					allocationSize=1,
					catalog="pro001")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="comment_generator")
	private int id;

	@Column(name="commentator_id")
	private int commentatorId;

	@Column(name="comment")
	private String comment;

	@Column(name="comment_time")
	private Timestamp commentTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCommentatorId() {
		return commentatorId;
	}

	public void setCommentatorId(int commentatorId) {
		this.commentatorId = commentatorId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Timestamp commentTime) {
		this.commentTime = commentTime;
	}


}


