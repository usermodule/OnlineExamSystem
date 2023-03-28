package com.cg.onlineexamination.student.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.onlineexamination.student.dto.ExceptionDTOResponse;

@ControllerAdvice
public class CommonExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> invalidName(InvalidStudentException e) {
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDatetime(LocalDateTime.now() + "");
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<ExceptionDTOResponse> invalidPassword(NullPointerException e) {
		ExceptionDTOResponse dto = new ExceptionDTOResponse();
		dto.setErrorMsg(e.toString());
		dto.setDatetime(LocalDateTime.now() + "");
		return new ResponseEntity<ExceptionDTOResponse>(dto, HttpStatus.BAD_REQUEST);
	}
}
