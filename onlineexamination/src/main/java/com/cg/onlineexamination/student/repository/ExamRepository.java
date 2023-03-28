package com.cg.onlineexamination.student.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.Exam;
import com.cg.onlineexamination.entity.TestPaper;
import com.cg.onlineexamination.student.dto.Examdto;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

//	Exam updateTestpaper(Exam savedExam, TestPaper savedTestPaper);

	
//	Exam updateTestpaper(Exam savedExam, TestPaper savedTestPaper);
	@Query(value = "update Exam set Score = Score+1 where exam_id = :examId",nativeQuery = true)
	@Modifying
	public int updateScore(@Param("examId") int examId);
}
