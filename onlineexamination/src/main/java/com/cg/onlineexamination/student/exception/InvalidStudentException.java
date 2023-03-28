package com.cg.onlineexamination.student.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InvalidStudentException extends Exception {

	String fieldName;
	String msg;

	@Override
	public String toString() {
		return "StudentException [fieldName=" + fieldName + ", msg=" + msg + "]";
	}

}
