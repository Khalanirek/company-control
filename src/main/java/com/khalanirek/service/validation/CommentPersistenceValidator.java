package com.khalanirek.service.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.khalanirek.entity.Comment;
import com.khalanirek.exception.validation.ValidationException;

@Component
public class CommentPersistenceValidator implements Validator<Comment> {

	private List<String> errors = new ArrayList<>();

	@Override
	public void validate(Comment comment) throws ValidationException {
		if (comment.getCommentId() < 0) {
			errors.add("CommentId is wrong: " + comment.getCommentId());
		}
		if (comment.getCommentType().isEmpty()) {
			errors.add("CommentType is empty");
		}
		if (comment.getCommentTime() == null) {
			errors.add("CommentTime is not set");
		}
		if (comment.getCommentText().isEmpty()) {
			errors.add("CommentText is empty");
		}
		if (comment.getProject() == null) {
			errors.add("Project is not set");
		}
		if (!errors.isEmpty()) {
			StringBuilder errorsString = new StringBuilder();
			for(String error : errors){
				errorsString.append(error + "\n");
			}
			throw new ValidationException(errorsString.toString());
		}
	}

}
