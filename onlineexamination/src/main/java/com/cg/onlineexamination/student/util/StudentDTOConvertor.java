package com.cg.onlineexamination.student.util;

import org.springframework.stereotype.Component;

import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.student.dto.StudentDTO;

@Component
public class StudentDTOConvertor {

	public StudentDTO getStudentdto(Student s) {
		return new StudentDTO(s.getStudentId(), s.getUserName(), s.getPassword(), s.getFirstName(), s.getLastName(),
				s.getGender(), s.getEmailId(), s.getMobileNo());

	}
}
