package com.sms.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Class;
import com.sms.beans.Login;
import com.sms.beans.Parent;
import com.sms.beans.School;
import com.sms.beans.Student;
import com.sms.beans.StudentRegistration;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.InvalidParentEmailIdOrMobileNumberException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.MailServiceImpl;
import com.sms.services.MobileSMSServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	@Autowired
	private MobileSMSServiceImpl mobileSMSServiceImpl;

	@Autowired
	private MailServiceImpl mailServiceImpl;
	
	private int flag;
	private Parent parent;
	private int schoolId;
	private Student student1;
	private School school;
	private StudentRegistration studentRegistration;
	private Student student;
	private Login login1;

	@PostMapping("WebAddStudent")
	public RedirectView saveStudent(Student student, Login login, Parent parent, Boolean question, int sectionId,
			HttpSession session, RedirectAttributes attributes) {

		try {
			schoolId = (int) session.getAttribute("schoolId");
			parent.setLogin(login);
			login1 = new Login();
			student.setLogin(login1);
			student=studentServiceImpl.addStudent(student, parent, schoolId, question, sectionId);
			mailServiceImpl.sendNewRegistrationMail(student.getParent().getFathersName(),student.getParent().getLogin().getEmailId(),student.getParent().getLogin().getMobileNumber(),student.getParent().getLogin().getUsername(),student.getParent().getLogin().getPassword());
			mobileSMSServiceImpl.sendRegistrationMail(student.getParent().getFathersName(),student.getParent().getLogin().getEmailId(),student.getParent().getLogin().getMobileNumber(),student.getParent().getLogin().getUsername(),student.getParent().getLogin().getPassword());
			attributes.addFlashAttribute("success", "Student Added Sucessfully");
			return new RedirectView("addstudent");
		} catch (EmailIdAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Parent Email Id:  already Exits");
			return new RedirectView("addstudent");
		} catch (MobileNumberAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Parent Mobile Number Already  Exits");
			return new RedirectView("addstudent");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("success", "Student Added Sucessfully");
			return new RedirectView("addstudent");
		} catch (InvalidParentEmailIdOrMobileNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Parent Email Id or Mobile Number Not Found");
			return new RedirectView("addstudent");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addstudent");
		}
	}

	@PostMapping("/WebSearchStudent")
	public RedirectView searchStudent(HttpSession session, HttpServletRequest request, String studentName,
			RedirectAttributes attributes) {
		int schoolId = (int) session.getAttribute("schoolId");
		List<Student> students = studentServiceImpl.searchStudent(studentName, schoolId);
		request.setAttribute("students", students);
		if (students.size() > 0) {
			attributes.addFlashAttribute("students", students);
			return new RedirectView("searchstudent");
		}
		attributes.addFlashAttribute("failure", "No Student Found");
		return new RedirectView("searchstudent");

	}

	@PostMapping("/WebEditStudent")
	public RedirectView editStudent(int actionId, int studentId, HttpSession session, Student student,
			RedirectAttributes attributes) {

		if (actionId == 0) {
			student = studentServiceImpl.getStudentById(studentId);
			attributes.addFlashAttribute("editstudent", student);
			return new RedirectView("editstudent");
		} else {
			student = studentServiceImpl.editStudent(student);
			attributes.addFlashAttribute("editstudent", student);
			attributes.addFlashAttribute("success", "Student Edited Sucessfully");
			return new RedirectView("editstudent");

		}

	}

	@PostMapping("/WebViewStudent")
	public RedirectView viewStudent(HttpServletRequest request, int studentId, int actionId,
			RedirectAttributes attributes) {
		if (actionId == 0) {
			student1 = studentServiceImpl.getStudentById(studentId);
			attributes.addFlashAttribute("editstudent", student1);
			return new RedirectView("viewstudent");
		}
		return null;
	}

	@PostMapping("/WebDeleteStudent")
	public RedirectView deleteStudent(int studentId, RedirectAttributes attributes) {
		System.out.println("In delete Student");
		studentServiceImpl.deleteStudent(studentId);
		attributes.addFlashAttribute("success", "Student Deleted Sucessfully");
		return new RedirectView("studentlist");

	}

	@PostMapping("/WebGetClass")
	@ResponseBody
	public void getClassList(int user_id, ServletResponse response) {
		school = schoolServiceImpl.getSchoolById(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			List<com.sms.beans.Class> classes = school.getClasses();
			out.print("<option disabled selected>--Select Class--</option>");
			for (Class class1 : classes) {
				out.print("<option value='" + class1.getClassId() + "'>");
				out.print(class1.getClassName());
				out.print("</option>");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@PostMapping("/WebRegisterStudent")
	public RedirectView registerStudent(StudentRegistration studentRegistration, RedirectAttributes attributes) {
		flag = studentServiceImpl.registerStudent(studentRegistration);
		if (flag == 0) {
			attributes.addFlashAttribute("message", "Student Id Already Exits");
			return new RedirectView("registerstudent");
		}
		if (flag == 1) {
			attributes.addFlashAttribute("message", "Parent Id Doesn't Exits");
			return new RedirectView("registerstudent");
		}
		if (flag == 2) {
			attributes.addFlashAttribute("message", "Parent Id Already Exits");
			return new RedirectView("registerstudent");
		}
		attributes.addFlashAttribute("message", "Student Registered Sucessfully");
		return new RedirectView("registerstudent");

	}

	@PostMapping("/WebAcceptStudentRequest")
	public RedirectView acceptStudent(int id, HttpSession session, RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		studentRegistration = studentServiceImpl.getStudentRegistrationById(id);
		student = new Student();
		student.setStudentName(studentRegistration.getStudentName());
		student.getLogin().setEmailId(studentRegistration.getStudentEmailId());
		// student.setMobileNumber(studentRegistration.getStudentMobileNumber());

		parent = new Parent();
		parent.setFathersName(studentRegistration.getFathersName());

		parent.getLogin().setEmailId(studentRegistration.getFatherEmailId());

		studentServiceImpl.acceptStudent(student, parent, schoolId, studentRegistration.isQuestion(),
				studentRegistration.getSectionId());
		studentServiceImpl.deleteRegsiterStudent(studentRegistration.getId());
		attributes.addFlashAttribute("message", "Student Approved Sucessfully");
		return new RedirectView("studentregisterrequestlist");

	}

	@PostMapping("/WebDeleteStudentRequest")
	public RedirectView deleteStudentRequest(int id, HttpSession session, RedirectAttributes attributes) {
		studentServiceImpl.deleteRegsiterStudent(id);
		attributes.addFlashAttribute("message", "Student Deleted Sucessfully");
		return new RedirectView("studentregisterrequestlist");

	}

	@PostMapping("/WebEditStudentProfilePicture")
	public RedirectView editStudentProfilePicture(HttpSession session, RedirectAttributes attributes,
			@RequestPart(value = "file") MultipartFile file) {
		try {
			student = (Student) session.getAttribute("currentstudent");
			student = studentServiceImpl.editStudentProfilePicture(student.getStudentId(), file);
			session.setAttribute("currentstudent", student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			attributes.addFlashAttribute("failure", "Something went wrong");
			return new RedirectView("parentstudentproflie");
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something went wrong");
			return new RedirectView("parentstudentproflie");
		}
		attributes.addFlashAttribute("message", "Student Deleted Sucessfully");
		return new RedirectView("parentstudentproflie");

	}

	@PostMapping("/WebEditStudentProfile")
	public RedirectView editStudentProfile(int studentId, RedirectAttributes attributes, Student student,
			HttpSession session) {
		student1 = studentServiceImpl.editStudent(student);
		attributes.addFlashAttribute("student", student1);
		session.setAttribute("currentStudent", student1);
		attributes.addFlashAttribute("success", "Teacher Edited Sucessfully");
		return new RedirectView("parenteditstudentprofile");
	}

}
