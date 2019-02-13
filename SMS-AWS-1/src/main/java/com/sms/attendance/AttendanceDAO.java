package com.sms.attendance;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Attendance;

public interface AttendanceDAO extends JpaRepository<Attendance,Integer> {

	@Query(value = "SELECT * from attendance where day=?1 and student_id=?2", nativeQuery = true)
	Attendance checkStudentAttendance(Date day, int studentId);	
	
	@Query(value = "select\r\n" + 
			"  s.student_name,\r\n" + 
			"  count(*),\r\n" + 
			"  COUNT(IF(a.presence = True, 1, NULL)) 'Present',\r\n" + 
			"  COUNT(IF(a.presence = False, 1, NULL)) 'Absence',\r\n" + 
			"  round(\r\n" + 
			"    (COUNT(IF(a.presence = True, 1, NULL)) / count(*)) * 100,\r\n" + 
			"    2\r\n" + 
			"  ) 'Percentage'\r\n" + 
			"from\r\n" + 
			"  attendance a,\r\n" + 
			"  student s\r\n" + 
			"where\r\n" + 
			"  s.student_id = a.student_id\r\n" + 
			"  and MONTH(a.date) = ?2\r\n" + 
			"  and YEAR(a.date) =?3\r\n" + 
			"  and s.section_id=?1\r\n" + 
			"group by\r\n" + 
			"  s.student_id", nativeQuery = true)
	List<Object[]> getAttendanceBySectionMonthYear(int sectionId, int monthId, int yearId);

	@Query(value = "select\r\n" + 
			"MONTHNAME(attendance.date),  \r\n" + 
			"count(*), \r\n" + 
			"  COUNT(IF(attendance.presence = True, 1, NULL)) 'Present', \r\n" + 
			"  COUNT(IF(attendance.presence = False, 1, NULL)) 'Absence', \r\n" + 
			"  round( \r\n" + 
			"    (COUNT(IF(attendance.presence = True, 1, NULL)) / count(*)) * 100, \r\n" + 
			"    2 \r\n" + 
			"  ) 'Percentage' ,\r\n" + 
			"attendance.student_id from attendance GROUP by MONTH(attendance.date),attendance.student_id having attendance.student_id=?1", nativeQuery = true)
	List<Object[]> getAttendanceByStudentIdGroupByMonth(int studentId);

}


