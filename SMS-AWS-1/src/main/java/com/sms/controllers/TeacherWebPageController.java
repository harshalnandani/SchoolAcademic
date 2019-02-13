package com.sms.controllers;

import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.assignment.AssignmentServiceImpl;
import com.sms.beans.Assignment;
import com.sms.beans.Teacher;
import com.sms.class1.ClassServiceImpl;
import com.sms.eventcalender.EventCalenderServiceImpl;
import com.sms.examresult.ExamResultServiceImpl;
import com.sms.news.NewsServiceImpl;
import com.sms.notice.NoticeServiceImpl;
import com.sms.subject.SubjectServiceImpl;
import com.sms.teacher.TeacherServiceImpl;
import com.sms.timetable.TimeTableServiceImpl;

@Controller
public class TeacherWebPageController {
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;

	@Autowired
	private ClassServiceImpl classSectionSubjectServiceImpl;

	@Autowired
	private SubjectServiceImpl subjectServiceImpl;

	@Autowired
	private TimeTableServiceImpl timeTableServiceImpl;

	@Autowired
	private AssignmentServiceImpl assignmentServiceImpl;

	@Autowired
	private NewsServiceImpl newsServiceImpl;
	
	@Autowired
	private EventCalenderServiceImpl eventCalenderServiceImpl;
	
	@Autowired
	private ExamResultServiceImpl examResultServiceImpl;
	
	@Autowired
	private NoticeServiceImpl noticeServiceImpl;

	private Teacher teacher;
	
	@GetMapping("/teacherhome")
	public String teacherhome(ServletRequest request, HttpSession session) {
		return "/teacher/teacherhome";
	}

	@GetMapping("/teachertakeattendance1")
	public String teachertakeattendance1(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/teacher/teachertakeattendance1";
	}

	@GetMapping("/teachertakeattendance2")
	public String teachertakeattendance2(ServletRequest request, HttpSession session) {
		return "/teacher/teachertakeattendance2";
	}

	@GetMapping("/teacherhomework")
	public String teacherhomework(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		return "/teacher/teacherhomework";
	}

	@GetMapping("/teacheraddassignment")
	public String teacheraddassignment(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		return "/teacher/teacheraddassignment";
	}

	@GetMapping("/teacherviewprofile")
	public String teacherviewprofile(ServletRequest request, HttpSession session) {
		teacher = teacherServiceImpl.getTeacherById((int) session.getAttribute("teacherId"));
		request.setAttribute("teacher", teacher);
		return "/teacher/teacherviewprofile";
	}

	@GetMapping("/teachereditprofile")
	public String teachereditprofile() {
		return "/teacher/teachereditprofile";
	}

	@GetMapping("/teacherviewhomework")
	public String teacherviewhomework() {
		return "/teacher/teacherviewhomework";
	}

	@GetMapping("/teacherviewassignment")
	public String teacherviewassignment(ServletRequest request, HttpSession session) {
		List<Assignment> assignments = assignmentServiceImpl
				.getAssignmentsByTeacherId((int) session.getAttribute("teacherId"));
		request.setAttribute("assignments", assignments);
		return "/teacher/teacherviewassignment";
	}

	@GetMapping("/teacherviewnews")
	public String teacherviewnews(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("news", newsServiceImpl.getViewNewsBySchoolId(schoolId));
		return "/teacher/teacherviewnews";
	}

	@GetMapping("/teacherviewowntimetable")
	public String teacherviewowntimetable(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		session.setAttribute("periods", timeTableServiceImpl.getPeriodsBySchoolId(schoolId));
		session.setAttribute("timetableobject", timeTableServiceImpl);
		return "/teacher/teacherviewowntimetable";
	}

	@GetMapping("/teacherviewattendance")
	public String teacherviewattendance(ServletRequest request, HttpSession session) {

		try {
			int schoolId = (int) session.getAttribute("teacherSchoolId");
			request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
			return "/teacher/teacherviewattendance";
		} catch (Exception e) {
			return "/teacher/teacherviewattendance";
		}
	}
	
	
	@GetMapping("/teacherviewclasstimetable")
	public String teacherviewclasstimetable(ServletRequest request, HttpSession session) {

		try {
			int schoolId = (int) session.getAttribute("teacherSchoolId");
			request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
			return "/teacher/teacherviewclasstimetable";
		} catch (Exception e) {
			return "/teacher/teacherviewclasstimetable";
		}
	}
	
	@GetMapping("/teacherviewacademiccalender")
	public String teacherviewacademiccalender(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("eventCalenders", eventCalenderServiceImpl.getViewEventCalenderBySchoolId(schoolId));
		return "/teacher/teacherviewacademiccalender";
	}
	
	@GetMapping("/teacheraddresultfront")
	public String teacheraddresultfront(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("exams", examResultServiceImpl.getExamsBySchoolId(schoolId));
		return "/teacher/teacheraddresultfront";
	}
	
	@GetMapping("/teacheraddresult")
	public String addresult(HttpSession session, ServletRequest request) {
		return "/teacher/teacheraddresult";
	}
	
	@GetMapping("/teacherviewresult")
	public String teacherviewresult(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		System.out.println(schoolId);
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("exams", examResultServiceImpl.getExamsBySchoolId(schoolId));
		return "/teacher/teacherviewresult";
	}
	
	@GetMapping("/teacherviewnotice")
	public String teacherviewnotice(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("teacherSchoolId");
		request.setAttribute("notices",noticeServiceImpl.getAllNoticeForTeacherBySchoolId(schoolId));
		return "/teacher/teacherviewnotice";
	}
	
	@ExceptionHandler(Exception.class)
	public RedirectView handleMyException(Exception ex, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute("teacherId") == null || session.getAttribute("teacherSchoolId") == null) {
			attributes.addFlashAttribute("failure", "Session Expired PLease Login Again");
			return new RedirectView("/");
		}
		attributes.addFlashAttribute("failure", "Something Went Wrong");
		return new RedirectView("teacherhome");
	}

}
