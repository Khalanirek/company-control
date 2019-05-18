package com.khalanirek.exception.notfound;

public class ProjectNotFoundException extends Exception {
	public ProjectNotFoundException(long projectId) {
		super("Project with Id: " + projectId + " not found");
	}
}
