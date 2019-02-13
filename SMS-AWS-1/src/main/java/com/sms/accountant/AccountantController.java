package com.sms.accountant;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.beans.Parent;
import com.sms.beans.Student;

@Controller
public class AccountantController {
	
	@PostMapping("WebAddAccountant")
	public RedirectView saveStudent(Student student, Login login, Parent parent, Boolean question, int sectionId,
			HttpSession session, RedirectAttributes attributes) {
		
		try {
			attributes.addFlashAttribute("success", "Student Added Sucessfully");
			return new RedirectView("addstudent");
		} catch (Exception e) {
			// TODO: handle exception
			attributes.addFlashAttribute("success", "Student Added Sucessfully");
			return new RedirectView("addstudent");
		}
		
	}

}
