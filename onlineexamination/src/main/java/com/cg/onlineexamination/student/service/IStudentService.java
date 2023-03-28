package com.cg.onlineexamination.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.onlineexamination.entity.Student;

@Service
public interface IStudentService {

	public Student addStudent(Student student) throws Exception;

	public List<Student> getAllStudents();
//	public int getScoreByStudentId(int studentId);

}