package com.sms.attendance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.Attendance;
import com.sms.beans.Student;
import com.sms.student.StudentDAO;

@Service
public class AttendanceServiceImpl {

	

	@Autowired
	private AttendanceDAO attendanceDAO;

	@Autowired
	private StudentDAO studentDao;
	

	private Student student;
	private int i;
	
	private Attendance attendance;


	@Transactional(rollbackFor = Exception.class)
	public void saveAttendance(int[] studentId, boolean[] status) {
		ArrayList<Attendance> attendances =new ArrayList<>();
		System.out.println(studentId.length);
		System.out.println(status.length);
			for (i=0;i<studentId.length;i++) {
				attendance = new Attendance();
				attendance.setPresence(status[i]);
				student = studentDao.getStudentById(studentId[i]);
				attendance.setStudent(student);
				attendances.add(attendance);
			}
			attendanceDAO.saveAll(attendances);
		}

	public List<Object[]> getAttendanceBySectionMonthYear(int sectionId, int monthId, int yearId) {
		
		return attendanceDAO.getAttendanceBySectionMonthYear(sectionId,monthId,yearId);
		
	}

	public List<Object[]> getAttendanceByStudentIdGroupByMonth(int studentId) {
		// TODO Auto-generated method stub
		return attendanceDAO.getAttendanceByStudentIdGroupByMonth(studentId);
	}
	
}
