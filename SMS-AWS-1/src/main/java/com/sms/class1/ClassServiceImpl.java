package com.sms.class1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.Class;
import com.sms.beans.School;
import com.sms.exceptions.ClassAlreadyExistsException;
import com.sms.exceptions.SectionAlreadyExistsException;
import com.sms.school.SchoolServiceImpl;
import com.sms.section.SectionServiceImpl;

@Service
public class ClassServiceImpl {

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;

	private School school;
	@Autowired
	private ClassDAO classDAO;
	
	@Autowired
	private SectionServiceImpl sectionServiceImpl;

	private Class class1;
	
	private String className;

	@Transactional(rollbackFor = Exception.class)
	public void addClass(int schoolId, String className1, String[] sectionName) throws ClassAlreadyExistsException, SectionAlreadyExistsException {
		className = classDAO.checkClassName(className1, schoolId);
		if (className != null) {
			throw new ClassAlreadyExistsException();
		}
		school = schoolServiceImpl.getSchoolById(schoolId);
		class1 = new Class();
		class1.setSchool(school);
		class1.setClassName(className1);
		class1=classDAO.save(class1);
		for (String string : sectionName) {
			sectionServiceImpl.addSection(schoolId,class1.getClassId(),string);
		}
	}

	public Class getClassById(int user_id) {
		// TODO Auto-generated method stub
		return classDAO.getOne(user_id);
	}

	public List<Class> getClassBySchoolId(int schoolId) {

		return classDAO.getClassBySchoolId(schoolId);
	}

	public List<Object[]> getClassAndId(int schoolId) {

		return classDAO.getClassAndId(schoolId);
	}

	public List<Object[]> getSubjectBySectionId(int user_id) {
		// TODO Auto-generated method stub
		return classDAO.getSubjectBySectionId(user_id);
	}

	

	

}
