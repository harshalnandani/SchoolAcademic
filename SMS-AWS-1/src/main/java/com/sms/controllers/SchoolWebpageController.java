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

import com.sms.admission.AdmissionServiceImpl;
import com.sms.beans.Class;
import com.sms.beans.School;
import com.sms.beans.Student;
import com.sms.beans.Teacher;
import com.sms.class1.ClassServiceImpl;
import com.sms.eventcalender.EventCalenderServiceImpl;
import com.sms.examresult.ExamResultServiceImpl;
import com.sms.news.NewsServiceImpl;
import com.sms.notice.NoticeServiceImpl;
import com.sms.school.SchoolServiceImpl;
import com.sms.section.SectionServiceImpl;
import com.sms.student.StudentServiceImpl;
import com.sms.subject.SubjectServiceImpl;
import com.sms.teacher.TeacherServiceImpl;
import com.sms.timetable.TimeTableServiceImpl;

@Controller
public class SchoolWebpageController {

	@Autowired
	private SchoolServiceImpl serviceImpl;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@Autowired
	private TeacherServiceImpl teacherServiceImpl;

	@Autowired
	private ClassServiceImpl classSectionSubjectServiceImpl;

	@Autowired
	private SectionServiceImpl sectionServiceImpl;

	@Autowired
	private SubjectServiceImpl subjectServiceImpl;

	@Autowired
	private EventCalenderServiceImpl eventCalenderServiceImpl;

	@Autowired
	private TimeTableServiceImpl timeTableServiceImpl;

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;

	@Autowired
	private NewsServiceImpl newsServiceImpl;

	@Autowired
	private AdmissionServiceImpl admissionServiceImpl;

	@Autowired
	private ExamResultServiceImpl examResultServiceImpl;
	
	@Autowired
	private NoticeServiceImpl noticeServiceImpl;

	private School school;

	private int schoolId;

	@GetMapping("/schoolhome")
	public String schoolhome() {
		return "/school/schoolhome";
	}

	@GetMapping("/admissionenquiryform")
	public String admissionenquiryform() {
		return "/school/admissionenquiryform";
	}

	@GetMapping("/sendadmissionenquirylink")
	public String sendadmissionenquirylink() {
		return "/school/sendadmissionenquirylink";
	}

	@GetMapping("/listadmissionenquiry")
	public String listadmissionenquiry(HttpSession session, HttpServletRequest request) {
			schoolId = (int) session.getAttribute("schoolId");
			List<Object[]> enquiryForms = admissionServiceImpl.getenquiryFormList(schoolId);
			request.setAttribute("enquiryForms", enquiryForms);
			return "/school/listadmissionenquiry";
	}

	@GetMapping("/studentlist")
	public String studentList(HttpServletRequest request, HttpSession session) {
		schoolId = (int) session.getAttribute("schoolId");
		List<Student> students = studentServiceImpl.getStudentBySchoolId(schoolId);
		request.setAttribute("students", students);
		return "/school/studentlist";
	}

	@GetMapping("/addstudent")
	public String addstudent(HttpServletRequest request, HttpSession session) {
		schoolId = (int) session.getAttribute("schoolId");
		List<Class> classes = classSectionSubjectServiceImpl.getClassBySchoolId(schoolId);
		request.setAttribute("classes", classes);
		return "/school/addstudent";
	}

	@GetMapping("/editstudent")
	public String editStudent(HttpServletRequest request) {
		return "/school/editstudent";
	}

	@GetMapping("/searchstudent")
	public String searchstudent() {
		return "/school/searchstudent";
	}

	@GetMapping("/addteacher")
	public String addteacher() {
		return "/school/addteacher";
	}

	@GetMapping("/teacherlist")
	public String teacherlist(HttpServletRequest request, HttpSession session) {
		schoolId = (int) session.getAttribute("schoolId");
		List<Teacher> teachers = serviceImpl.getSchoolById(schoolId).getTeachers();
		request.setAttribute("teachers", teachers);
		return "/school/teacherlist";
	}

