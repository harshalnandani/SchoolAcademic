package com.sms.subject;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Subject;
import com.sms.exceptions.SubjectAlreadyExistsException;

@Controller
public class SubjectController {
	
	@Autowired
	private SubjectServiceImpl subjectServiceImpl;
	int schoolId,flag;
	
	@PostMapping("/WebAddSubject")
	public RedirectView addSubject(HttpSession session,String[] subjectName, RedirectAttributes attributes) {
		
		try {
			schoolId = (int) session.getAttribute("schoolId");
			subjectServiceImpl.addSubject(schoolId,subjectName);
			attributes.addFlashAttribute("success", "Subject Sucessfully Added");
			return new RedirectView("/addsubject");
		} catch (SubjectAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Subject Already Exits");
			return new RedirectView("/addsubject");
		}catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something went Wrong");
			return new RedirectView("/addsubject");
		}
		
		
	}

}
