package com.cg.onlineexamination.student.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.dto.TestQuestiondto;

@Component
public class TestQuestionDtoConvertor {

	public TestQuestiondto getTestQuestiondto(TestQuestion tq) {
		return new TestQuestiondto(tq.getQuestionId(), tq.getQuestion(), tq.getOption1(), tq.getOption2(),
				tq.getOption3(), tq.getOption4());

	}

}