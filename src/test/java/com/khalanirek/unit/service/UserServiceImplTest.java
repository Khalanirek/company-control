package com.khalanirek.unit.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.khalanirek.entity.User;
import com.khalanirek.exception.notfound.UserNotFoundException;
import com.khalanirek.exception.validation.ValidationException;
import com.khalanirek.repository.UserRepository;
import com.khalanirek.service.impl.UserServiceImpl;
import com.khalanirek.service.validation.UserPersistenceValidator;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

	@Mock
	UserRepository userRepositoryImplMock;

	@Mock
	UserPersistenceValidator userPersistenceValidatorMock;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	private User user;

	@BeforeEach
	void init() {
		user = new User();
		user.setUserId(1);
	}

	@Test
	void whenSaveUserThenSaveWithId0Test() throws ValidationException {
		doNothing().when(userPersistenceValidatorMock).validate(user);
		userServiceImpl.saveUser(user);
		ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
		verify(userRepositoryImplMock).save(argument.capture());
		assertEquals(0, argument.getValue().getUserId());
	}

	@Test
	void whenSaveUserThenReturnUserTest() throws ValidationException {
		when(userRepositoryImplMock.save(any(User.class))).thenReturn(user);
		assertEquals(user, userServiceImpl.saveUser(user));
	}

	@Test
	void whenGetUserXThenReturnUserX() throws UserNotFoundException {
		when(userRepositoryImplMock.findById(user.getUserId())).thenReturn(Optional.of(user));
		assertEquals(user, userServiceImpl.getUser(user.getUserId()));
	}

	@Test
	void whenGetUserWithWrongIdThenThrowException() {
		user.setUserId(0);
		when(userRepositoryImplMock.findById(user.getUserId())).thenReturn(Optional.empty());
		assertThrows(UserNotFoundException.class, () -> userServiceImpl.getUser(user.getUserId()));
	}

	@Test
	void whenGetUsersThenReturnAllUsers() {
		List<User> usersList = new ArrayList<>();
		usersList.add(new User());
		usersList.add(new User());
		when(userRepositoryImplMock.findAll()).thenReturn(usersList);
		assertEquals(usersList, userServiceImpl.getUsers());
	}

	@Test
	void whenUpdateUserWithId0ThenThrowValidationException() {
		user.setUserId(0);
		assertThrows(ValidationException.class, () -> userServiceImpl.updateUser(user));
	}

	@Test
	void whenUpdateExistingUserThenSaveThisUserAndReturnThisUser() throws ValidationException {
		when(userRepositoryImplMock.save(any(User.class))).thenReturn(user);
		doNothing().when(userPersistenceValidatorMock).validate(user);
		assertEquals(user, userServiceImpl.updateUser(user));
	}

	@Test
	void whenDeleteNotExistingUserThenReturnUserNotFoundException() throws UserNotFoundException {
		user.setUserId(-1);
		when(userRepositoryImplMock.findById(user.getUserId())).thenReturn(Optional.empty());
		assertThrows(UserNotFoundException.class, () -> userServiceImpl.deleteUser(-1));
	}

	@Test
	void whenDeleteUserXThanDeleteUserX() throws UserNotFoundException {

		when(userRepositoryImplMock.findById(user.getUserId())).thenReturn(Optional.of(user));
		doNothing().when(userRepositoryImplMock).delete(user);
		userServiceImpl.deleteUser(user.getUserId());
		verify(userRepositoryImplMock, times(1)).delete(user);
	}
}
