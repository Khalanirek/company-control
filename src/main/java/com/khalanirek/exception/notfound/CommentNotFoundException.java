package com.khalanirek.exception.notfound;

public class CommentNotFoundException extends Exception {
	public CommentNotFoundException(long commentId) {
		super("Comment with Id: " + commentId + " not found");
	}
}
