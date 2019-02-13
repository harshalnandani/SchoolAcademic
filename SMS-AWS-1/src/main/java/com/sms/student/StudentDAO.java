package com.sms.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Student;

public interface StudentDAO extends JpaRepository<Student,Integer> {

	@Query(value = "SELECT * from student where email_id=?1", nativeQuery = true)
	Student checkEmailId(String emailId);

	@Query(value="SELECT * from student where student_name like %?1%  and school_id=?2",nativeQuery = true)
	List<Student> searchStudent(String studentName,int schoolId);

	@Query(value="select * from student where section_id IS NULL and school_id=?1",nativeQuery = true)
	List<Student> getStudentWithNoAllotatedSection(int schoolId);

	@Query(value = "SELECT * from student where student_id=?1", nativeQuery = true)
	Student getStudentById(int studentId);

	@Query(value = "SELECT * from student where school_id=?1", nativeQuery = true)
	List<Student> getStudentBySchoolId(int schoolId);

	@Query(value = "delete from student where student_id=?1", nativeQuery = true)
	void deleteStudent(int studentId);

	@Query(value = " select \r\n" + 
			"  s.student_id,\r\n" + 
			"  s.student_name,\r\n" + 
			"  c.class_name,\r\n" + 
			"  se.section_name,\r\n" + 
			"  p.fathers_name,\r\n" + 
			"  s.profile_picture_url\r\n" + 
			"  from \r\n" + 
			"  student s,\r\n" + 
			"  section se,\r\n" + 
			"  class c,\r\n" + 
			"  school sc,\r\n" + 
			"  parent p\r\n" + 
			"  \r\n" + 
			"  where \r\n" + 
			"  s.section_Id=se.section_Id\r\n" + 
			"  and s.parent_id=p.parent_id\r\n" + 
			"  and se.class_id=c.class_id\r\n" + 
			"  and c.school_id=sc.school_id\r\n" + 
			"  and s.parent_id=?1", nativeQuery = true)
	List<Object[]> getStudentsByParentId(int parentId);
}
