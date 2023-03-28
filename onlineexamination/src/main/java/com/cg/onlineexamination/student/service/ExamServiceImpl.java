package com.cg.onlineexamination.student.service;

import java.io.InvalidClassException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.Examdto;
import com.cg.onlineexamination.student.dto.TestPaperdto;
import com.cg.onlineexamination.student.dto.TestQuestiondto;
import com.cg.onlineexamination.student.exception.ExamNotFoundException;
import com.cg.onlineexamination.student.repository.ExamRepository;
import com.cg.onlineexamination.student.repository.IStudentRepository;
import com.cg.onlineexamination.student.repository.TestPaperRepository;
import com.cg.onlineexamination.student.repository.TestQuestionRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.Generated;

@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	ExamRepository examRepository;

	@Autowired
	TestPaperRepository testPaperRepository;

	@Autowired
	IStudentRepository studentRpository;

	@Autowired
	TestQuestionRepository testQuestionRepository;

	
	
	
	@Override
	public Exam addExam(Examdto examDto) {
		
		Exam addExam = new Exam();
		
		addExam.setDateOfExam(LocalDate.now());
				return examRepository.save(addExam);
	}


	public int getScoreByExamId(int examId) {
		Exam exam = examRepository.getReferenceById(examId);
		int score = exam.getScore();
		return score;
	}

//	@Override
//	public Exam getExambyId(int examId) throws Exception {
//
//			
//		Optional<Exam> optExam = this.examRepository.findById(null);
//		if (optExam.isEmpty()) {
//			throw new ExamNotFoundException("Exam is null");
//		}
// 
//		Exam exam = optExam.get();
//		return exam;
//		
//		
//	}




	@Override
	public List<Exam> getAllExams() {
		
		return examRepository.findAll();
	}




	




//	@Override
//	public Exam updateExam(Examdto examDto) {
//		Optional<Exam> optExam= this.examRepository.findById(examDto.getExamId());
//		return null;
//	}

	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	

//	@Override
//	public Exam addExam(Exam exam) throws Exception {
//		if (exam != null) {
//			if (exam.getDateOfExam().equals(" ")) {
//				throw new InvalidClassException("exam", "exam is null");
//			}
//			Exam savedExam = examRepository.save(exam);
//			return savedExam;
//		} else
//
//			throw new NullPointerException("exam is null");
//	}

	
	@Override
	public Exam getExambyId(int id) {

		if (id >= 1) {
			Exam savedExam = examRepository.getReferenceById(id);
			
				return savedExam;
		}
		return null;

	}

	
	
	
	
	
	
	@Override

	public Exam updateTestPaper(int examId, int testPaperId)throws Exception {

	Exam savedExam = examRepository.getReferenceById(examId);
    
	TestPaper savedTestPaper = testPaperRepository.getReferenceById(testPaperId);
    
	
	if(savedExam != null & savedTestPaper != null)

	{

//	savedExam.setTestPaper(savedTestPaper);
	savedExam.setTestpaper(savedTestPaper);
	testPaperRepository.saveAndFlush(savedTestPaper);
	examRepository.save(savedExam);
	
	return savedExam;

	}
	return null;

	}



	@Override
	@Transactional
	public Exam updateStudentAnswer(int examId, Examdto examdto) throws ExamNotFoundException {
		System.out.println("Inside updateStudentAnswer Method");
		int score = examdto.getScore();
		Exam exam = examRepository.getReferenceById(examId);
		TestPaper testPaper = examRepository.getReferenceById(examId).getTestpaper();
		if (exam == null) {

			throw new ExamNotFoundException("Exam not found");
		}
		exam.setStudentAnswer(examdto.getStudentAnswer());
		TestQuestion testQuestion =
		testQuestionRepository.findById(examdto.getQuestionNo()).get();
		testQuestionRepository.getReferenceById(testPaper.getTestPaperId()).getQuestionId();
		
		if(examdto.getStudentAnswer().equals(testQuestion.getCorrectAnswer())) {
			System.out.println("Correct Answer");
			examRepository.updateScore(examId);
			return examRepository.save(exam);
			
		}
		else
			System.out.println("Wrong Answer");
//		exam.setScore(evaluateScore(exam.getTestpaper().getTestQuestion(), examdto.getStudentAnswer()));
return null;
	
	}

	
//	
//
//}
//
///*
// * @Override public Exam startExam(int examId) {
// * 
// * } }
// */
//
///*
// * @Override public Exam findResultByEnrollmentId(int enrollmentId) throws
// * ExamNotFoundException { Exam result =
// * examRepository.findByEnrollmentId(enrollmentId); if (result == null) { throw
// * new ExamNotFoundException("Exam not found for enrollment ID: " +
// * enrollmentId); } return result;
// * 
// * }
// * 
// * @Override public List<Exam> findAllResultsByBatchName(String batchName)
// * throws ExamNotFoundException { List<Exam> examResults =
// * examRepository.findAllByBatchName(batchName); if (examResults.isEmpty()) {
// * throw new ExamNotFoundException("No exams found for batch name: " +
// * batchName); } return examResults; }
// * 
// * 
// * 
// * @Override public boolean releaseResultByEnrollmentId(int enrollmentId) { //
// * TODO Auto-generated method stub return false; }
// */
}