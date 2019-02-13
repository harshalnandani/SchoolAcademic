package com.sms.admission;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.AdmissionEnquiryForm;
import com.sms.services.MailServiceImpl;

@Controller
public class AdmissionController {
	
	
	@Autowired
	private AdmissionServiceImpl admissionServiceImpl;
	
	@Autowired
	private MailServiceImpl mailService;
	
	private int schoolId;
	
	@PostMapping("/WebAddAdmission")
	public RedirectView addAdmission(AdmissionEnquiryForm admission, ServletRequest request, HttpSession session, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			admissionServiceImpl.saveAdmission(admission, schoolId);
			attributes.addFlashAttribute("success", "Admission Added Sucessfully");
			return new RedirectView("addadmission");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addadmission");
		}
	}
	
	
	@PostMapping("/WebSendAdmissionLink")
	public RedirectView sendAdmissionLink(String emailId,String mobileNumber, ServletRequest request, HttpSession session, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			mailService.sendAdmissionEnquiryMail(schoolId,emailId);
			attributes.addFlashAttribute("success", "Admission Added Sucessfully");
			return new RedirectView("addadmission");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addadmission");
		}
	}
	
	
	@PostMapping("/WebAddAdmissionByLink")
	public RedirectView addAdmissionByLink(AdmissionEnquiryForm admission,int schoolId,ServletRequest request, HttpSession session, RedirectAttributes attributes) {

		try {
			admissionServiceImpl.saveAdmission(admission, schoolId);
			attributes.addFlashAttribute("success", "Admission Added Sucessfully");
			return new RedirectView("admissionenquiryformbylink");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("admissionenquiryformbylink");
		}
	}

}
