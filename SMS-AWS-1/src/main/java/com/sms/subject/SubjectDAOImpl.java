package com.sms.subject;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Subject;

public interface SubjectDAOImpl extends JpaRepository<Subject,Integer> {

	@Query(value = "SELECT subject_name from subject where subject_name=?1 and school_id=?2", nativeQuery = true)
	String checkSubjectName(String subjectName, int schoolId);

	@Query(value = "SELECT * from subject where subject_id=?1", nativeQuery = true)
	Subject fetchSubjectById(int subjectId);

	@Query(value = "SELECT subject_id,subject_name from subject where school_id=?1", nativeQuery = true)
	List<Object[]> getSubjectAndId(int schoolId);
}
