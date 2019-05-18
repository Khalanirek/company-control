package com.khalanirek.service.validation;

import java.util.ArrayList;
import java.util.List;

import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.exception.validation.ValidationException;

public class PhasePersistenceValidator implements Validator<ProjectPhase> {

	private List<String> errors = new ArrayList<>();

	@Override
	public void validate(ProjectPhase phase) throws ValidationException {
		if (phase.getProjectPhaseId() <= 0) {
			errors.add("Wrong projectPhaseId: " + phase.getProjectPhaseId());
		}
		if (phase.getProject() == null) {
			errors.add("Project is not set");
		}
		if (phase.getName().isEmpty()) {
			errors.add("PhaseName is empty");
		}
		if (phase.getStartTime() == null) {
			errors.add("Phase startTime is not set");
		}
		if (phase.getEndTime() == null) {
			errors.add("Phase endTime is not set");
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
