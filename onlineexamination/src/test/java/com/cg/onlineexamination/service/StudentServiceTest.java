package com.cg.onlineexamination.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.repository.IStudentRepository;
import com.cg.onlineexamination.student.service.StudentServiceImpl;

public class StudentServiceTest {

	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	
	@Mock
	IStudentRepository studentRepository;
	
	@SuppressWarnings("deprication")
	@BeforeEach
	
	public void doInIt() {
		MockitoAnnotations.initMocks(this);
	}
	

	@Test
	@DisplayName("Test case to testinsertion of Student when input values are valid")
	
	void testAddStudent() {
		Student sampleInput = new Student("Shrak","123","Shra","Khadse","Female","ShravaniK@gmail.com",9854326754L);
		
		Student actualInput = new Student("Shrak","123","Shra","Khadse","Female","ShravaniK@gmail.com",9854326754L);
		
		Student expectedInput = new Student("Shrak","123","Shra","Khadse","Female","ShravaniK@gmail.com",9854326754L);
		
		when(studentRepository.save(sampleInput)).thenReturn(actualInput);
		
		assertEquals(actualInput, expectedInput);
	}
	
	@Test
	@DisplayName("Test case to testinsertion of test paper when input values are valid")
	void testStudent1() {
		Student sampleInput = new Student("Shrak","123","Shra","Khadse","Female","ShravaniK@gmail.com",9854326754L);
		when(studentRepository.save(sampleInput)).thenThrow(NullPointerException.class);
	}  
}
