package com.sms.syllabus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Syllabus;

public interface SyllabusDAO extends JpaRepository<Syllabus,Integer> {

	@Query(value = "SELECT file_url from syllabus where id=?1", nativeQuery = true)
	String getFileUrlById(int syllabusId);

	@Query(value = "SELECT * from syllabus where class_id=?1", nativeQuery = true)
	Syllabus getSyllabusByClassId(int classId);

}
