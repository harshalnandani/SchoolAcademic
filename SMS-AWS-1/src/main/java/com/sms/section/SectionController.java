package com.sms.section;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.exceptions.SectionAlreadyExistsException;
import com.sms.exceptions.SubjectAlreadyExitsException;

@Controller
public class SectionController {
	
	
	@Autowired
	private SectionServiceImpl sectionServiceImpl;
	
	private int schoolId;
	private int flag;
	
	
	@PostMapping("/WebAddSection")
	public RedirectView addSection(HttpSession session, int  classId, RedirectAttributes attributes, String sectionName) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			sectionServiceImpl.addSection(schoolId, classId,sectionName);
			attributes.addFlashAttribute("success", "Section Sucessfully Added");
			return new RedirectView("/addsection");
		} catch (SectionAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Section Already Exits");
			return new RedirectView("/addsection");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/addsection");
		}

	}
	
	
	@PostMapping("/WebAddSubjectTeacherToSection")
	public RedirectView addSubjectToSection(HttpSession session, RedirectAttributes attributes, int sectionId,
			int[] subjectId, int[] teacherId) {		
		try {
			schoolId = (int) session.getAttribute("schoolId");
			sectionServiceImpl.addSubjectToSection(sectionId, subjectId, teacherId);
			attributes.addFlashAttribute("success", "Subject Sucessfully Added");
			return new RedirectView("/addsubjectteachettosection");
		} catch (SubjectAlreadyExitsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Subject Already Exits");
			return new RedirectView("/addsubjectteachettosection");
		}catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/addsubjectteachettosection");
		}
	}
	
	
	@PostMapping("/WebAddClassTeacher")
	public RedirectView addClassTeacher(HttpSession session, RedirectAttributes attributes, int sectionId,
			int teacherId) {

		schoolId = (int) session.getAttribute("schoolId");
		flag = sectionServiceImpl.addClassTeacher(sectionId, teacherId);
		if (flag < 0) {
			attributes.addFlashAttribute("message", "Class Teacher Already Exits");
			return new RedirectView("/addclassteacher");
		}
		attributes.addFlashAttribute("message", "Class Teacher Sucessfully Added");
		return new RedirectView("/addclassteacher");

	}
	
	@PostMapping("/WebAddStudentToSection")
	public RedirectView addStudentToSection(HttpSession session, RedirectAttributes attributes, int sectionId,
			int studentId) {

		schoolId = (int) session.getAttribute("schoolId");
		flag = sectionServiceImpl.addStudentToSection(sectionId, studentId);
		attributes.addFlashAttribute("message", "Student Sucessfully Added");
		return new RedirectView("/addclassteacher");

	}
	
	@GetMapping("/WebGetSection")
	@ResponseBody
	public void getSectionList(int user_id, ServletResponse response) {
		System.out.println(user_id);
		List<Object[]> sections = sectionServiceImpl.getSectionByClassId(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			out.print("<option disabled selected>Select Section</option>");
			for (Object[] section : sections) {
				out.print("<option value='" + section[0] + "'>");
				out.print(section[1]);
				out.print("</option>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
