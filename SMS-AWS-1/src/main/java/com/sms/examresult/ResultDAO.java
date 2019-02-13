package com.sms.examresult;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Result;

public interface ResultDAO extends JpaRepository<Result,Integer> {

	@Query(value = "SELECT  \r\n" + 
			"student.student_name\r\n" + 
			"    , subject.subject_name\r\n" + 
			"    , result.marks\r\n" + 
			",section.section_id\r\n" + 
			",result.exam_id\r\n" + 
			"FROM\r\n" + 
			"    student\r\n" + 
			"    INNER JOIN section \r\n" + 
			"        ON (student.section_id = section.section_id)\r\n" + 
			"    INNER JOIN result \r\n" + 
			"        ON (result.student_id = student.student_id)\r\n" + 
			"    INNER JOIN subject \r\n" + 
			"        ON (result.subject_id = subject.subject_id) \r\n" + 
			"GROUP BY subject.subject_id,student.student_id having section.section_id=?1 and result.exam_id=?2", nativeQuery = true)
	List<Object[]> getResultByExamAndSectionId(int sectionId, int examId);
}
