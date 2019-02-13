package com.sms.homework;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.HomeWork;

public interface HomeWorkDAO extends JpaRepository<HomeWork,Integer> {

	@Query(value = "SELECT * from home_work where date=?1", nativeQuery = true)
	HomeWork fetchByDate(String date);

	@Query(value = "select s.subject_name,c.class_name,se.section_name,h.name,h.description,h.date from \r\n" + 
			"subject s,teacher t,home_work h,class c,section se \r\n" + 
			"where s.subject_id=h.subject_id and se.class_id=c.class_id and h.section_id=se.section_id and\r\n" + 
			"t.teacher_id=h.teacher_id and h.teacher_id=?2 and h.date=?1", nativeQuery = true)
	List<Object[]> getHomeWorkByTeacherIdandDate(String user_id, int teacherId);

	@Query(value = "  select \r\n" + 
			"  s.subject_name,\r\n" + 
			"  h.name,\r\n" + 
			"  h.description,\r\n" + 
			"  h.date \r\n" + 
			"  from \r\n" + 
			"subject s,\r\n" + 
			"home_work h\r\n" + 
			" where s.subject_id=h.subject_id and \r\n" + 
			" h.section_id=?2 and h.date=?1", nativeQuery = true)
	List<Object[]> getHomeWorkBySectionIdandDate(String user_id, int sectionId);	

}
