package com.khalanirek.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.khalanirek.entity.User;
import com.khalanirek.exception.notfound.UserNotFoundException;
import com.khalanirek.exception.validation.ValidationException;

//@RestController
//@RequestMapping("/users")
public interface UserController {

	@PostMapping("/")
	public User addUser(@RequestBody User user) throws ValidationException;

	@GetMapping("/{userId}")
	public User getUser(@PathVariable("userId") long userId) throws UserNotFoundException;

	@GetMapping("/")
	public Iterable<User> getUsers();

	@PutMapping("/")
	public User updateUser(@RequestBody User user) throws ValidationException;

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable long userId) throws UserNotFoundException;
}
