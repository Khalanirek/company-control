package com.khalanirek.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.khalanirek.entity.Project;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
}
