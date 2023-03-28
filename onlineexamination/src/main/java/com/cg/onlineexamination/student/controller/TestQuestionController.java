package com.cg.onlineexamination.student.controller;

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

import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.TestPaperdto;
import com.cg.onlineexamination.student.dto.TestQuestiondto;
import com.cg.onlineexamination.student.service.TestQuestionService;
import com.cg.onlineexamination.student.util.TestQuestionDtoConvertor;

@RestController
@RequestMapping("/testQuestion")
@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:2025/"}, allowedHeaders="*")
public class TestQuestionController {

	private static final TestQuestiondto savedTestQuestion = null;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	TestQuestionService testQuestionService;

	@Autowired
	TestQuestionDtoConvertor testQuestionDtoConvertor;

	public TestQuestionController() {
		logger.info("testquestion controller");
		System.err.println("testquestion controller");
	}

	@PostMapping
	public ResponseEntity<TestQuestiondto> savedTestQuestion(@RequestBody TestQuestion testQuestion) throws Exception {
		TestQuestion savedTestQuestion = testQuestionService.addTestQuestion(testQuestion);
		logger.info(" --->> TestQuestion saved " + savedTestQuestion);

		if (savedTestQuestion != null) {
			TestQuestiondto dtoObj = testQuestionDtoConvertor.getTestQuestiondto(savedTestQuestion);
			return new ResponseEntity<TestQuestiondto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

	@GetMapping("/list")
	public ResponseEntity<List<TestQuestiondto>> getAllTestQuestions() {
		List<TestQuestion> allTestQuestions = testQuestionService.viewAllTestQuestions();
		List<TestQuestiondto> testQuestiondtoList = new ArrayList<>();

		if (allTestQuestions != null && allTestQuestions.isEmpty() == false) {
			for (TestQuestion testQuestion : allTestQuestions) {
				TestQuestiondto testQuestiondto = testQuestionDtoConvertor.getTestQuestiondto(testQuestion);
				testQuestiondtoList.add(testQuestiondto);
			}
		}
		return new ResponseEntity<List<TestQuestiondto>>(testQuestiondtoList, HttpStatus.OK);
	}

	@PutMapping("/{testQuestionid}/testPaper/{tpid}")
	public ResponseEntity<TestQuestiondto> updateTestPaperByTestQuestionId(@PathVariable int testQuestionid,
			@PathVariable int tpid) throws Exception {

		TestQuestion updatedTestQuestion = testQuestionService.updateTestPaperByTestQuestion(tpid, testQuestionid);
		if (updatedTestQuestion != null) {
			TestQuestiondto testQuestiondto = testQuestionDtoConvertor.getTestQuestiondto(updatedTestQuestion);
			return new ResponseEntity<TestQuestiondto>(testQuestiondto, HttpStatus.OK);

		}

		return null;
	}

	@GetMapping("/{testQuestionid}")
	public ResponseEntity<TestQuestiondto> getTestQuestionById(@PathVariable int testQuestionid) throws Exception {

		TestQuestion savedTestQuestion = testQuestionService.viewTestQuestionById(testQuestionid);
		TestQuestiondto testQuestiondto = testQuestionDtoConvertor.getTestQuestiondto(savedTestQuestion);
		return new ResponseEntity<TestQuestiondto>(testQuestiondto, HttpStatus.OK);

	}

	@GetMapping("/getAllQuestion/{testPaperId}")
	public ResponseEntity<List<TestQuestiondto>> getAllQuestionByTestPaperId(@PathVariable int testPaperId) {

		List<TestQuestion> allQuestions = testQuestionService.getAllQuestionsByTestPaperId(testPaperId);
		List<TestQuestiondto> dtoObj = new ArrayList<>();
		for (TestQuestion testQuestion : allQuestions) {
			TestQuestiondto testQuestionDto = testQuestionDtoConvertor.getTestQuestiondto(testQuestion);
			dtoObj.add(testQuestionDto);
		}
		return new ResponseEntity<List<TestQuestiondto>>(dtoObj, HttpStatus.OK);
	}

	
//	@GetMapping("/testQuestionbycourse/{course}")
//	public ResponseEntity<List<TestQuestiondto>> getTestQuestionbycourse(@PathVariable String course,@RequestBody TestPaperdto testPaperDto) {
//
//		List<TestQuestion> allTestQuestion = testQuestionService.getAllQuestionsByCourse(course, testPaperDto);
//		List<TestQuestiondto> dtoObj = new ArrayList<>();
//		for (TestQuestion testQuestion : allTestQuestion) {
//			TestQuestiondto testQuestionDto = testQuestionDtoConvertor.getTestQuestiondto(testQuestion);
//			dtoObj.add(testQuestionDto);
//		}
//		return new ResponseEntity<List<TestQuestiondto>>(dtoObj, HttpStatus.OK);
//	}
	
}