package com.khalanirek.unit.service.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.sql.Timestamp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.Comment;
import com.khalanirek.entity.Project;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.validation.CommentPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class CommentPersistenceValidatorTest {

	private Comment comment = new Comment();

	@InjectMocks
	private CommentPersistenceValidator commentPersistenceValidator;

	@BeforeEach
	public void init() {
		comment.setCommentatorId(1);
		comment.setCommentType("TEST");
		comment.setCommentTime(new Timestamp(1));
		comment.setCommentText("TEST");
		comment.setProject(new Project());
	}

	@Test
	public void whenWrongCommentatorIdThenThrowValidationException() {
		comment.setCommentId(-1);
		assertThrows(ValidationException.class, () -> commentPersistenceValidator.validate(comment));
	}

	@Test
	public void whenEmptyCommentTypeThenThrowValidationException() {
		comment.setCommentType(null);
		assertThrows(ValidationException.class, () -> commentPersistenceValidator.validate(comment));
	}

	@Test
	public void whenEmptyCommentTimeThenThrowValidationException() {
		comment.setCommentTime(null);
		assertThrows(ValidationException.class, () -> commentPersistenceValidator.validate(comment));
	}

	@Test
	public void whenEmptyCommentTextThenThrowValidationException() {
		comment.setCommentText(null);
		assertThrows(ValidationException.class, () -> commentPersistenceValidator.validate(comment));
	}

	@Test
	public void whenEmptyProjectThenThrowValidationException() {
		comment.setProject(null);
		assertThrows(ValidationException.class, () -> commentPersistenceValidator.validate(comment));
	}
}
