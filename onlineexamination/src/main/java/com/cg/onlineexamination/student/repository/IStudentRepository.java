package com.cg.onlineexamination.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

//	public Student loginStudent(String username, String password);
}
