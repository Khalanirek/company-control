package com.khalanirek.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.exception.notfound.PhaseNotFoundException;
import com.khalanirek.exception.notfound.ProjectNotFoundException;
import com.khalanirek.exception.notfound.TaskNotFoundException;
import com.khalanirek.exception.validation.ValidationException;

@RestController
@RequestMapping("/projects")
public interface ProjectController {

	// Project
	@PostMapping("/")
	public Project addProject(@RequestBody Project project) throws ValidationException;

	@GetMapping("/{projectId}")
	public Project getProject(@PathVariable long projectId) throws ProjectNotFoundException;

	@GetMapping("/")
	public Iterable<Project> getProjects();

	@PutMapping("/")
	public Project updateProject(@RequestBody Project project) throws ValidationException;

	@DeleteMapping("/{projectId}")
	public void deleteProject(@PathVariable long projectId) throws ProjectNotFoundException;

	// ProjectPhase
	@PostMapping("/phases")
	public ProjectPhase addProjectPhase(@RequestBody ProjectPhase projectPhase) throws ValidationException;

	@GetMapping("/phases/{projectPhaseId}")
	public ProjectPhase getProjectPhase(@PathVariable long projectPhaseId) throws PhaseNotFoundException;

	@GetMapping("/phases")
	public Iterable<ProjectPhase> getProjectPhases();

	@PutMapping("/phases")
	public ProjectPhase updateProjectPhase(@RequestBody ProjectPhase projectPhase) throws ValidationException;

	@DeleteMapping("/phases/{projectPhaseId}")
	public void deleteProjectPhase(@PathVariable long projectPhaseId) throws PhaseNotFoundException;

	// ProjectTask
	@PostMapping("/tasks")
	public ProjectTask addProjectTask(@RequestBody ProjectTask projectTask) throws ValidationException;

	@GetMapping("/tasks/{projectTaskId}")
	public ProjectTask getProjectTask(@PathVariable long projectTaskId) throws TaskNotFoundException;

	@GetMapping("/tasks")
	public Iterable<ProjectTask> getProjectTasks();

	@PutMapping("/tasks")
	public ProjectTask updateProjectTask(@RequestBody ProjectTask projectTask) throws ValidationException;

	@DeleteMapping("/tasks/{projectTaskId}")
	public void deleteProjectTask(@PathVariable long projectTaskId) throws TaskNotFoundException;
}
