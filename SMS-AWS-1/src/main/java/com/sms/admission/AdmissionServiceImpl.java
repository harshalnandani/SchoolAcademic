package com.sms.admission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.AdmissionEnquiryForm;
import com.sms.beans.School;

@Service
public class AdmissionServiceImpl {
	
	@Autowired
	private AdmissionDAO admissionDAO;
	
	
	
	private School school;
	
	
	public void saveAdmission(AdmissionEnquiryForm admission,int schoolId) {
		school=new School();
		school.setSchoolId(schoolId);
		admission.setSchool(school);
		admissionDAO.save(admission);
	}


	public List<Object[]> getenquiryFormList(int schoolId) {
		System.out.println(schoolId);
		return admissionDAO.getenquiryFormList(schoolId);
	}
	

}
