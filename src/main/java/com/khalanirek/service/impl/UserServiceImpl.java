package com.khalanirek.service.impl;

import java.util.List;

import com.khalanirek.entity.User;
import com.khalanirek.repository.UserRepository;
import com.khalanirek.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(){

	}
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public User saveUser(User user) {
		user.setUserId(0);
		int userId = userRepository.saveUser(user);
		return userRepository.getUser(userId);
	}

	@Override
	public User getUser(int userId) {
		return userRepository.getUser(userId);
	}

	@Override
	public List<User> getUsers() {
		return userRepository.getUsers();
	}

	@Override
	public User updateUser(User user) {
		if (user == null || user.getUserId() == 0) {
			throw new IllegalArgumentException("User is null or trying to update project with id = 0");
		}
		int userId = userRepository.saveUser(user);
		return userRepository.getUser(userId);
	}

	@Override
	public int deleteUser(int userId) {
		if (userId <= 0) {
			throw new IllegalArgumentException("UserId <= 0");
		}
		return userRepository.deleteUser(userId);
	}

}
