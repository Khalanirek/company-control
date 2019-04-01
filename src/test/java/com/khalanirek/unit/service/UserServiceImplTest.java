package com.khalanirek.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.User;
import com.khalanirek.repository.impl.UserRepositoryImpl;
import com.khalanirek.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	UserRepositoryImpl userRepositoryImplMock;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	private User user;

	@BeforeEach
	void init() {
		user = new User();
		user.setUserId(1);
	}

	@Test
	void whenSaveUserThenSaveWithId0Test() {
		when(userRepositoryImplMock.getUser(user.getUserId())).thenReturn(user);
		when(userRepositoryImplMock.saveUser(any(User.class))).thenReturn(user.getUserId());
		userServiceImpl.saveUser(user);
		ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
		verify(userRepositoryImplMock).saveUser(argument.capture());
		assertEquals(0, argument.getValue().getUserId());
	}

	@Test
	void whenSaveUserThenReturnUserTest() {
		when(userRepositoryImplMock.getUser(user.getUserId())).thenReturn(user);
		when(userRepositoryImplMock.saveUser(any(User.class))).thenReturn(user.getUserId());
		assertEquals(user, userServiceImpl.saveUser(user));
	}

	@Test
	void whenGetUserXThenReturnUserX() {
		when(userRepositoryImplMock.getUser(user.getUserId())).thenReturn(user);
		assertEquals(user, userServiceImpl.getUser(user.getUserId()));
	}

	@Test
	void whenGetUsersThenReturnAllUsers() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User());
		usersList.add(new User());
		when(userRepositoryImplMock.getUsers()).thenReturn(usersList);
		assertEquals(usersList, userServiceImpl.getUsers());
	}

	@Test
	void whenUpdateNotExistingUserThenThrowIllegalArgumentException() {
		user.setUserId(0);
		assertThrows(IllegalArgumentException.class, () -> userServiceImpl.updateUser(null));
		assertThrows(IllegalArgumentException.class, () -> userServiceImpl.updateUser(user));
	}

	@Test
	void whenUpdateExistingUserThenSaveThisUserAndReturnThisUser() {
		when(userRepositoryImplMock.getUser(user.getUserId())).thenReturn(user);
		when(userRepositoryImplMock.saveUser(any(User.class))).thenReturn(user.getUserId());
		assertEquals(user, userServiceImpl.updateUser(user));
	}

	@Test
	void whenDeleteNotExistingUserThenReturnIllegalArgumentException() {
		assertThrows(IllegalArgumentException.class, () -> userServiceImpl.deleteUser(-1));
		assertThrows(IllegalArgumentException.class, () -> userServiceImpl.deleteUser(0));
	}

	@Test
	void whenDeleteExistingUserThenReturnDeletedUserId() {
		when(userRepositoryImplMock.deleteUser(user.getUserId())).thenReturn(user.getUserId());
		assertEquals(user.getUserId(), userServiceImpl.deleteUser(user.getUserId()));
	}
}
