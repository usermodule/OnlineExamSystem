package com.cg.onlineexamination.student.service;

import java.io.InvalidClassException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Student;
import com.cg.onlineexamination.entity.TestQuestion;
import com.cg.onlineexamination.student.repository.IStudentRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class StudentServiceImpl implements IStudentService {

	@Autowired
	IStudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) throws Exception {
		if (student != null) {
			if (student.getUserName().equals("")) {
				throw new InvalidClassException("student", "student is null");
			}

		} // else
			// throw new NullPointerException("student is null");
		Student savedStudent = studentRepository.save(student);
		return savedStudent;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

}
