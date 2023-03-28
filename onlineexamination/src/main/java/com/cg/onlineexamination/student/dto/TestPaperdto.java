package com.cg.onlineexamination.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestPaperdto {

	private int testPaperId;
	private String difficultyLevel;
	private String description;
	private String course;
	private int noOfQuestions;

}