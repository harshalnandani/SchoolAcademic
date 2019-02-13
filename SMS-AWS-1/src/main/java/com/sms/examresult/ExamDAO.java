package com.sms.examresult;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Exam;

public interface ExamDAO extends JpaRepository<Exam,Integer> {

	@Query(value = "SELECT exam_name from exam where exam_name=?1 and session=?2 and school_id=?3", nativeQuery = true)
	String checkExamAndSession(String examName, String session, int schoolId);

	@Query(value = "SELECT * from exam where school_id=?1", nativeQuery = true)
	List<Exam> getExamsBySchoolId(int schoolId);

	@Query(value = "SELECT\r\n" + 
			"    DISTINCT subject.subject_name\r\n" + 
			"FROM\r\n" + 
			"    result\r\n" + 
			"    INNER JOIN subject \r\n" + 
			"        ON (result.subject_id = subject.subject_id)\r\n" + 
			"    INNER JOIN exam \r\n" + 
			"        ON (result.exam_id = exam.exam_id) WHERE exam.exam_id=?1", nativeQuery = true)
	List<String> getDISTINCTSubjectByExamId(int examId);

}
