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
import com.cg.onlineexamination.student.service.TestPaperService;
import com.cg.onlineexamination.student.util.TestPaperDtoConvertor;

@RestController
@RequestMapping("/testPaper")
@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:2025/"}, allowedHeaders="*")
public class TestPaperController {

	@Autowired
	TestPaperDtoConvertor testPaperDtoConvertor;

	@Autowired
	TestPaperService testPaperService;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public TestPaperController() {
		logger.info("testpaper controller");
		System.err.println("testpaper controller");
	}

	@PostMapping
	public ResponseEntity<TestPaperdto> saveTestPaper(@RequestBody TestPaper testPaper) throws Exception {
		TestPaper savedTestPaper = testPaperService.addTestPaper(testPaper);
		logger.info(" --->> TestPaper saved " + savedTestPaper);

		if (savedTestPaper != null) {
			TestPaperdto dtoObj = testPaperDtoConvertor.getTestPaperdto(savedTestPaper);
			return new ResponseEntity<TestPaperdto>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

	@GetMapping("/list")
	public ResponseEntity<List<TestPaperdto>> getAllTestPapers() {
		List<TestPaper> allTestPapersInDB = testPaperService.getAllTestPaper();

		List<TestPaperdto> dtoList = new ArrayList<>();
		for (TestPaper testPaper : allTestPapersInDB) {

			TestPaperdto dtoObj = testPaperDtoConvertor.getTestPaperdto(testPaper);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<TestPaperdto>>(dtoList, HttpStatus.OK);
	}

	@GetMapping("/testPaperbycourse/{course}")
	public ResponseEntity<List<TestPaperdto>> getTestPaperByCourse(@PathVariable String course) {

		List<TestPaper> allTestPaper = testPaperService.getTestPaperByCourse(course);
		List<TestPaperdto> dtoObj = new ArrayList<>();
		for (TestPaper testPaper : allTestPaper) {
			TestPaperdto testPaperdto = testPaperDtoConvertor.getTestPaperdto(testPaper);
			dtoObj.add(testPaperdto);
		}
		return new ResponseEntity<List<TestPaperdto>>(dtoObj, HttpStatus.OK);
	}
	
	
	
//	@PutMapping("/{tpid}/exam/{eid}")
//	public ResponseEntity<TestPaperdto> updateTestPaperByExamId(@PathVariable int tpid,@PathVariable int eid) throws Exception {
//
//		TestPaper updatedTestPaper = testPaperService.updateTestPaper(tpid,eid);
//		if(updatedTestPaper !=null) {
//			TestPaperdto testPaperDto = testPaperDtoConvertor.getTestPaperdto(updatedTestPaper);
//			return new ResponseEntity<TestPaperdto>(testPaperDto, HttpStatus.OK);
//		}
//
//		return null;
//	}

//	@GetMapping("/{testPaperId}")
//	public int getNoOfQuestionsByTestPaperId(@PathVariable int testPaperId) {
//		int NoOfQuestions = testPaperService.getNoOfQuestionsByTestPaperId(testPaperId);
//		return NoOfQuestions;
//		
//	}

//	@PutMapping("/{tpid}/exam/{eid}")
//	public String updateTestPaperWithExam(@PathVariable int tpid,@PathVariable int eid)
//	{
//		TestPaper updatedTestPaper = testPaperService.g;
//		if(updatedTestPaper.getExam() != null)
//		{
//			return updatedTestPaper.toString();
//		}
//		else return "error : - "+updatedTestPaper.toString()+" ";
//	}
}