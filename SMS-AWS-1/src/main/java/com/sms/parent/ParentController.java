package com.sms.parent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Parent;
import com.sms.beans.Student;
import com.sms.student.StudentServiceImpl;

@Controller
public class ParentController {

	@Autowired
	private ParentServiceImpl parentServiceImpl;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	Student student;

	@PostMapping("/WebEditParent")
	public RedirectView editParent(Parent parent, int studentId, int actionId, HttpServletRequest request,
			RedirectAttributes attributes) {

		try {
			if (actionId == 1) {
				parentServiceImpl.editParent(parent);
				student = studentServiceImpl.getStudentById(studentId);
				attributes.addFlashAttribute("editstudent", student);
				attributes.addFlashAttribute("success", "Parent Edited Sucessfully");
				return new RedirectView("editstudent");
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("editstudent");
		}
		return new RedirectView("editstudent");

	}

	@PostMapping("/WebEditParentProfile")
	public RedirectView WebEditParentProfile(Parent parent, int studentId, HttpServletRequest request,
			RedirectAttributes attributes, HttpSession session) {

		try {
			parent = parentServiceImpl.editParent(parent);
			session.setAttribute("currentstudent", studentServiceImpl.getStudentById(studentId));
			attributes.addFlashAttribute("success", "Parent Edited Sucessfully");
			return new RedirectView("editstudent");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("editstudent");
		}

	}

	@PostMapping("/WebParentSelectStudent")
	public RedirectView parentSelectStudent(int studentId, HttpSession session, RedirectAttributes attributes) {
		try {
			student = studentServiceImpl.getStudentById(studentId);
			session.setAttribute("currentstudent", student);
			return new RedirectView("parentstudentproflie");
		} catch (Exception e) {
			return new RedirectView("parenthome");
		}

	}

}
