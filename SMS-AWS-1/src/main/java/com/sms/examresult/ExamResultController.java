package com.sms.examresult;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Exam;
import com.sms.class1.ClassServiceImpl;
import com.sms.exceptions.ExamAlreadyExistsException;
import com.sms.exceptions.ResultNotFoundException;
import com.sms.section.SectionServiceImpl;

@Controller
public class ExamResultController {

	@Autowired
	private ExamResultServiceImpl examResultServiceImpl;

	@Autowired
	private SectionServiceImpl sectionServiceImpl;

	@Autowired
	private ClassServiceImpl classServiceImpl;

	@PostMapping("/WebAddExam")
	public RedirectView addExam(Exam exam, HttpServletRequest request, RedirectAttributes attributes,
			HttpSession session) {
		try {
			int schoolId = (int) session.getAttribute("schoolId");
			examResultServiceImpl.save(exam, schoolId);
			attributes.addFlashAttribute("success", "Exam Added Sucessfully");
			return new RedirectView("addexam");
		} catch (ExamAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Exam Already Exits!!!");
			return new RedirectView("addexam");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addexam");
		}
	}

	@GetMapping("/WebGetSubject")
	@ResponseBody
	public void getSectionList(int user_id, ServletResponse response) {
		System.out.println(user_id);
		List<Object[]> sections = classServiceImpl.getSubjectBySectionId(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("<option disabled selected>Select Section</option>");
			for (Object[] section : sections) {
				out.print("<option value='" + section[0] + "," + section[1] + "'>");
				out.print(section[1]);
				out.print("</option>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostMapping("/WebAddResultFront")
	public RedirectView addResultFront(int sectionId, String[] subjects, int examId, HttpServletRequest request,
			RedirectAttributes attributes, HttpSession session) {

		try {
			List<Object[]> students = sectionServiceImpl.getStudentsBySectionId(sectionId);
			session.setAttribute("students", students);
			List<Integer> subjectId = new ArrayList<>();
			List<String> subjectName = new ArrayList<>();
			String[] companies = null;
			for (String objects : subjects) {
				companies = objects.split(",");
				subjectId.add(Integer.parseInt(companies[0]));
				subjectName.add(companies[1]);
			}
			session.setAttribute("subjectsName", subjectName);
			session.setAttribute("subjectsId", subjectId);
			session.setAttribute("examId", examId);
			return new RedirectView("addresult");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addresultfront");
		}

	}

	@PostMapping("/WebAddResult")
	public RedirectView addResult(int[] marks, HttpServletRequest request, RedirectAttributes attributes,
			HttpSession session) {

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> students = (List<Object[]>) session.getAttribute("students");
			@SuppressWarnings("unchecked")
			List<Integer> subjectId = (List<Integer>) session.getAttribute("subjectsId");
			int examId = (int) session.getAttribute("examId");
			examResultServiceImpl.addResult(marks, subjectId, students, examId);
			attributes.addFlashAttribute("success", "Exam Added Sucessfully");
			return new RedirectView("addresultfront");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addresultfront");
		}
	}

	@PostMapping("/WebViewResult")
	public RedirectView viewResult(int sectionId, int examId, HttpServletRequest request, RedirectAttributes attributes,
			HttpSession session) {

		try {
			List<String> subjects = examResultServiceImpl.getDISTINCTSubjectByExamId(examId);
			List<Object[]> results = examResultServiceImpl.getResultByExamAndSectionId(sectionId, examId);
			session.setAttribute("subjects", subjects);
			session.setAttribute("results", results);
			return new RedirectView("viewresult");
		} catch (ResultNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "No Result Found");
			return new RedirectView("viewresult");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("viewresult");
		}

	}

	@PostMapping("/WebTeacherAddResultFront")
	public RedirectView teacherAddResultFront(int sectionId, String[] subjects, int examId, HttpServletRequest request,
			RedirectAttributes attributes, HttpSession session) {
		
		try {
			List<Object[]> students = sectionServiceImpl.getStudentsBySectionId(sectionId);
			session.setAttribute("students", students);
			List<Integer> subjectId = new ArrayList<>();
			List<String> subjectName = new ArrayList<>();
			String[] companies = null;
			for (String objects : subjects) {
				System.out.println(objects);
				companies = objects.split(",");
				System.out.println(companies.length);
				subjectId.add(Integer.parseInt(companies[0]));
				subjectName.add(companies[1]);
			}
			session.setAttribute("subjectsName", subjectName);
			session.setAttribute("subjectsId", subjectId);
			session.setAttribute("examId", examId);
			return new RedirectView("teacheraddresult");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("teacheraddresultfront");
		}
		
		
	}
	
	@PostMapping("/WebTeacherAddResult")
	public RedirectView teacherAddResult(int[] marks, HttpServletRequest request, RedirectAttributes attributes,
			HttpSession session) {

		try {
			@SuppressWarnings("unchecked")
			List<Object[]> students = (List<Object[]>) session.getAttribute("students");
			@SuppressWarnings("unchecked")
			List<Integer> subjectId = (List<Integer>) session.getAttribute("subjectsId");
			int examId = (int) session.getAttribute("examId");
			examResultServiceImpl.addResult(marks, subjectId, students, examId);
			attributes.addFlashAttribute("success", "Result Added Sucessfully");
			return new RedirectView("teacheraddresultfront");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("teacheraddresultfront");
		}
	}
	
	
	@PostMapping("/WebTeacherViewResult")
	public RedirectView teacherViewResult(int sectionId, int examId, HttpServletRequest request, RedirectAttributes attributes,
			HttpSession session) {
		try {
			List<String> subjects = examResultServiceImpl.getDISTINCTSubjectByExamId(examId);
			List<Object[]> results = examResultServiceImpl.getResultByExamAndSectionId(sectionId, examId);
			session.setAttribute("subjects", subjects);
			session.setAttribute("results", results);
			return new RedirectView("teacherviewresult");
		} catch (ResultNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "No Result Found");
			return new RedirectView("teacherviewresult");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("teacherviewresult");
		}

	}

}
