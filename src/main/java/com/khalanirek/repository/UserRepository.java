package com.khalanirek.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.khalanirek.entity.User;

@Transactional
public interface UserRepository {

	public int saveUser(User user);

	public User getUser(int userId);

	public List<User> getUsers();

	public int deleteUser(int userId);
}
