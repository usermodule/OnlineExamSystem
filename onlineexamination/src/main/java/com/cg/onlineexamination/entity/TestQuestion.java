package com.cg.onlineexamination.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class TestQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;

//	@ManyToOne
//	@JoinColumn(name = "testPaperId")
//	TestPaper testPaper;

	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String correctAnswer;

	public TestQuestion(String question, String option1, String option2, String option3, String option4,
			String correctAnswer) {
		super();
		this.question = question;
		this.option1 = option1;
		this.option2 = option2;
		this.option3 = option3;
		this.option4 = option4;
		this.correctAnswer = correctAnswer;
	}

//	public TestQuestion(int questionId, TestPaper testPaper, String question, String option1, String option2,
//			String option3, String option4, String correctAnswer) {
//		super();
//		this.questionId = questionId;
//		this.testPaper = testPaper;
//		this.question = question;
//		this.option1 = option1;
//		this.option2 = option2;
//		this.option3 = option3;
//		this.option4 = option4;
//		this.correctAnswer = correctAnswer;
//	}

}