package com.cg.onlineexamination.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.repository.TestPaperRepository;
import com.cg.onlineexamination.student.service.TestPaperServiceImpl;

public class TestPaperServiceTest {

	@InjectMocks
	TestPaperServiceImpl testPaperImpl;
	
	@Mock
	TestPaperRepository testPaperRepository;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	
	public void doInIt() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	@DisplayName("Test case to testinsertion of test paper when input values are valid")
	
	void testAddTestPaper() {
		
		TestPaper sampleInput = new TestPaper("Easy","Basic Core Java","Java",10);
		
		TestPaper actualOutput = new TestPaper("Easy","Basic Core Java","Java",10);
		
		TestPaper expectedOutput = new TestPaper("Easy","Basic Core Java","Java",10);
		
		when(testPaperRepository.save(sampleInput)).thenReturn(actualOutput);
		
		assertEquals(actualOutput, expectedOutput);
	}
	
	@Test
	@DisplayName("Test case to testinsertion of test paper when input values are valid")
	void testInsertPaper1() {
		TestPaper sampleInput = new TestPaper("Easy","Basic Core Java","Java",10);
		when(testPaperRepository.save(sampleInput)).thenThrow(NullPointerException.class);
	}  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
