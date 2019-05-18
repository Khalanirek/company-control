package com.khalanirek.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khalanirek.entity.User;
import com.khalanirek.exception.notfound.UserNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.UserRepository;
import com.khalanirek.service.UserService;
import com.khalanirek.service.validation.UserPersistenceValidator;

@Service
public class UserServiceImpl implements UserService {

	@Autowired private UserRepository userRepository;
	@Autowired private UserPersistenceValidator userPersistenceValidator;

	public UserServiceImpl(){

	}
	public UserServiceImpl(UserRepository userRepository, UserPersistenceValidator userPersistenceValidator) {
		this.userRepository = userRepository;
		this.userPersistenceValidator = userPersistenceValidator;
	}
	@Override
	public User saveUser(User user) throws ValidationException {
		user.setUserId(0);
		userPersistenceValidator.validate(user);
		return userRepository.save(user);
	}

	@Override
	public User getUser(long userId) throws UserNotFoundException {
		return userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException(userId));
	}

	@Override
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) throws ValidationException {
		if (user.getUserId() == 0) {
			throw new ValidationException("UserId = 0 during update");
		}
		userPersistenceValidator.validate(user);
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(long userId) throws UserNotFoundException {
		User user = this.getUser(userId);
		userRepository.delete(user);
	}

}
