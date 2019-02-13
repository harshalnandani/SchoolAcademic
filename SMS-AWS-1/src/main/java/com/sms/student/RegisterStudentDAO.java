package com.sms.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.StudentRegistration;

public interface RegisterStudentDAO extends JpaRepository<StudentRegistration,Integer> {

	@Query(value = "SELECT * from student_registration where school_id=?1 and status=0", nativeQuery = true)
	List<StudentRegistration> getAllRegistrationBySchoolId(int schoolId);

}
