package com.sms.teacher;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Teacher;

public interface TeacherDAO extends JpaRepository<Teacher,Integer> {

	@Query(value = "SELECT * from teacher where email_id=?1 and school_id=?2", nativeQuery = true)
	Teacher getTeacherByEmailId(String emailId, int schoolId);

	@Query(value="SELECT * from teacher where teacher_name like %?1%  and school_id=?2",nativeQuery = true)
	List<Teacher> searchTeacher(String teacherName, int schoolId);

	@Query(value = "SELECT teacher_id,teacher_name from teacher where school_id=?1", nativeQuery = true)
	List<Object[]> getTeacherAndId(int schoolId);

}
