package com.cg.onlineexamination.student.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.Examdto;
import com.cg.onlineexamination.student.dto.TestQuestiondto;
import com.cg.onlineexamination.student.exception.ExamNotFoundException;

@Service
public interface ExamService {
	
	public Exam addExam(Examdto examDto) ;
	
	public Exam getExambyId(int examId) ;
	
	public List<Exam> getAllExams();
	
//	public Exam updateExam(Examdto examDto);
	


//	public Exam addExam(Exam exam) throws Exception;
//
//	public Exam getExambyId(int Id) throws Exception;
//
//	public List<Exam> getAllExams();
	
	public Exam updateTestPaper(int examId , int testPaperId)throws Exception;

	public Exam updateStudentAnswer(int examId, Examdto examdto) throws ExamNotFoundException;

	public int getScoreByExamId(int examId);
	
//	public Exam updateTestPaperByExamId(int examId, int testPaperId);
//
//	public Exam getStudentAnswerByExamId(Examdto examDto);
//
//	// public Exam startExam(int examId);
//	/*
//	 * public Exam findResultByEnrollmentId(int enrollmentId); List<Exam>
//	 * findAllResultsByBatchName(String batchName); boolean
//	 * releaseResultByEnrollmentId(int enrollmentId);
//	 */
}