	@GetMapping("/editteacher")
	public String editteacher() {
		return "/school/editteacher";
	}

	@GetMapping("/searchteacher")
	public String searchteacher() {
		return "/school//searchteacher";
	}

	@GetMapping("/addclass")
	public String addclass(HttpSession session, HttpServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/school/addclass";
	}

	@GetMapping("/addsection")
	public String addsection(HttpSession session, HttpServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		List<Object[]> classes = classSectionSubjectServiceImpl.getClassAndId(schoolId);
		request.setAttribute("classes", classes);
		request.setAttribute("sections", sectionServiceImpl.getSectionNameAndIdBySchoolId(schoolId));
		return "/school/addsection";
	}

	@GetMapping("/addsubject")
	public String addsubject(HttpSession session, HttpServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		return "/school/addsubject";
	}

	@GetMapping("/addsubjectteachettosection")
	public String addsubjectteachettosection(HttpSession session, HttpServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		request.setAttribute("teachers", teacherServiceImpl.getTeacherAndId(schoolId));
		request.setAttribute("subjectteachermapping", sectionServiceImpl.getSubjectTeacherMappingBySchoolId(schoolId));
		return "/school/addsubjectteachettosection";
	}

	@GetMapping("/addnews")
	public String addnews() {
		return "/school/addnews";
	}

	@GetMapping("/listnews")
	public String viewNews(HttpSession session, HttpServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("news", newsServiceImpl.getViewNewsBySchoolId(schoolId));
		return "/school/listnews";
	}

	@GetMapping("/editnews")
	public String editNews() {
		return "/school/editnews";
	}

	@GetMapping("/addquestionpaper")
	public String addquestionpaper(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		return "/school/addquestionpaper";
	}

	@GetMapping("/listquestionpaper")
	public String viewquestionpaper(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		school = serviceImpl.getSchoolById(schoolId);
		request.setAttribute("classes", school.getClasses());
		return "/school/listquestionpaper";
	}

	@GetMapping("/addeventcalender")
	public String addeventcalender() {
		return "/school/addeventcalender";
	}

	@GetMapping("/listeventcalender")
	public String vieweventcalender(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("eventCalenders", eventCalenderServiceImpl.getViewEventCalenderBySchoolId(schoolId));
		return "/school/listeventcalender";
	}

	@GetMapping("/addsyllabus")
	public String addsyllabus(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		return "/school/addsyllabus";
	}

	@GetMapping("/listsyllabus")
	public String listSyllabus(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		school = serviceImpl.getSchoolById(schoolId);
		request.setAttribute("classes", school.getClasses());
		return "/school/listsyllabus";
	}

	@GetMapping("/addexamtimetable")
	public String addexamtimetable(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		request.setAttribute("exams", examResultServiceImpl.getExamsBySchoolId(schoolId));
		return "/school/addexamtimetable";
	}

	@GetMapping("/listexamtimetable")
	public String listexamtimetable(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		school = serviceImpl.getSchoolById(schoolId);
		request.setAttribute("classes", school.getClasses());
		return "/school/listexamtimetable";
	}

	@GetMapping("/sendnotice")
	public String sendnotice(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/school/sendnotice";
	}

	@GetMapping("/listclass")
	public String listclass(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/school/listclass";
	}

	@GetMapping("/viewclass")
	public String viewclass(ServletRequest request, int classId) {
		request.setAttribute("class1", classSectionSubjectServiceImpl.getClassById(classId));
		return "/school/viewclass";
	}

	@GetMapping("/listsection")
	public String listsection(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("sections", sectionServiceImpl.getSectionNameAndIdBySchoolId(schoolId));
		return "/school/listsection";
	}

	@GetMapping("/viewsection")
	public String viewsection(ServletRequest request, int sectionId,HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("sections", sectionServiceImpl.getSectionById(sectionId));
		session.setAttribute("periods", timeTableServiceImpl.getPeriodsBySchoolId(schoolId));
		session.setAttribute("timetableobject", timeTableServiceImpl);
		return "/school/viewsection";
	}

