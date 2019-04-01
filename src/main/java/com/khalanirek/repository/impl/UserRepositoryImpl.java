package com.khalanirek.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.khalanirek.entity.User;
import com.khalanirek.repository.UserRepository;

@Transactional
public class UserRepositoryImpl implements UserRepository {

	// Create session factory
	private SessionFactory sessionFactory;

	public UserRepositoryImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int saveUser(User user) {
		// Create session
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);
		return user.getUserId();
	}

	@Override
	public User getUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.get(User.class, userId);
		return user;
	}

	@Override
	public List<User> getUsers() {
		Session session = sessionFactory.getCurrentSession();
		return session
				.createQuery("from User")
				.getResultList();
	}

	@Override
	public int deleteUser(int userId) {
		Session session = sessionFactory.getCurrentSession();
		User user = getUser(userId);
		session.delete(user);
		return userId;
	}

}
