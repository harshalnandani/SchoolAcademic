package com.sms.section;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Section;

public interface SectionDAO extends JpaRepository<Section,Integer> {

	@Query(value = "SELECT section_name from section where section_name=?1 and class_id=?2", nativeQuery = true)
	String checkSectionName(String sectionName, int classId);

	@Query(value = "SELECT section_id,section_name from section where class_id=?1", nativeQuery = true)
	List<Object[]> getSectionByClassId(int user_id);

	@Query(value = "select c.class_name,s.section_id,s.section_name  from section s,class c where s.class_id=c.class_id and school_id=?1", nativeQuery = true)
	List<Object[]> getSectionNameAndIdBySchoolId(int schoolId);

	@Query(value = "SELECT student_id,student_name from student where section_id=?1", nativeQuery = true)
	List<Object[]> getStudentsBySectionId(int sectionId);

	@Query(value = "select \r\n" + 
			"  s.subject_name,\r\n" + 
			"  s.subject_id \r\n" + 
			"  from \r\n" + 
			"  subject s,\r\n" + 
			"  section_subjects ss\r\n" + 
			"  \r\n" + 
			"  where \r\n" + 
			"  s.subject_id=ss.subjects_key\r\n" + 
			"  and ss.section_section_id=?1", nativeQuery = true)
	List<Object[]> getSubjectNameIdBySectionId(int sectionId);

	@Query(value = "SELECT\r\n" + 
			"    class.class_name\r\n" + 
			"    , section.section_name\r\n" + 
			"    , teacher.teacher_name\r\n" + 
			"    , subject.subject_name\r\n" + 
			"FROM\r\n" + 
			"    sms.section\r\n" + 
			"    INNER JOIN class \r\n" + 
			"        ON (section.class_id = class.class_id)\r\n" + 
			"    INNER JOIN sms.section_subjects \r\n" + 
			"        ON (section_subjects.section_section_id = section.section_id)\r\n" + 
			"    INNER JOIN subject \r\n" + 
			"        ON (section_subjects.subjects_key = subject.subject_id)\r\n" + 
			"    INNER JOIN teacher \r\n" + 
			"        ON (section_subjects.subjects_teacher_id = teacher.teacher_id)\r\n" + 
			"    INNER JOIN school \r\n" + 
			"        ON (teacher.school_id = school.school_id) AND (subject.school_id = school.school_id) AND (class.school_id = school.school_id)\r\n" + 
			"    where school.school_id=?1", nativeQuery = true)
	List<Object[]> getSubjectTeacherMappingBySchoolId(int schoolId);

	

}
