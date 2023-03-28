package com.cg.onlineexamination.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
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

public class Exam {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int examId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "testPaperId")
	private TestPaper testpaper;
	
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "examId")
//	private List<TestPaper> testpaper;
	
	

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "testQuestionId")
//    private TestQuestion testQuestion;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "studentd")
//	private Student student;

	private int score;
	private LocalDate dateOfExam;
	private String studentAnswer;

	public Exam(LocalDate dateOfExam, String studentAnswer) {
		super();
		
		this.dateOfExam = dateOfExam;
		this.studentAnswer = studentAnswer;
	}

	public Exam(LocalDate dateOfExam) {
		super();
		this.dateOfExam = dateOfExam;

	}

}