package com.cg.onlineexamination.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineexamination.entity.TestPaper;

@Repository
public interface TestPaperRepository extends JpaRepository<TestPaper, Integer> {

}