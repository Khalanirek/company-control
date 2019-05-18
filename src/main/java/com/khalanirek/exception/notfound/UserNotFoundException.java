package com.khalanirek.exception.notfound;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(long userId) {
		super("User with Id: " + userId + " not found");
	}
}
