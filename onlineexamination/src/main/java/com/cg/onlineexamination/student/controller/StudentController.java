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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.student.dto.StudentDTO;
import com.cg.onlineexamination.student.service.IStudentService;
import com.cg.onlineexamination.student.util.StudentDTOConvertor;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = {"http://localhost:4200/","http://localhost:2025/"}, allowedHeaders="*")
public class StudentController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IStudentService studentService;

	@Autowired
	StudentDTOConvertor studentDtoConvertor;

	public StudentController() {
		logger.info("student controller");
		System.err.println("student controller");
	}

	@PostMapping("/register")
	public ResponseEntity<StudentDTO> saveStudent(@RequestBody Student student) throws Exception {
		Student savedStudent = studentService.addStudent(student);
		logger.info(" --->> Student saved " + savedStudent);

		if (savedStudent != null) {
			StudentDTO dtoObj = studentDtoConvertor.getStudentdto(savedStudent);
			return new ResponseEntity<StudentDTO>(dtoObj, HttpStatus.OK);

		}
		return null;
	}

	@GetMapping("/list")
	public ResponseEntity<List<StudentDTO>> getAllStudents() {
		List<Student> allStudentsInDB = studentService.getAllStudents();

		List<StudentDTO> dtoList = new ArrayList<>();
		for (Student student : allStudentsInDB) {

			StudentDTO dtoObj = studentDtoConvertor.getStudentdto(student);
			dtoList.add(dtoObj);
		}

		return new ResponseEntity<List<StudentDTO>>(dtoList, HttpStatus.OK);
	}

//	@GetMapping("/score/{studentId}")
//	public int viewScoreByStuentId(@PathVariable int studentId){
//		
//		int savedStudent = studentService.getScoreByStudentId(studentId);
//		
//		return savedStudent;

//		Student savedStudent = studentService.getScoreByStudentId(studentId);
////		StudentDTO studentDTO = studentDtoConvertor.getStudentdto(savedStudent);
////		return new ResponseEntity<Student>(savedStudent,HttpStatus.OK);
//		return savedStudent;
}
