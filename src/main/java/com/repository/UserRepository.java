package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import com.entity.User;

@Transactional
public interface UserRepository {

	public int saveUser(User user);

	public User getUser(int userId);

	public List<User> getUsers();

	public int deleteUser(int userId);
}
