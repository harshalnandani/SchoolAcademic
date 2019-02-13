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
import com.sms.attendance.AttendanceServiceImpl;
import com.sms.beans.Assignment;
import com.sms.beans.Student;
import com.sms.eventcalender.EventCalenderServiceImpl;
import com.sms.news.NewsServiceImpl;
import com.sms.notice.NoticeServiceImpl;
import com.sms.questionpaper.QuestionPaperServiceImpl;
import com.sms.student.StudentServiceImpl;
import com.sms.syllabus.SyllabusServiceImpl;
import com.sms.timetable.TimeTableServiceImpl;

@Controller
public class ParentWebPageController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@Autowired
	private NewsServiceImpl newsServiceImpl;
	
	@Autowired
	private NoticeServiceImpl noticeServiceImpl;
	
	@Autowired
	private AssignmentServiceImpl assignmentServiceImpl;
	
	@Autowired
	private EventCalenderServiceImpl eventCalenderServiceImpl;
	
	@Autowired
	private TimeTableServiceImpl timeTableServiceImpl;
	
	@Autowired
	private AttendanceServiceImpl attendanceServiceImpl;
	
	@Autowired
	private SyllabusServiceImpl syllabusServiceImpl;
	
	@Autowired
	private QuestionPaperServiceImpl questionPaperServiceImpl;

	@GetMapping("/parenthome")
	public String parenthome(ServletRequest request, HttpSession session) {
		session.setAttribute("childrens",
				studentServiceImpl.getStudentsByParentId((int) session.getAttribute("parentId")));
		return "/parent/parenthome";
	}

	@GetMapping("/parentstudentproflie")
	public String parentstudentproflie(ServletRequest request, HttpSession session) {
		return "/parent/parentstudentproflie";
	}

	@GetMapping("/parenteditstudentprofile")
	public String parenteditstudentprofile(ServletRequest request, HttpSession session) {
		return "/parent/parenteditstudentprofile";
	}

	@GetMapping("/parentviewhomework")
	public String parentviewhomework(ServletRequest request, HttpSession session) {
		return "/parent/parentviewhomework";
	}
	
	@GetMapping("/parentviewnews")
	public String parentviewnews(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("parentSchoolId");
		request.setAttribute("news", newsServiceImpl.getViewNewsBySchoolId(schoolId));
		return "/parent/parentviewnews";
	}
	
	@GetMapping("/parentviewnotice")
	public String parentviewnotice(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("parentSchoolId");
		Student student =(Student) session.getAttribute("currentstudent");
		int sectionId = student.getSection().getSectionId();
		int classId=student.getSection().getClass1().getClassId();
		request.setAttribute("notices",noticeServiceImpl.getAllNoticeForStudentBySchoolIdAndSectionId(schoolId,classId,sectionId));
		return "/parent/parentviewnotice";
	}
	
	@GetMapping("/parentviewassignment")
	public String parentviewassignment(ServletRequest request, HttpSession session) {
		Student student =(Student) session.getAttribute("currentstudent");
		int sectionId = student.getSection().getSectionId();
		List<Assignment> assignments = assignmentServiceImpl
				.getAssignmentsBySectionId(sectionId);
		request.setAttribute("assignments", assignments);
		return "/parent/parentviewassignment";
	}
	
	@GetMapping("/parentviewacademiccalender")
	public String parentviewacademiccalender(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("parentSchoolId");
		request.setAttribute("eventCalenders", eventCalenderServiceImpl.getViewEventCalenderBySchoolId(schoolId));
		return "/parent/parentviewacademiccalender";
	}
	
	@GetMapping("/parentviewtimetable")
	public String teacherviewclasstimetable(ServletRequest request, HttpSession session) {
		Student student =(Student) session.getAttribute("currentstudent");
		int sectionId = student.getSection().getSectionId();
		int schoolId = (int) session.getAttribute("parentSchoolId");
		session.setAttribute("periods", timeTableServiceImpl.getPeriodsBySchoolId(schoolId));
		session.setAttribute("sectionId", sectionId);
		session.setAttribute("timetableobject", timeTableServiceImpl);
			return "/parent/parentviewtimetable";
	}
	
	
	@GetMapping("/parentviewattendance")
	public String parentviewattendance(ServletRequest request, HttpSession session) {
		Student student =(Student) session.getAttribute("currentstudent");
		request.setAttribute("assignments",attendanceServiceImpl.getAttendanceByStudentIdGroupByMonth(student.getStudentId()));
		return "/parent/parentviewattendance";
	}
	
	@GetMapping("/parentviewsyllabus")
	public String parentviewsyllabus(ServletRequest request, HttpSession session) {
		Student student =(Student) session.getAttribute("currentstudent");
		request.setAttribute("syallubus",syllabusServiceImpl.getSyllabusByClassId(student.getSection().getClass1().getClassId()));
		return "/parent/parentviewsyllabus";
	}
	
	@GetMapping("/teacherviewquestionpaper")
	public String teacherviewquestionpaper(ServletRequest request, HttpSession session) {
		Student student =(Student) session.getAttribute("currentstudent");
		request.setAttribute("questionpapers",questionPaperServiceImpl.getQuestionPaperByClassId(student.getSection().getClass1().getClassId()));
		return "/parent/teacherviewquestionpaper";
	}
	
	
	@ExceptionHandler(Exception.class)
	public RedirectView handleMyException(Exception ex, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute("teacherId") == null || session.getAttribute("teacherSchoolId") == null) {
			attributes.addFlashAttribute("failure", "Session Expired PLease Login Again");
			return new RedirectView("/");
		}
		attributes.addFlashAttribute("failure", "Something Went Wrong");
		return new RedirectView("parenthome");
	}

}
