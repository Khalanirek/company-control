package com.khalanirek.unit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.controller.impl.UserControllerImpl;
import com.khalanirek.entity.User;
import com.khalanirek.service.impl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
class UserControllerImplTest {

	@Mock
	UserServiceImpl userServiceImplMock;

	@InjectMocks
	private UserControllerImpl userControllerImpl;

	private User user;

	@BeforeEach
	void init() {
		user = new User();
		user.setUserId(1);
	}

	@Test
	void whenAddUserThenSaveUserAndReturnUser() {
		when(userServiceImplMock.saveUser(user)).thenReturn(user);
		assertEquals(user, userControllerImpl.addUser(user));
		verify(userServiceImplMock, times(1)).saveUser(user);
	}

	@Test
	void whenGetUserWithIdXThenReturnUserWithIdX() {
		when(userServiceImplMock.getUser(user.getUserId())).thenReturn(user);
		assertEquals(user, userControllerImpl.getUser(user.getUserId()));
		verify(userServiceImplMock, times(1)).getUser(user.getUserId());
		}

	@Test
	void whenGetUsersThenReturnAllUsers() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User());
		usersList.add(new User());
		when(userServiceImplMock.getUsers()).thenReturn(usersList);
		assertEquals(usersList, userControllerImpl.getUsers());
		verify(userServiceImplMock, times(1)).getUsers();
	}

	@Test
	void whenUpdateExistingUserThenReturnUser() {
		when(userServiceImplMock.updateUser(user)).thenReturn(user);
		assertEquals(user, userControllerImpl.updateUser(user));
		verify(userServiceImplMock, times(1)).updateUser(user);
	}

	@Test
	void whenUpdateNotExistingUserThenReturnIllegalArgumentException() {
		user.setUserId(0);
		lenient().when(userServiceImplMock.updateUser(user)).thenThrow(IllegalArgumentException.class);
		lenient().when(userServiceImplMock.updateUser(null)).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> userControllerImpl.updateUser(user));
		assertThrows(IllegalArgumentException.class, () -> userControllerImpl.updateUser(null));
	}

	@Test
	void whenDeleteUserWithExistingUserIdThenDeleteAndReturnUserId() {
		when(userServiceImplMock.deleteUser(user.getUserId())).thenReturn(user.getUserId());
		assertEquals(user.getUserId(), userControllerImpl.deleteUser(user.getUserId()));
		verify(userServiceImplMock, times(1)).deleteUser(user.getUserId());
	}

	@Test
	void whenDeleteUserWithNotExistingUserIdThenThrowIllegalArgumentException() {
		when(userServiceImplMock.deleteUser(0)).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, () -> userControllerImpl.deleteUser(0));
	}
}