	@GetMapping("/listsubject")
	public String listsubject(HttpSession session, ServletRequest request) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		return "/school/listsubject";
	}

	@GetMapping("/viewsubject")
	public String viewsubject(ServletRequest request, int subjectId) {
		request.setAttribute("subject", subjectServiceImpl.getSubjectById(subjectId));
		return "/school/viewsubject";
	}

	@GetMapping("/addperiod")
	public String addperiod(ServletRequest request) {
		return "/school/addperiod";
	}

	@GetMapping("/listperiod")
	public String listperiod(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("periods", timeTableServiceImpl.getPeriodsBySchoolId(schoolId));
		return "/school/listperiod";
	}

	@GetMapping("/editperiod")
	public String editperiod(ServletRequest request, HttpSession session) {
		return "/school/editperiod";
	}

	@GetMapping("/addtimetable")
	public String addtimetable(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/school/addtimetable";
	}

	@GetMapping("/addperiodsubjectmapping")
	public String addperiodsubjectmapping(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("subjects", subjectServiceImpl.getSubjectAndId(schoolId));
		request.setAttribute("periods", timeTableServiceImpl.getPeriodsBySchoolId(schoolId));
		return "/school/addperiodsubjectmapping";
	}

	@GetMapping("/viewtimetable")
	public String viewtimetable(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/school/viewtimetable";
	}

	@GetMapping("/viewtimetablefront")
	public String viewtimetablefront(ServletRequest request, HttpSession session) {
		return "/school/viewtimetablefront";
	}

	@GetMapping("/addexam")
	public String addexam() {
		return "/school/addexam";
	}

	@GetMapping("/addresultfront")
	public String addresultfront(HttpSession session, ServletRequest request) {
		schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("exams", examResultServiceImpl.getExamsBySchoolId(schoolId));
		return "/school/addresultfront";
	}

	@GetMapping("/addresult")
	public String addresult(HttpSession session, ServletRequest request) {
		return "/school/addresult";
	}

	@GetMapping("/viewresult")
	public String viewresult(HttpSession session, ServletRequest request) {
		schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		request.setAttribute("exams", examResultServiceImpl.getExamsBySchoolId(schoolId));
		return "/school/viewresult";
	}

	@GetMapping("/schoolprofile")
	public String schoolprofile(ServletRequest request, HttpSession session) {
		schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("schooldata", schoolServiceImpl.getSchoolById(schoolId));
		return "/school/schoolprofile";
	}

	@GetMapping("/schooleditschool")
	public String editschool(ServletRequest request, HttpSession session) {
		schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("schooldata", schoolServiceImpl.getSchoolById(schoolId));
		return "/school/editschool";
	}

	@ExceptionHandler(Exception.class)
	public RedirectView handleMyException(Exception ex, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute("schoolId") == null) {
			attributes.addFlashAttribute("failure", "Session Expired PLease Login Again");
			return new RedirectView("/");
		}
		attributes.addFlashAttribute("failure", "Something Went Wrong");
		return new RedirectView("schoolhome");
	}
	
	@GetMapping("/listexam")
	public String listexam(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("exams",examResultServiceImpl.getExamsBySchoolId(schoolId));
		return "/school/listexam";
	}
	
	@GetMapping("/listnotice")
	public String listnotice(ServletRequest request, HttpSession session) {
		int schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("notices",noticeServiceImpl.getAllNoticeForSchoolBySchoolId(schoolId));
		return "/school/listnotice";
	}
	
	@GetMapping("/viewattendance")
	public String viewattendance(HttpSession session, ServletRequest request) {
		schoolId = (int) session.getAttribute("schoolId");
		request.setAttribute("classes", classSectionSubjectServiceImpl.getClassAndId(schoolId));
		return "/school/viewattendance";
	}

}
