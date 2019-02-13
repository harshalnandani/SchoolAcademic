package com.sms.examtimetable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.ExamTimeTable;

public interface ExamTimeTableDAO extends JpaRepository<ExamTimeTable,Integer>{

	@Query(value = "SELECT file_url FROM exam_time_table where id=?1", nativeQuery = true)
	String getExamTimeTableFileUrlById(int examTimeTableId);

}
