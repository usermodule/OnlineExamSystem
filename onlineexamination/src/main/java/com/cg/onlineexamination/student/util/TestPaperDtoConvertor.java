package com.cg.onlineexamination.student.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.dto.TestPaperdto;

@Component
public class TestPaperDtoConvertor {

	public TestPaperdto getTestPaperdto(TestPaper t) {
		return new TestPaperdto(t.getTestPaperId(), t.getDifficultyLevel(), t.getDescription(), t.getCourse(),
				t.getNoOfQuestions());

	}

}