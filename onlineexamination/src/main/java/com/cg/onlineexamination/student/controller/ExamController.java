package com.cg.onlineexamination.student.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.dto.Examdto;
import com.cg.onlineexamination.student.dto.TestPaperdto;
import com.cg.onlineexamination.student.exception.ExamNotFoundException;
import com.cg.onlineexamination.student.service.ExamService;
import com.cg.onlineexamination.student.service.TestPaperService;
//import com.cg.onlineexamination.student.util.ExamDTOConvertor;

@RestController
@RequestMapping("/exam")
@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:2025/"}, allowedHeaders="*")
public class ExamController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ExamService examService;
	
	@Autowired
	TestPaperService testPaperService;

//	@Autowired
//	ExamDTOConvertor examDtoConvertor;

	public ExamController() {
		logger.info("exam controller");
		System.err.println("exam controller");
	}
	
	
	@PostMapping("/add")
	
	public Exam addExam(@RequestBody Examdto examDto) {
		return examService.addExam(examDto);
	}
	
	
	@GetMapping("/byId/{eid}")
	public Exam getExamById(@PathVariable int examId)  {
		
			return examService.getExambyId(examId);	
		
			}
	
	@GetMapping("/examlist")
	public List<Exam> getAllExams() {
		
		return examService.getAllExams();
	}
	
	@PutMapping("/studentAnswer/{eid}")
	public String updateExamWithStudentAnswer(@PathVariable int eid, @RequestBody Examdto examdto)
			throws ExamNotFoundException {
		System.out.println("Inside updateExamWithStudentAnswer Method");
        System.out.println(eid);
        System.out.println(examdto.getQuestionNo());
        System.out.println(examdto.getStudentAnswer());
		Exam updatedExam = examService.updateStudentAnswer(eid, examdto);

//		if(!updatedExam.getStudentAnswer().equals(null))

		return updatedExam.toString();

	
}
	
	
	@GetMapping("/scoreByExamId/{eid}")
	public int getScoreByExamId(@PathVariable int eid) {
		return examService.getScoreByExamId(eid);
	}
	
	
	
	
	
	
	
	
	
	@PutMapping("/{eid}/testPaper/{tpid}")

	public String updateExamWithTestPaper(@PathVariable int eid,@PathVariable int tpid) throws Exception

	{

	Exam updatedExam = examService.updateTestPaper(eid, tpid);

	if(updatedExam.getTestpaper() != null)

	{

	return updatedExam.toString();

	}

	else return "error : - "+updatedExam.toString()+" ";

	}
	
//	@PostMapping("/add")
//	public ResponseEntity<Examdto> saveExam(@RequestBody Exam exam) throws Exception {
//		exam.setDateOfExam(LocalDate.now());
//		Exam savedExam = examService.addExam(exam);
//		
//		logger.info(" --->> Exam saved " + savedExam);
//
//		if (savedExam != null) {
//			Examdto dtoObj = examDtoConvertor.getExamdto(savedExam);
//			return new ResponseEntity<Examdto>(dtoObj, HttpStatus.OK);
//
//		}
//		return null;
//	}
//
//	@GetMapping("/list")
//	public ResponseEntity<List<Examdto>> getAllExams() {
//		List<Exam> allExamsInDB = examService.getAllExams();
//
//		List<Examdto> dtoList = new ArrayList<>();
//		for (Exam exam : allExamsInDB) {
//
//			Examdto dtoObj = examDtoConvertor.getExamdto(exam);
//			dtoList.add(dtoObj);
//		}
//
//		return new ResponseEntity<List<Examdto>>(dtoList, HttpStatus.OK);
//	}
//
//	@GetMapping("/{examid}")
//	public ResponseEntity<Examdto> getExamById(@PathVariable int examid) throws Exception {
//
//		Exam savedExam = examService.getExambyId(examid);
//		Examdto examdto = examDtoConvertor.getExamdto(savedExam);
//		return new ResponseEntity<Examdto>(examdto, HttpStatus.OK);
//
//	}
//
//	@PutMapping("/{eid}/testPaper/{tpid}")
//	public String updateExamWithTestPaper(@PathVariable int eid, @PathVariable int tpid) {
//		Exam updatedExam = examService.updateTestPaperByExamId(eid, tpid);
//
//		if (updatedExam.getTestpaper() != null) {
//			return updatedExam.toString();
//		} else
//			return "error : - " + updatedExam.toString() + " ";
//	}
//	
//	
//	
////	@PutMapping("/{eid}/testPaper/{tpid}")
////	public Examdto updateExamWithTestPaper(@PathVariable int eid, @PathVariable int tpid) {
////		
////		Exam updatedExam = examService.updateTestPaperByExamId(eid, tpid);
////		
////		if(updatedExam !=null) {
////			Examdto examDto = examDtoConvertor.getExamdto(updatedExam);
////			return examDto;
////		}
////		return null;
////				
////	}
//	
//	
//
//	else return "error : - "+updatedExam.toString()+" ";
//	}
//
////	@PostMapping("/studentAnswer/{eid}")
////	public ResponseEntity<Examdto> getStudentAnswerByExamId (@PathVariable int eid){
////		Exam savedExam = examService.getStudentAnswerByExamId(eid);
////		Examdto dtoObj = examDtoConvertor.getExamdto(savedExam);
////		return new ResponseEntity<Examdto>(dtoObj, HttpStatus.OK);
////
////		
	}

