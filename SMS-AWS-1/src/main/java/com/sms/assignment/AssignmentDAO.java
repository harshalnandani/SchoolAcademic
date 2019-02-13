package com.sms.assignment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Assignment;

public interface AssignmentDAO extends JpaRepository<Assignment,Integer> {

	@Query(value = "SELECT * from assignment where teacher_id=?1", nativeQuery = true)
	List<Assignment> getAssignmentsByTeacherId(int teacherId);

	@Query(value = "SELECT file_url from assignment where assignment_id=?1", nativeQuery = true)
	String getFileUrlById(int assignmentId);

	@Query(value = "SELECT * from assignment where section_id=?1", nativeQuery = true)
	List<Assignment> getAssignmentsBySectionId(int sectionId);

}
