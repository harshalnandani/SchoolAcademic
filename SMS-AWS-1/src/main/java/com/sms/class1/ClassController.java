package com.sms.class1;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.exceptions.ClassAlreadyExistsException;

@Controller
public class ClassController {

	@Autowired
	private ClassServiceImpl classSectionServiceImpl;

	private int schoolId;
	

	@PostMapping("/WebAddClass")
	public RedirectView addClass(HttpSession session, String className,String[] sectionName,RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			classSectionServiceImpl.addClass(schoolId, className,sectionName);
			attributes.addFlashAttribute("success", "Class Sucessfully Added");
			return new RedirectView("/addclass");
		} catch (ClassAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Class Already Exits");
			return new RedirectView("/addclass");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/addclass");
		}

	}

	

	

	

	

	

}
