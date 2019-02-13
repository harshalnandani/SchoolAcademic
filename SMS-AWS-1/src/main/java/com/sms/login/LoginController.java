package com.sms.login;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.exceptions.InvalidAdminLoginException;
import com.sms.exceptions.InvalidLoginException;
import com.sms.school.SchoolServiceImpl;

@Controller
public class LoginController {

	@Autowired
	private LoginServiceImpl loginSericeImpl;
	
	@Autowired 
	private SchoolServiceImpl schoolServiceImpl;

	private Login login;

	@PostMapping("/WebLogin")
	public RedirectView schoolLogin(String username, String password, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {
		try {
			login = loginSericeImpl.login(username, password);
			if (login.getUser().equals("school")) {
				session.setAttribute("schoolId", login.getSchool().getSchoolId());
				session.setAttribute("schooldisplaydata",schoolServiceImpl.getSchoolById(login.getSchool().getSchoolId()));
				session.setAttribute("user",login.getUser());
				return new RedirectView("schoolhome");
			} else if (login.getUser().equals("teacher")) {
				session.setAttribute("teacherId", login.getTeacher().getTeacherId());
				session.setAttribute("teacherSchoolId", login.getTeacher().getSchool().getSchoolId());
				session.setAttribute("schooldisplaydata",schoolServiceImpl.getSchoolById(login.getTeacher().getSchool().getSchoolId()));
				session.setAttribute("user",login.getUser());
				return new RedirectView("teacherhome");
			} else {
				session.setAttribute("parentSchoolId", login.getParent().getStudents().get(0).getSchool().getSchoolId());
				session.setAttribute("schooldisplaydata",schoolServiceImpl.getSchoolById(login.getParent().getStudents().get(0).getSchool().getSchoolId()));
				session.setAttribute("parentId", login.getParent().getParentId());
				session.setAttribute("user",login.getUser());
				return new RedirectView("parenthome");
			}
		} catch (InvalidLoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid Credentials");
			return new RedirectView("/");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/");
		}
	}

	@PostMapping("/WebAdminlLogin")
	public RedirectView adminLogin(String emailId, String password, HttpSession session,
			RedirectAttributes attributes) {
		try {
			loginSericeImpl.adminLogin(emailId, password);
			session.setAttribute("adminlogin", "success");
			return new RedirectView("adminhome");
		} catch (InvalidAdminLoginException e) {
			attributes.addFlashAttribute("failure", "Invalid Email Id or Password");
			return new RedirectView("adminlogin");
		} catch (Exception e) {
			System.out.println(e);
			attributes.addFlashAttribute("failure", "Something Went Wrong!!!");
			return new RedirectView("adminlogin");
		}
	}

	@GetMapping("/WebAdminLogout")
	public RedirectView webAdminLogout(String emailId, String password, HttpSession session,
			RedirectAttributes attributes) {

		try {
			session.removeAttribute("adminlogin");
			attributes.addFlashAttribute("failure", "You Have Been Logged Out");
			return new RedirectView("adminlogin");
		} catch (Exception e) {
			session.removeAttribute("adminlogin");
			attributes.addFlashAttribute("failure", "You Have Been Logged Out");
			return new RedirectView("adminlogin");
		}

	}
	
	@GetMapping("/WebLogout")
	public RedirectView WebLogout(String emailId, String password, HttpSession session,
			RedirectAttributes attributes) {

		try {
			if (session.getAttribute("user") != null) {
				if (session.getAttribute("user").equals("school")) {
					session.removeAttribute("schoolId");
					session.removeAttribute("schooldisplaydata");
					session.removeAttribute("user");
					attributes.addFlashAttribute("failure", "You Have Been Logged Out");
					return new RedirectView("/");
				}else if(session.getAttribute("user").equals("teacher")) {
					session.removeAttribute("teacherId");
					session.removeAttribute("teacherSchoolId");
					session.removeAttribute("schooldisplaydata");
					session.removeAttribute("user");
					attributes.addFlashAttribute("failure", "You Have Been Logged Out");
					return new RedirectView("/");
				}else if(session.getAttribute("user").equals("parent")) {
					session.removeAttribute("parentId");
					session.removeAttribute("parentSchoolId");
					session.removeAttribute("schooldisplaydata");
					session.removeAttribute("user");
					session.removeAttribute("currentstudent");
					attributes.addFlashAttribute("failure", "You Have Been Logged Out");
					return new RedirectView("/");
				}
			} else {
				attributes.addFlashAttribute("failure", "Session Expired PLease Login Again");
				return new RedirectView("/");
			}
			return new RedirectView("/");
		
		} catch (Exception e) {
			session.removeAttribute("/");
			attributes.addFlashAttribute("failure", "You Have Been Logged Out");
			return new RedirectView("/");
		}

	}

}
