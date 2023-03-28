package com.cg.onlineexamination.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class TestPaper {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testPaperId;

	private String difficultyLevel;
	private String description;
	private String course;
	private int noOfQuestions;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "TestPaperId")
	//@Column(name="id")
	private List<TestQuestion> testQuestion;

//  @ManyToOne(cascade = CascadeType.ALL)
//  @JoinColumn(name = "examId")
//  private Exam exam;

//	@OneToOne(mappedBy = "testPaper")
//	private Exam exam;

	public TestPaper(String difficultyLevel, String description, String course, int noOfQuestions) {
		super();

		this.difficultyLevel = difficultyLevel;
		this.description = description;
		this.course = course;
		this.noOfQuestions = noOfQuestions;
	}

}