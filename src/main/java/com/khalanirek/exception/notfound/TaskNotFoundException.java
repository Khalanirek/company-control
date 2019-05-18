package com.khalanirek.exception.notfound;

public class TaskNotFoundException extends Exception {
	public TaskNotFoundException(long taskId) {
		super("Task with Id: " + taskId + " not found");
	}
}
