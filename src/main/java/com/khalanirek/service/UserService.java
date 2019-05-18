package com.khalanirek.service;

import org.springframework.stereotype.Service;

import com.khalanirek.entity.User;
import com.khalanirek.exception.notfound.UserNotFoundException;
import com.khalanirek.exception.validation.ValidationException;

@Service
public interface UserService {

	public User saveUser(User user) throws ValidationException;

	public User getUser(long userId) throws UserNotFoundException;

	public Iterable<User> getUsers();

	public User updateUser(User user) throws ValidationException;

	public void deleteUser(long userId) throws UserNotFoundException;
}
