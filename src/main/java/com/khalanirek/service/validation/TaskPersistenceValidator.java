package com.khalanirek.service.validation;

import java.util.ArrayList;
import java.util.List;

import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.validation.ValidationException;

public class TaskPersistenceValidator implements Validator<ProjectTask> {

	private List<String> errors = new ArrayList<>();

	@Override
	public void validate(ProjectTask task) throws ValidationException {
		if (task.getProjectTaskId() < 0) {
			errors.add("Wrong taskId: " + task.getProjectTaskId());
		}
		if (task.getTittle().isEmpty()) {
			errors.add("TaskTitle is empty");
		}
		if (task.getProject() == null) {
			errors.add("Project is not set");
		}
		if (task.getOwnerId() <= 0) {
			errors.add("OwnerId is wrong: " + task.getOwnerId());
		}
		if (task.getCreatorId() <= 0) {
			errors.add("CreatorId is wrong: " + task.getCreatorId());
		}
		if (task.getStartTime() == null) {
			errors.add("StartTime is not set");
		}
		if (task.getEndTime() == null) {
			errors.add("EndTime is not set");
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
