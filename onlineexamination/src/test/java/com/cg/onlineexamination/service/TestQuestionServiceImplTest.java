package com.cg.onlineexamination.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.repository.TestQuestionRepository;
import com.cg.onlineexamination.student.service.TestQuestionServiceImpl;

public class TestQuestionServiceImplTest {

	@InjectMocks
	TestQuestionServiceImpl testQuestionimpl;

	@Mock
	TestQuestionRepository testQuestionRepository;

	@SuppressWarnings("deprecation")
	@BeforeEach

	public void doInIt() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	@DisplayName("Test case to testinsertion of test question when input values are valid ")
	void testAddTestQuestion() {
		TestQuestion sampleInput = new TestQuestion("What is the use of final keyword in Java?",
				"When a class is made final, a subclass of it can not be created.",
				"When a method is final, it can not be overridden.",
				"When a variable is final, it can be assigned value only once.", "All of the above",
				"All of the above");

		TestQuestion actualOutput = new TestQuestion("What is the use of final keyword in Java?",
				"When a class is made final, a subclass of it can not be created.",
				"When a method is final, it can not be overridden.",
				"When a variable is final, it can be assigned value only once.", "All of the above",
				"All of the above");

		TestQuestion expectedOutput = new TestQuestion("What is the use of final keyword in Java?",
				"When a class is made final, a subclass of it can not be created.",
				"When a method is final, it can not be overridden.",
				"When a variable is final, it can be assigned value only once.", "All of the above",
				"All of the above");

		when(testQuestionRepository.save(sampleInput)).thenReturn(actualOutput);

		assertEquals(actualOutput, expectedOutput);
	}

	@Test
	@DisplayName("Test case to testinsertion of test question when input values are valid ")
	void testInsertTestQuestion1() {

		TestQuestion sampleInput = new TestQuestion("What is the use of final keyword in Java?",
				"When a class is made final, a subclass of it can not be created.",
				"When a method is final, it can not be overridden.",
				"When a variable is final, it can be assigned value only once.", "All of the above",
				"All of the above");

		when(testQuestionRepository.save(sampleInput)).thenThrow(NullPointerException.class);
	}

}
