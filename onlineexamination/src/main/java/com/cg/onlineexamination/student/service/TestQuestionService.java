package com.cg.onlineexamination.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.TestPaperdto;
import com.cg.onlineexamination.student.dto.TestQuestiondto;

@Service
public interface TestQuestionService {

	public TestQuestion addTestQuestion(TestQuestion TestQuestion) throws Exception;

	public List<TestQuestion> viewAllTestQuestions();

	public TestQuestion viewTestQuestionById(int id) throws Exception;

	public TestQuestion updateTestPaperByTestQuestion(int testPaperId, int testQuestionId) throws Exception;

	public List<TestQuestion> getAllQuestionsByTestPaperId(int testPaperId);
	
//	public List<TestQuestion> getAllQuestionsByExamId(int examId);
	
//	public List<TestQuestion> getAllQuestionsByCourse(String course,TestPaperdto testPaperDto);

//	public List<TestQuestion> getAllQuestionsByTestPaperId(String course);

}