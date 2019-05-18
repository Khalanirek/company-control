package com.khalanirek.service;

import org.springframework.stereotype.Service;

import com.khalanirek.entity.Comment;
import com.khalanirek.exception.validation.ValidationException;

@Service
public interface CommentService {

	public Comment saveComment(Comment comment) throws ValidationException;

	public Comment getComment(long commentId);

	public Iterable<Comment> getComments();

	public Comment updateComment(Comment projectComment) throws ValidationException;

	public void deleteComment(long commentId);
}
