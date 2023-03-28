package com.cg.onlineexamination.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;

@Repository
public interface TestQuestionRepository extends JpaRepository<TestQuestion, Integer> {

//	public void checkAnswer(String option);
//	public TestQuestion updateQuestionByCourse(TestQuestion testQuestion, TestPaper testPaper);
}