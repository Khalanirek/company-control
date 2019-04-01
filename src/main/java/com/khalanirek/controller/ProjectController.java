package com.khalanirek.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalanirek.entity.Project;
import com.khalanirek.entity.ProjectComment;
import com.khalanirek.entity.ProjectPhase;
import com.khalanirek.entity.ProjectPhaseComment;
import com.khalanirek.entity.ProjectTask;
import com.khalanirek.entity.ProjectTaskComment;

@RestController
@RequestMapping("/projects")
public interface ProjectController {

	// Project
	@PostMapping("/")
	public Project addProject(@RequestBody Project project);

	@GetMapping("/{projectId}")
	public Project getProject(@PathVariable int projectId);

	@GetMapping("/")
	public List<Project> getProjects();

	@PutMapping("/")
	public Project updateProject(@RequestBody Project project);

	@DeleteMapping("/{projectId}")
	public int deleteProject(@PathVariable int projectId);

	// ProjectPhase
	@PostMapping("/phases")
	public ProjectPhase addProjectPhase(@RequestBody ProjectPhase projectPhase);

	@GetMapping("/phases/{projectPhaseId}")
	public ProjectPhase getProjectPhase(@PathVariable int projectPhaseId);

	@GetMapping("/phases")
	public List<ProjectPhase> getProjectPhases();

	@PutMapping("/phases")
	public ProjectPhase updateProjectPhase(@RequestBody ProjectPhase projectPhase);

	@DeleteMapping("/phases/{projectPhaseId}")
	public int deleteProjectPhase(@PathVariable int projectPhaseId);

	// ProjectTask
	@PostMapping("/tasks")
	public ProjectTask addProjectTask(@RequestBody ProjectTask projectTask);

	@GetMapping("/tasks/{projectTaskId}")
	public ProjectTask getProjectTask(@PathVariable int projectTaskId);

	@GetMapping("/tasks")
	public List<ProjectTask> getProjectTasks();

	@PutMapping("/tasks")
	public ProjectTask updateProjectTask(@RequestBody ProjectTask projectTask);

	@DeleteMapping("/tasks/{projectTaskId}")
	public int deleteProjectTask(@PathVariable int projectTaskId);

	// ProjectComment
	@PostMapping("/comments")
	public ProjectComment addProjectComment(@RequestBody ProjectComment projectComment);

	@GetMapping("/comments/{projectCommentId}")
	public ProjectComment getProjectComment(@PathVariable int projectCommentId);

	@GetMapping("/comments/")
	public List<ProjectComment> getProjectComments();

	@PutMapping("/comments/")
	public ProjectComment updateProjectComment(@RequestBody ProjectComment projectComment);

	@DeleteMapping("/comments/{projectCommentId}")
	public int deleteProjectComment(@PathVariable int projectCommentId);

	// ProjectPhaseComment
	@PostMapping("/phases/comments")
	public ProjectPhaseComment addProjectPhaseComment(@RequestBody ProjectPhaseComment projectPhaseComment);

	@GetMapping("/phases/comments/{projectPhaseCommentId}")
	public ProjectPhaseComment getProjectPhaseComment(@PathVariable int projectPhaseCommentId);

	@GetMapping("/phases/comments/")
	public List<ProjectPhaseComment> getProjectPhaseComments();

	@PutMapping("/phases/comments/")
	public ProjectPhaseComment updateProjectPhaseComment(@RequestBody ProjectPhaseComment projectPhaseComment);

	@DeleteMapping("/phases/comments/{projectPhaseCommentId}")
	public int deleteProjectPhaseComment(@PathVariable int projectPhaseCommentId);

	// ProjectTaskComment
	@PostMapping("/tasks/comments")
	public ProjectTaskComment addProjectTaskComment(@RequestBody ProjectTaskComment projectTaskComment);

	@GetMapping("/tasks/comments/{projectTaskCommentId}")
	public ProjectTaskComment getProjectTaskComment(@PathVariable int projectTaskCommentId);

	@GetMapping("/tasks/comments/")
	public List<ProjectTaskComment> getProjectTaskComments();

	@PutMapping("/tasks/comments/")
	public ProjectTaskComment updateProjectTaskComment(@RequestBody ProjectTaskComment projectTaskComment);

	@DeleteMapping("/tasks/comments/{projectTaskCommentId}")
	public int deleteProjectTaskComment(@PathVariable int projectTaskCommentId);
}
