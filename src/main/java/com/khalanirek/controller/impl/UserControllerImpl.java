package com.khalanirek.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khalanirek.controller.UserController;
import com.khalanirek.entity.User;
import com.khalanirek.exception.notfound.UserNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.service.UserService;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

	@Autowired private UserService userService;

	public UserControllerImpl() {

	}
	public UserControllerImpl (UserService userService) {
		this.userService = userService;
	}

	@Override
	public User addUser(User user) throws ValidationException {;
		return userService.saveUser(user);
	}

	@Override
	public User getUser(long userId) throws UserNotFoundException {
		return userService.getUser(userId);
	}

	@Override
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}

	@Override
	public User updateUser(User user) throws ValidationException {
		return userService.updateUser(user);
	}

	@Override
	public void deleteUser(long userId) throws UserNotFoundException {
		userService.deleteUser(userId);
	}

}
