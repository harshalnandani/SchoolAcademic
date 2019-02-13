package com.sms.teacher;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.School;
import com.sms.beans.Teacher;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.InvalidFileNameException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;
import com.sms.login.LoginServiceImpl;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.FileS3ServiceImpl;
import com.sms.services.SMSServiceImpl;

@Service
public class TeacherServiceImpl {

	@Autowired
	private TeacherDAO teacherDAO;
	
	@Autowired
	private SMSServiceImpl smsService;

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	@Autowired
	private LoginServiceImpl loginServiceImpl;
	
	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;

	private String password;
	private School school;
	private Teacher teacher2;
	private String username;
	

	public Teacher getTeacherByEmailId(String emailId, int schoolId) {

		return teacherDAO.getTeacherByEmailId(emailId, schoolId);
	}

	@Transactional(rollbackFor = Exception.class)
	public Teacher addTeacher(Teacher teacher, int schoolId) throws MobileNumberAlreadyExistsException, EmailIdAlreadyExistsException, MessagingException {
		loginServiceImpl.checkEmailId(teacher.getLogin().getEmailId());
		loginServiceImpl.checkMobileNumber(teacher.getLogin().getMobileNumber());

		password = smsService.generatePassword();
		username = smsService.generateUsername(teacher.getTeacherName());
		teacher.getLogin().setPassword(password);
		teacher.getLogin().setUsername(username);
		teacher.getLogin().setUser("teacher");
		
		school = schoolServiceImpl.getSchoolById(schoolId);
		teacher.setSchool(school);
		loginServiceImpl.saveLogin(teacher.getLogin());
		teacher2=teacherDAO.save(teacher);
		return teacher2;
	}

	public List<Teacher> searchTeacher(String teacherName, int schoolId) {
		return teacherDAO.searchTeacher(teacherName,schoolId);
		 
	}

	public Teacher getTeacherById(int teacherId) {
		
		return teacherDAO.getOne(teacherId);
	}

	@Transactional(rollbackFor = Exception.class)
	public Teacher editTeacher(Teacher teacher) {
		 	teacher2=teacherDAO.getOne(teacher.getTeacherId());
		 	teacher2.setTeacherName(teacher.getTeacherName());
		 	teacher2.setGender(teacher.getGender());
		 	teacher2.setDateOfBirth(teacher.getDateOfBirth());
			teacher2.setAddressLine1(teacher.getAddressLine1());
			teacher2.setAddressLine2(teacher.getAddressLine2());
			teacher2.setCity(teacher.getCity());
			teacher2.setDistrict(teacher.getDistrict());
			teacher2.setState(teacher.getState());
			teacher2.setPinCode(teacher.getPinCode());
			return teacherDAO.save(teacher2);	
	}

	public void save(Teacher teacher) {
		teacherDAO.save(teacher);
	}

	public void DeleteById(int teacherId) {
		
		 teacherDAO.deleteById(teacherId);
	}

	public Object getTeacherAndId(int schoolId) {
		// TODO Auto-generated method stub
		return teacherDAO.getTeacherAndId(schoolId);
	}

	public void editTeacherProfilePicture(MultipartFile file, int teacherId) throws InvalidFileNameException, IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			if (fileName.contains("..")) {
				throw new InvalidFileNameException();
			}
			Teacher teacher=teacherDAO.getOne(teacherId);
			if(teacher.getProfilePictureUrl()!=null)
				fileS3ServiceImpl.deleteFileFromS3Bucket(teacher.getProfilePictureUrl());
			
			teacher.setProfilePictureUrl(fileS3ServiceImpl.uploadFile(file));
			teacherDAO.save(teacher);

	}

}
