package com.example.demo.exception;

public class UserNotFoundInDB extends Exception {

	public UserNotFoundInDB(String message) {
		super(message);
	}
}
