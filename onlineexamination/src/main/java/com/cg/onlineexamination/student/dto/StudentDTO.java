package com.cg.onlineexamination.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

	private int studentId;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private long mobileNo;

}
