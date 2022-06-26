package com.example.demo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.UserNotFoundInDB;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	Map<String,String> handleInvalidArgument(MethodArgumentNotValidException ex){
		Map<String,String> map=new HashMap<String,String>();
		ex.getBindingResult().getFieldErrors().forEach(error ->{
			map.put(error.getField(),error.getDefaultMessage());
		});
		return map;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(UserNotFoundInDB.class)
	Map<String,String> handleUserNotFound(UserNotFoundInDB ex){
		Map<String,String> map=new HashMap<String,String>();
		map.put("error", ex.getMessage());
		return map;
	}
	
	
}
