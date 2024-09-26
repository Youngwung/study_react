package org.home.mallapi.controller.advice;

import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomControllerAdvice {

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<?> notExist(NoSuchElementException e){

		// NotFound 메세지 리턴
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("msg", e.getMessage()));
		
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> notExist(MethodArgumentNotValidException e){

		// 접근할 수 없습니다 메세지 리턴
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(Map.of("msg", e.getMessage()));
	}

}