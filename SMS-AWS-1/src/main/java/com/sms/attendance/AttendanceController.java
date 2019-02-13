package com.sms.attendance;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.section.SectionServiceImpl;

@Controller
public class AttendanceController {

	@Autowired
	private AttendanceServiceImpl attendanceServiceImpl;
	
	@Autowired
	private SectionServiceImpl  sectionServiceImpl;
	
	@PostMapping("/WebTakeAttendance1")
	public RedirectView takeAttendanceFront(int sectionId,RedirectAttributes attributes,HttpServletRequest request) {

			List<Object[]> students=sectionServiceImpl.getStudentsBySectionId(sectionId);
			attributes.addFlashAttribute("students",students);
			return new RedirectView("/teachertakeattendance2");
	}
	
	@PostMapping("/WebTakeAttendance")
	public RedirectView takeAttendance(RedirectAttributes attributes,HttpServletRequest request,int[] studentId,boolean[] status) {
		
		try {
			attendanceServiceImpl.saveAttendance(studentId,status);
			attributes.addFlashAttribute("success", "Attendance Recorded Sucessfully");
			return new RedirectView("/teacherhome");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("failure", "SomeThing Wrong Went");
			return new RedirectView("/teacherhome");
		}
		
	}
	
	@PostMapping("/WebTecaherViewAttendance")
	public RedirectView tecaherViewAttendance(int sectionId,int monthId,int yearId,RedirectAttributes attributes,HttpSession session){
			try {
			List<Object[]> objects=attendanceServiceImpl.getAttendanceBySectionMonthYear(sectionId,monthId,yearId);
			session.setAttribute("students",objects);
			return new RedirectView("teacherviewattendance");
			}catch (Exception e) {
				System.out.println("in catch");
				attributes.addFlashAttribute("failure", "SomeThing Went Wrong");
				return new RedirectView("teacherviewattendance");
			}
	}
	
	
	@PostMapping("/WebViewAttendance")
	public RedirectView viewAttendance(int sectionId,int monthId,int yearId,RedirectAttributes attributes,HttpSession session){
			try {
			List<Object[]> objects=attendanceServiceImpl.getAttendanceBySectionMonthYear(sectionId,monthId,yearId);
			session.setAttribute("students",objects);
			return new RedirectView("viewattendance");
			}catch (Exception e) {
				System.out.println("in catch");
				attributes.addFlashAttribute("failure", "SomeThing Went Wrong");
				return new RedirectView("viewattendance");
			}
	}
}
