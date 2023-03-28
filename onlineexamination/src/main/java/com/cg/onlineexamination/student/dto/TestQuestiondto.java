package com.cg.onlineexamination.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestQuestiondto {

	private int questionId;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	// private String correctAnswer;

}
