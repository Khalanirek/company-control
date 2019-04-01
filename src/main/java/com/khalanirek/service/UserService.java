package com.khalanirek.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.khalanirek.entity.User;

@Transactional
public interface UserService {

	public User saveUser(User user);

	public User getUser(int userId);

	public List<User> getUsers();

	public User updateUser(User user);

	public int deleteUser(int userId);
}
