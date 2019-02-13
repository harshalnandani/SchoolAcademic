package com.sms.subject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.School;
import com.sms.beans.Subject;
import com.sms.exceptions.SubjectAlreadyExistsException;
import com.sms.school.SchoolServiceImpl;



@Service
public class SubjectServiceImpl {
	
	@Autowired
	private SubjectDAOImpl subjectDAO;
	
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	private String subjectName;
	private School school;
	private Subject subject;
	
	@Transactional(rollbackFor = Exception.class)
	public void addSubject(int schoolId, String[] subjectName2) throws SubjectAlreadyExistsException {
		school = schoolServiceImpl.getSchoolById(schoolId);
		for (String string : subjectName2) {
			subjectName = subjectDAO.checkSubjectName(string,schoolId);
			if (subjectName != null) {
				throw new SubjectAlreadyExistsException();
			}
			subject=new Subject();
			subject.setSubjectName(string);
			subject.setSchool(school);
			subject=subjectDAO.save(subject);
		}
	}

	public Subject getSubjectById(int subjectId) {
		// TODO Auto-generated method stub
		return subjectDAO.getOne(subjectId);
	}

	public List<Object[]>  getSubjectAndId(int schoolId) {
		
		return subjectDAO.getSubjectAndId(schoolId);
	}


}
