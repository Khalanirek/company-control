package com.khalanirek.controller.impl;

import java.util.List;

import com.khalanirek.controller.UserController;
import com.khalanirek.entity.User;
import com.khalanirek.service.UserService;

public class UserControllerImpl implements UserController {

	private UserService userService;

	public UserControllerImpl (UserService userService) {
		this.userService = userService;
	}

	@Override
	public User addUser(User user) {;
		return userService.saveUser(user);
	}

	@Override
	public User getUser(int userId) {
		return userService.getUser(userId);
	}

	@Override
	public List<User> getUsers() {
		return userService.getUsers();
	}

	@Override
	public User updateUser(User user) {
		return userService.updateUser(user);
	}

	@Override
	public int deleteUser(int userId) {
		return userService.deleteUser(userId);
	}

}
