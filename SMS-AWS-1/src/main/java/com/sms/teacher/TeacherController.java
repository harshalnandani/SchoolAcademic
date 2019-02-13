package com.sms.teacher;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.beans.Teacher;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;
import com.sms.services.MailServiceImpl;
import com.sms.services.MobileSMSServiceImpl;

@Controller
public class TeacherController {

	@Autowired
	private TeacherServiceImpl teacherServiceImpl;

	@Autowired
	private MobileSMSServiceImpl mobileSMSServiceImpl;

	@Autowired
	private MailServiceImpl mailServiceImpl;

	private int schoolId;
	private Teacher teacher;

	@PostMapping("/WebAddTeacher")
	public RedirectView editStudent(Teacher teacher, HttpSession session, Login login, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			teacher.setLogin(login);
			teacher = teacherServiceImpl.addTeacher(teacher, schoolId);
			mailServiceImpl.sendNewRegistrationMail(teacher.getTeacherName(), teacher.getLogin().getEmailId(),
					teacher.getLogin().getMobileNumber(), teacher.getLogin().getUsername(),
					teacher.getLogin().getPassword());
			mobileSMSServiceImpl.sendRegistrationMail(teacher.getTeacherName(), teacher.getLogin().getEmailId(),
					teacher.getLogin().getMobileNumber(), teacher.getLogin().getUsername(),
					teacher.getLogin().getPassword());
			attributes.addFlashAttribute("success", "Teacher Added Sucesfully ");
			return new RedirectView("addteacher");
		} catch (MobileNumberAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Teacher Mobile Number  Already Exits");
			return new RedirectView("addteacher");
		} catch (EmailIdAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Teacher Email Id  Already Exits");
			return new RedirectView("addteacher");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("success", "Teacher Added Sucesfully ");
			return new RedirectView("addteacher");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addteacher");
		}

	}

	@PostMapping("/WebSearchTeacher")
	public RedirectView searchTeacher(String teacherName, HttpSession session, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			List<Teacher> teachers = teacherServiceImpl.searchTeacher(teacherName, schoolId);
			if (teachers.size() > 0) {
				attributes.addFlashAttribute("teachers", teachers);
				return new RedirectView("searchteacher");
			}
			attributes.addFlashAttribute("failure", "No Teacher Found");
			return new RedirectView("searchteacher");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("searchteacher");
		}

	}

	@PostMapping("/WebEditTeacher")
	public RedirectView editTeacher(int actionId, int teacherId, RedirectAttributes attributes, Teacher teacher) {
		try {
			if (actionId == 0) {
				teacher = teacherServiceImpl.getTeacherById(teacherId);
				attributes.addFlashAttribute("teacher", teacher);
				return new RedirectView("editteacher");
			}
			if (actionId == 1) {
				teacher = teacherServiceImpl.editTeacher(teacher);
				attributes.addFlashAttribute("teacher", teacher);
				attributes.addFlashAttribute("success", "Teacher Edited Sucessfully");
				return new RedirectView("editteacher");
			}
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/schoolhome");
		}
		attributes.addFlashAttribute("failure", "Something Went Wrong");
		return new RedirectView("/schoolhome");

	}

	@PostMapping("/WebViewTeacher")
	public RedirectView viewStudent(HttpServletRequest request, int teacherId, int actionId,
			RedirectAttributes attributes) {
		if (actionId == 0) {
			teacher = teacherServiceImpl.getTeacherById(teacherId);
			attributes.addFlashAttribute("teacher", teacher);
			return new RedirectView("viewteacher");
		}
		return null;
	}

	@PostMapping("/WebDeleteTeacher")
	public RedirectView deleteTeacher(HttpServletRequest request, int teacherId, RedirectAttributes attributes) {
		teacherServiceImpl.DeleteById(teacherId);
		return new RedirectView("/searchteacher");
	}

	@PostMapping("/WebEditTeacherProfilePicture")
	public RedirectView editTeacherProfilePicture(HttpServletRequest request, @RequestParam("file") MultipartFile file,
			HttpSession session, RedirectAttributes attributes) {
		int teacherId = (int) session.getAttribute("teacherId");
		try {
			teacherServiceImpl.editTeacherProfilePicture(file, teacherId);
			attributes.addFlashAttribute("success", "Profile Picture Uploaded Sucessfully");
			return new RedirectView("/teacherviewprofile");
		} catch (InvalidFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid File Name");
			return new RedirectView("/teacherviewprofile");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/teacherviewprofile");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/teacherviewprofile");
		}

	}

	@PostMapping("/WebEditTeacherProfile")
	public RedirectView editTeacherProfile(int actionId, int teacherId, RedirectAttributes attributes,
			Teacher teacher) {
		System.out.println(actionId);
		if (actionId == 0) {
			teacher = teacherServiceImpl.getTeacherById(teacherId);
			attributes.addFlashAttribute("teacher", teacher);
			return new RedirectView("teachereditprofile");
		}
		if (actionId == 1) {
			if (teacher.getTeacherId() == 0) {
				attributes.addFlashAttribute("failure", "Something Went Wrong");
				return new RedirectView("/teacherhome");
			}
			teacher = teacherServiceImpl.editTeacher(teacher);
			attributes.addFlashAttribute("teacher", teacher);
			attributes.addFlashAttribute("success", "Teacher Edited Sucessfully");
			return new RedirectView("teachereditprofile");
		}
		attributes.addFlashAttribute("failure", "Something Went Wrong");
		return new RedirectView("/teacherhome");
	}

}
