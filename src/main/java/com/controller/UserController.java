package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;

@RestController
@RequestMapping("/users")
public interface UserController {

	@PostMapping("/")
	public User addUser(@RequestBody User user);

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") int userId);

	@GetMapping("/")
	public List<User> getUsers();

	@PutMapping("/")
	public User updateUser(@RequestBody User user);

	@DeleteMapping("/{userId}")
	public int deleteUser(@PathVariable int userId);
}
