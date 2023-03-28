package com.cg.onlineexamination.student.dto;

import java.time.LocalDate;
import java.util.ArrayList;

import com.cg.onlineexamination.entity.TestPaper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor

public class Examdto {

	private int examId;
	private int score;
	private LocalDate dateOfExam;

	private int testPaperId;
	private int questionNo;
	private String studentAnswer;
	
	
	public int getExamId() {
		return examId;
	}
	public void setExamId(int examId) {
		this.examId = examId;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public LocalDate getDateOfExam() {
		return dateOfExam;
	}
	public void setDateOfExam(LocalDate dateOfExam) {
		this.dateOfExam = dateOfExam;
	}
	public int getTestPaperId() {
		return testPaperId;
	}
	public void setTestPaperId(int testId) {
		this.testPaperId = testId;
	}
	public int getQuestionNo() {
		return questionNo;
	}
	public void setQuestionNo(int questionNo) {
		this.questionNo = questionNo;
	}
	public String getStudentAnswer() {
		return studentAnswer;
	}
	public void setStudentAnswer(String studentAnswer) {
		this.studentAnswer = studentAnswer;
	}
	
	
	

}