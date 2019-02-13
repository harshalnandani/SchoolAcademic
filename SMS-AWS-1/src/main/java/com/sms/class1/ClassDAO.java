package com.sms.class1;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Class;

public interface ClassDAO extends JpaRepository<com.sms.beans.Class,Integer> {

	@Query(value = "SELECT class_name from class where class_name=?1 and school_id=?2", nativeQuery = true)
	String checkClassName(String className, int schoolId);

	@Query(value = "SELECT * from class where school_id=?1", nativeQuery = true)
	List<Class> getClassBySchoolId(int schoolId);

	@Query(value = "SELECT class_id,class_name from class where school_id=?1", nativeQuery = true)
	List<Object[]> getClassAndId(int schoolId);

	@Query(value = "SELECT\r\n" + 
			"    subject.subject_id\r\n" + 
			"    , subject.subject_name\r\n" + 
			"FROM\r\n" + 
			"    section_subjects\r\n" + 
			"    INNER JOIN subject \r\n" + 
			"        ON (section_subjects.subjects_key = subject.subject_id)\r\n" + 
			"    INNER JOIN section \r\n" + 
			"        ON (section_subjects.section_section_id = section.section_id) where section.section_id=?1", nativeQuery = true)
	List<Object[]> getSubjectBySectionId(int user_id);
	
	

}
