package com.khalanirek.service;

import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.exception.notfound.PhaseNotFoundException;
import com.khalanirek.exception.validation.ValidationException;

public interface ProjectPhaseService {

	public ProjectPhase saveProjectPhase(ProjectPhase projectPhase) throws ValidationException;

	public ProjectPhase getProjectPhase(long projectPhaseId) throws PhaseNotFoundException;

	public Iterable<ProjectPhase> getProjectPhases();

	public ProjectPhase updateProjectPhase(ProjectPhase projectPhase) throws ValidationException;

	public void deleteProjectPhase(long projectPhaseId) throws PhaseNotFoundException;

}
