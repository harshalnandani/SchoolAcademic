package com.sms.school;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.beans.School;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;
import com.sms.services.MailServiceImpl;
import com.sms.services.MobileSMSServiceImpl;

@Controller
public class SchoolController {

	@Autowired
	private SchoolServiceImpl serviceImpl;
	
	@Autowired
	private MobileSMSServiceImpl mobileSMSServiceImpl;

	@Autowired
	private MailServiceImpl mailServiceImpl;

	private int schoolId;

	@PostMapping("/WebAddSchool")
	public RedirectView addSchool(School school, RedirectAttributes attributes, Login login) {

		try {
			login.setSchool(school);
			login.setUser("school");
			school.setLogin(login);
			school=serviceImpl.addSchool(school);
			mailServiceImpl.sendNewRegistrationMail(school.getSchoolName(),school.getLogin().getEmailId(),school.getLogin().getMobileNumber(), school.getLogin().getUsername(),school.getLogin().getPassword());
			mobileSMSServiceImpl.sendRegistrationMail(school.getSchoolName(),school.getLogin().getEmailId(),school.getLogin().getMobileNumber(), school.getLogin().getUsername(),school.getLogin().getPassword());
			attributes.addFlashAttribute("success", "School Registered Sucessfully");
			return new RedirectView("/addschool");
		} catch (MobileNumberAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Mobile Number Already Exits");
			return new RedirectView("/addschool");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("success", "School Registered Sucessfully");
			return new RedirectView("/addschool");
		} catch (EmailIdAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Email Id Already Exits");
			return new RedirectView("/addschool");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/addschool");
		}

	}

	@PostMapping("/WebEditSchool")
	public RedirectView editSchool(School school, RedirectAttributes attributes) {
		try {
			school = serviceImpl.editSchool(school);
			attributes.addFlashAttribute("success", "School Edited Sucessfully");
			return new RedirectView("editschool?schoolId=" + school.getSchoolId() + "");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("editschool?schoolId=" + school.getSchoolId() + "");
		}

	}
	
	@PostMapping("/WebSchoolEditSchool")
	public RedirectView schoolEditSchool(School school, RedirectAttributes attributes,HttpSession session) {
		try {
			schoolId = (int) session.getAttribute("schoolId");
			school = serviceImpl.editSchool(school);
			session.setAttribute("schooldisplaydata",serviceImpl.getSchoolById(schoolId));
			attributes.addFlashAttribute("success", "School Edited Sucessfully");
			return new RedirectView("schooleditschool");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("schooleditschool");
		}

	}

	@PostMapping("/WebSchoolUploadLogo")
	public RedirectView schoolUploadLogo(@RequestPart(value = "file") MultipartFile file, ServletResponse response,
			HttpSession session, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			serviceImpl.uploadLogo(schoolId, file);
			session.setAttribute("schooldisplaydata",serviceImpl.getSchoolById(schoolId));
			attributes.addFlashAttribute("success", "News Edited Sucessfully");
			return new RedirectView("schoolprofile");
		} catch (IOException e) {
			System.out.println(e);
			attributes.addFlashAttribute("failure", "SomeThing Went Wrong");
			return new RedirectView("schoolprofile");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("failure", "SomeThing Went Wrong");
			return new RedirectView("schoolprofile");
		}
		

	}
	
	@PostMapping("/WebSchoolUploadBanner")
	public RedirectView schoolUploadBanner(@RequestPart(value = "file") MultipartFile file, ServletResponse response,
			HttpSession session, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			serviceImpl.uploadBanner(schoolId, file);
			session.setAttribute("schooldisplaydata",serviceImpl.getSchoolById(schoolId));
			attributes.addFlashAttribute("success", "News Edited Sucessfully");
			return new RedirectView("schoolprofile");
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "SomeThing Went Wrong");
			return new RedirectView("schoolprofile");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("failure", "SomeThing Went Wrong");
			return new RedirectView("schoolprofile");
		}
		

	}
}
