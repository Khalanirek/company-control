package com.khalanirek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.exception.notfound.PhaseNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.ProjectPhaseRepository;
import com.khalanirek.service.ProjectPhaseService;
import com.khalanirek.service.validation.PhasePersistenceValidator;

public class ProjectPhaseServiceImpl implements ProjectPhaseService {

	@Autowired private ProjectPhaseRepository projectPhaseRepository;
	@Autowired private PhasePersistenceValidator phasePersistanceValidator;

	public ProjectPhaseServiceImpl() {

	}

	public ProjectPhaseServiceImpl(ProjectPhaseRepository projectPhaseRepository, PhasePersistenceValidator phasePersistanceValidator) {
		this.projectPhaseRepository = projectPhaseRepository;
		this.phasePersistanceValidator = phasePersistanceValidator;
	}

	@Override
	public ProjectPhase saveProjectPhase(ProjectPhase projectPhase) throws ValidationException {
		projectPhase.setProjectPhaseId(0);
		phasePersistanceValidator.validate(projectPhase);
		return projectPhaseRepository.save(projectPhase);

	}

	@Override
	public ProjectPhase getProjectPhase(long projectPhaseId) throws PhaseNotFoundException {
		return projectPhaseRepository.findById(projectPhaseId).orElseThrow(() -> new PhaseNotFoundException(projectPhaseId));
	}

	@Override
	public Iterable<ProjectPhase> getProjectPhases() {
		return projectPhaseRepository.findAll();
	}

	@Override
	public ProjectPhase updateProjectPhase(ProjectPhase projectPhase) throws ValidationException {
		if (projectPhase.getProjectPhaseId() == 0) {
			throw new ValidationException("PhaseId = 0 during update");
		}
		phasePersistanceValidator.validate(projectPhase);
		return projectPhaseRepository.save(projectPhase);
	}

	@Override
	public void deleteProjectPhase(long projectPhaseId) throws PhaseNotFoundException {
		ProjectPhase projectPhase = this.getProjectPhase(projectPhaseId);
		projectPhaseRepository.delete(projectPhase);
	}

}
