package com.sms.student;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.Login;
import com.sms.beans.Parent;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Student;
import com.sms.beans.StudentRegistration;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.InvalidParentEmailIdOrMobileNumberException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;
import com.sms.login.LoginServiceImpl;
import com.sms.parent.ParentServiceImpl;
import com.sms.school.SchoolServiceImpl;
import com.sms.section.SectionServiceImpl;
import com.sms.services.FileS3ServiceImpl;
import com.sms.services.SMSServiceImpl;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;

	@Autowired
	private ParentServiceImpl parentServiceImpl;

	@Autowired
	private SMSServiceImpl smsService;

	@Autowired
	private RegisterStudentDAO registerStudentDAO;

	@Autowired
	private SectionServiceImpl sectionServiceImpl;

	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	

	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;
	
	private School school;
	private Student student;
	private Parent parent1;
	private String password;
	private String username;
	private Section section;
	
	
	public List<Student> getAllStudent() {
		return studentDAO.findAll();
	}

	public List<Student> searchStudent(String studentName, int schoolId) {
		return studentDAO.searchStudent(studentName, schoolId);
	}

	public Student getStudentById(int studentId) {
		
		return studentDAO.getOne(studentId);
	}

	

	@Transactional(rollbackFor = Exception.class)
	public Student addStudent(Student student, Parent parent, int schoolId, Boolean question, int sectionId) throws EmailIdAlreadyExistsException, MobileNumberAlreadyExistsException, MessagingException, InvalidParentEmailIdOrMobileNumberException {
		school = schoolServiceImpl.getSchoolById(schoolId);

		if (question == null) {
			loginServiceImpl.checkEmailId(parent.getLogin().getEmailId());
			loginServiceImpl.checkMobileNumber(parent.getLogin().getMobileNumber());

			password = smsService.generatePassword();
			username = smsService.generateUsername(student.getStudentName());
			student.getLogin().setPassword(password);
			student.getLogin().setUsername(username);
			student.getLogin().setUser("student");

			password = smsService.generatePassword();
			username = smsService.generateUsername(parent.getFathersName());
			parent.getLogin().setUsername(username);
			parent.getLogin().setPassword(password);
			parent.getLogin().setUser("parent");
			
			loginServiceImpl.saveLogin(parent.getLogin());
			parent = parentServiceImpl.saveParent(parent);
			student.setParent(parent);
			student.setSchool(school);
			
			loginServiceImpl.saveLogin(student.getLogin());
			student.setSection(sectionServiceImpl.getSectionById(sectionId));
			student = studentDAO.save(student);
			return  student;
		} else {
			Login login1 = loginServiceImpl.checkEmailIdMobileNumber(parent.getLogin().getEmailId(),parent.getLogin().getMobileNumber());
			password = smsService.generatePassword();
			username = smsService.generateUsername(student.getStudentName());
			student.getLogin().setPassword(password);
			student.getLogin().setUsername(username);
			student.getLogin().setUser("student");
			parent1 = login1.getParent();
			student.setParent(parent1);
			student.setSchool(school);
			loginServiceImpl.saveLogin(student.getLogin());
			student.setSection(sectionServiceImpl.getSectionById(sectionId));
			student = studentDAO.save(student);
			return  student;
		}
	}

	public Student editStudent(Student student) {
		System.out.println("in edit student");
		Student student1 = studentDAO.getOne(student.getStudentId());
		student1.setStudentName(student.getStudentName());
		student1.setGender(student.getGender());
		student1.setDateOfBirth(student.getDateOfBirth());
		student1.setAddressLine1(student.getAddressLine1());
		student1.setAddressLine2(student.getAddressLine2());
		student1.setCity(student.getCity());
		student1.setDistrict(student.getDistrict());
		student1.setState(student.getState());
		student1.setPinCode(student.getPinCode());
		return studentDAO.save(student1);

	}

	public void deleteStudent(int studentId) {
		student=studentDAO.getOne(studentId);
		parent1=student.getParent();
		if(parent1.getStudents().size()>1) {
			System.out.println("in If");
			parent1.getStudents().remove(student);
			parentServiceImpl.saveParent(parent1);
			
		}else {
			parent1.getStudents().remove(student);
			parent1.getStudents().remove(student);
			parentServiceImpl.saveParent(parent1);
			parentServiceImpl.deleteParent(parent1.getParentId());
			
		}
	}
	public int registerStudent(StudentRegistration studentRegistration) {
		System.out.println(studentRegistration.isQuestion());
		student = studentDAO.checkEmailId(studentRegistration.getStudentEmailId());
		if (student != null) {
			return 0;
		}
		if (studentRegistration.isQuestion()) {
			
			if (parent1 == null) {
				return 1;
			}
		} else {
			
			if (parent1 != null) {
				return 2;
			}
		}
		section = sectionServiceImpl.getSectionById(studentRegistration.getSectionId());
		studentRegistration.setClassSection(section.getClass1().getClassName() + "/" + section.getSectionName());
		studentRegistration = registerStudentDAO.save(studentRegistration);
		return studentRegistration.getId();
	}

	public List<StudentRegistration> getstudentRegistrationList(int schoolId) {
		return registerStudentDAO.getAllRegistrationBySchoolId(schoolId);
	}

	public StudentRegistration getStudentRegistrationById(int id) {
		return registerStudentDAO.getOne(id);
	}

	public void acceptStudent(Student student, Parent parent, int schoolId, boolean question, int sectionId) {
		/*
		 * school = schoolServiceImpl.getSchoolById(schoolId); section =
		 * sectionDAO.getOne(sectionId); student.setSection(section); if (!question) {
		 * password = smsService.generatePassword(); student.setPassword(password);
		 * password = smsService.generatePassword(); parent.setPassword(password);
		 * parent = parentServiceImpl.saveParent(parent); student.setParent(parent);
		 * student.setSchool(school); studentDAO.save(student);
		 * mailService.sendNewRegistrationMail(student.getEmailId(),
		 * student.getPassword());
		 * mailService.sendNewRegistrationMail(parent.getEmailId(),
		 * parent.getPassword()); } else { password = smsService.generatePassword();
		 * student.setPassword(password); student.setParent(parent1);
		 * student.setParent(parent1); student.setSchool(school);
		 * studentDAO.save(student);
		 * mailService.sendNewRegistrationMail(student.getEmailId(),
		 * student.getPassword()); }
		 */
	}

	public void deleteRegsiterStudent(int id) {
		registerStudentDAO.deleteById(id);

	}

	public List<Student> getStudentWithNoAllotatedSection(int schoolId) {

		return studentDAO.getStudentWithNoAllotatedSection(schoolId);
	}

	public List<Student> getStudentBySchoolId(int schoolId) {
		
		return studentDAO.getStudentBySchoolId(schoolId);
	}

	public List<Object[]>  getStudentsByParentId(int parentId) {
		return studentDAO.getStudentsByParentId(parentId);
	}

	public Student editStudentProfilePicture(int studentId, MultipartFile file) throws IOException,Exception {
		
		student=studentDAO.getOne(studentId);
		if(student.getProfilePictureUrl()!=null) {
			fileS3ServiceImpl.deleteFileFromS3Bucket(student.getProfilePictureUrl());
		}
		String profilePictureUrl=fileS3ServiceImpl.uploadFile(file);
		student.setProfilePictureUrl(profilePictureUrl);
		return studentDAO.save(student);
	}
}
