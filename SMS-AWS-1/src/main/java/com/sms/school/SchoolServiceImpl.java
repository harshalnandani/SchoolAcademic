package com.sms.school;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sms.beans.School;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;
import com.sms.login.LoginDAOImpl;
import com.sms.login.LoginServiceImpl;
import com.sms.services.FileS3ServiceImpl;
import com.sms.services.SMSServiceImpl;

@Service
public class SchoolServiceImpl {

	@Autowired
	private SchoolDAO schoolDAO;

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	@Autowired
	private SMSServiceImpl smsServiceImpl;

	@Autowired
	private LoginDAOImpl loginDAOImpl;

	@Autowired
	private FileS3ServiceImpl fileS3ServiceImpl;

	private School school2;


	private String password;

	private String username;

	

	private String fileUrl;

	public School saveSchool(School school) {
		return schoolDAO.save(school);
	}

	public void deleteSchoolById(int schoolId) {
		schoolDAO.deleteById(schoolId);
	}

	public School schoolLogin(String emailId, String password) {

		return schoolDAO.schoolLogin(emailId, password);
	}

	public String checkCheckEmailId(String emailId) {
		return schoolDAO.checkCheckEmailId(emailId);

	}

	public School getSchoolById(int schoolId) {
		// TODO Auto-generated method stub
		return schoolDAO.getOne(schoolId);
	}

	public School editSchool(School school) {
		school2 = schoolDAO.getOne(school.getSchoolId());
		school2.setSchoolName(school.getSchoolName());
		school2.setAddressLine1(school.getAddressLine1());
		school2.setAddressLine2(school.getAddressLine2());
		school2.setCity(school.getCity());
		school2.setDistrict(school.getDistrict());
		school2.setState(school.getState());
		school2.setPinCode(school.getPinCode());
		return schoolDAO.save(school2);

	}

	public List<School> getAllSchool() {
		return schoolDAO.findAll();
	}

	@Transactional(rollbackFor = Exception.class)
	public School addSchool(School school)
			throws EmailIdAlreadyExistsException, MobileNumberAlreadyExistsException, MessagingException {
		loginServiceImpl.checkEmailId(school.getLogin().getEmailId());
		loginServiceImpl.checkMobileNumber(school.getLogin().getMobileNumber());
		password = smsServiceImpl.generatePassword();
		username = smsServiceImpl.generateUsername(school.getSchoolName());
		school.getLogin().setPassword(password);
		school.getLogin().setUsername(username);
		loginDAOImpl.save(school.getLogin());
		school = schoolDAO.save(school);
		return school;
	}

	

	public void uploadLogo(int schoolId, MultipartFile file) throws IOException, Exception {
		School school = schoolDAO.getOne(schoolId);
		fileUrl = school.getLogoURl();
		if (fileUrl != null)
			fileS3ServiceImpl.deleteFileFromS3Bucket(fileUrl);
		fileUrl = fileS3ServiceImpl.uploadFile(file);
		school.setLogoURl(fileUrl);
		schoolDAO.save(school);
	}

	public List<Object[]> getSchoolList() {

		return schoolDAO.getSchoolList();
	}

	public void uploadBanner(int schoolId, MultipartFile file) throws IOException {
		School school = schoolDAO.getOne(schoolId);
		fileUrl = school.getBannerUrl();
		if (fileUrl != null)
			fileS3ServiceImpl.deleteFileFromS3Bucket(fileUrl);
		fileUrl = fileS3ServiceImpl.uploadFile(file);
		school.setBannerUrl(fileUrl);
		schoolDAO.save(school);

	}
	
	
}
