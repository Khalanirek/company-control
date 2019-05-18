package com.khalanirek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khalanirek.entity.ProjectPhase;

@Repository
public interface ProjectPhaseRepository extends CrudRepository<ProjectPhase, Long> {
}
