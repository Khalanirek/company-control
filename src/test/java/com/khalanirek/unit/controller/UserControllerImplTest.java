package com.khalanirek.unit.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.controller.impl.UserControllerImpl;
import com.khalanirek.entity.User;
import com.khalanirek.exception.notfound.UserNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
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
	void whenAddUserThenServiceSaveUser() throws ValidationException {
		userControllerImpl.addUser(user);
		verify(userServiceImplMock, times(1)).saveUser(user);
	}

	/*@Test
	void whenAddUserThenReturnUser() throws ValidationException {
		when(userServiceImplMock.saveUser(user)).thenReturn(user);
		assertEquals(user, userControllerImpl.addUser(user));
	}*/

	@Test
	void whenGetUserThenServiceGetUser() throws UserNotFoundException {
		userControllerImpl.getUser(user.getUserId());
		verify(userServiceImplMock).getUser(user.getUserId());
	}

	/*@Test
	void whenGetExistingUserThenReturnUser() throws UserNotFoundException {
		when(userServiceImplMock.getUser(user.getUserId())).thenReturn(user);
		assertEquals(user, userControllerImpl.getUser(user.getUserId()));
		verify(userServiceImplMock, times(1)).getUser(user.getUserId());
		}*/

	@Test
	void whenGetUsersThenServiceGetUsers() {
		userControllerImpl.getUsers();
		verify(userServiceImplMock).getUsers();
	}

	/*@Test
	void whenGetUsersThenReturnAllUsers() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User());
		usersList.add(new User());
		when(userServiceImplMock.getUsers()).thenReturn(usersList);
		assertEquals(usersList, userControllerImpl.getUsers());
		verify(userServiceImplMock, times(1)).getUsers();
	}*/

	@Test
	void whenUpdateUserThenUpdateUser() throws ValidationException {
		userControllerImpl.updateUser(user);
		verify(userServiceImplMock, times(1)).updateUser(user);
	}

	/*@Test
	void whenUpdateExistingUserThenReturnUser() throws ValidationException {
		when(userServiceImplMock.updateUser(user)).thenReturn(user);
		assertEquals(user, userControllerImpl.updateUser(user));
	}*/

	@Test
	void whenDeleteUserThenServiceDeleteUser() throws UserNotFoundException {
		userControllerImpl.deleteUser(user.getUserId());
		verify(userServiceImplMock).deleteUser(user.getUserId());
	}

	/*@Test
	void whenDeleteUserWithExistingUserIdThenDelete() throws UserNotFoundException {
		doNothing().when(userServiceImplMock).deleteUser(user.getUserId());
		userControllerImpl.deleteUser(user.getUserId());
		verify(userServiceImplMock, times(1)).deleteUser(user.getUserId());
	}*/
}
