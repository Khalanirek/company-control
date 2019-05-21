package com.khalanirek.service.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.khalanirek.entity.Project;
import com.khalanirek.exception.validation.ValidationException;

@Component
public class ProjectPersistenceValidator implements Validator<Project> {

	private List<String> errors = new ArrayList<>();

	@Override
	public void validate(Project project) throws ValidationException {
		if (project.getProjectId() < 0) {
			errors.add("Project id is wrong: " + project.getProjectId());
		}
		if (project.getNumber() <= 0) {
			errors.add("Project number is wrong: " + project.getNumber());
		}
		if (project.getName() == null || project.getName().isEmpty()) {
			errors.add("Project name is empty");
		}
		if (project.getOwner() == null) {
			errors.add("Project owner is not set");
		}
		if (project.getCreator() == null) {
			errors.add("Project creator is not set");
		}
		if (project.getStartTime() == null) {
			errors.add("Project startTime is not set");
		}
		if (project.getEndTime() == null) {
			errors.add("Project endTime is not set");
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
