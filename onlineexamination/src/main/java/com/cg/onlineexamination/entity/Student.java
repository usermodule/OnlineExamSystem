package com.cg.onlineexamination.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;

	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String gender;
	private String emailId;
	private long mobileNo;
//	private int score;

	public Student(String userName, String password, String firstName, String lastName, String gender, String emailId,
			long mobileNo) {
		super();

		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.emailId = emailId;
		this.mobileNo = mobileNo;
	}

}
