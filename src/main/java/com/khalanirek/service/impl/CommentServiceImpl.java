package com.khalanirek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khalanirek.entity.Comment;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.CommentRepository;
import com.khalanirek.service.CommentService;
import com.khalanirek.service.validation.CommentPersistenceValidator;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired private CommentRepository commentRepository;
	@Autowired private CommentPersistenceValidator commentPersistenceValidator;
	@Override
	public Comment saveComment(Comment comment) throws ValidationException {
		comment.setCommentId(0);
		commentPersistenceValidator.validate(comment);
		return commentRepository.save(comment);
	}

	@Override
	public Comment getComment(long commentId) {
		return commentRepository.findById(commentId).orElse(null);
	}

	@Override
	public Iterable<Comment> getComments() {
		return commentRepository.findAll();
	}

	@Override
	public Comment updateComment(Comment comment) throws ValidationException {
		if (comment.getCommentId() == 0) {
			throw new ValidationException("CommentId = 0 during update");
		}
		return commentRepository.save(comment);
	}

	@Override
	public void deleteComment(long commentId) {
		Comment comment = this.getComment(commentId);
		commentRepository.delete(comment);
	}
}
