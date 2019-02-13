package com.sms.timetable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.TimeTable;

public interface TimeTableDAO extends JpaRepository<TimeTable,Integer> {

	@Query(value = "SELECT * from time_table where time_table_id=?1", nativeQuery = true)
	TimeTable fetchById(int timeTableId);

	@Query(value = "SELECT name from time_table where section_id=?1", nativeQuery = true)
	String checkSectionTimeTable(int sectionId);

	@Query(value = "SELECT * from time_table where section_id=?1", nativeQuery = true)
	TimeTable getTimeTableBySectionId(int sectionId);

	@Query(value = "select s.subject_name,t.teacher_name from subject s,teacher t,time_table tt,period_subject_mapping ps,section_subjects ss\r\n" + 
			"where tt.section_id=?2 and tt.time_table_id=ps.time_table_id and ps.day_of_week=?3 and ps.period_id=?1\r\n" + 
			"and ps.subject_id=s.subject_id and s.subject_id=ss.subjects_key and t.teacher_id=ss.subjects_teacher_id", nativeQuery = true)
	List<Object[]> getTimeTableByPeriodDaySection(int periodId, int sectionId, String dayOfTheWeek);

	@Query(value = "select\r\n" + 
			"  s.subject_name,\r\n" + 
			"  c.class_name,\r\n" + 
			"  se.section_name\r\n" + 
			"from\r\n" + 
			"  class c,\r\n" + 
			"  subject s,\r\n" + 
			"  teacher t,\r\n" + 
			"  time_table tt,\r\n" + 
			"  period_subject_mapping ps,\r\n" + 
			"  section_subjects ss,\r\n" + 
			"  section se\r\n" + 
			"where\r\n" + 
			"  tt.section_id = se.section_id\r\n" + 
			"  and se.class_id=c.class_id\r\n" + 
			"  and tt.time_table_id = ps.time_table_id\r\n" + 
			"  and ps.day_of_week =?3\r\n" + 
			"  and ps.period_id =?1\r\n" + 
			"  and t.teacher_id=?2\r\n" + 
			"  and ps.subject_id = s.subject_id\r\n" + 
			"  and s.subject_id = ss.subjects_key\r\n" + 
			"  and t.teacher_id = ss.subjects_teacher_id", nativeQuery = true)
	List<Object[]> getTimeTableByPeriodDayTeacher(int periodId, int teacherId, String dayOfTheWeek);	

}
