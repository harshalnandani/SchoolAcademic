package com.sms.homework;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.HomeWork;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.beans.Teacher;
import com.sms.section.SectionServiceImpl;
import com.sms.subject.SubjectServiceImpl;
import com.sms.teacher.TeacherServiceImpl;

@Service
public class HomeWorkServiceImpl {

	@Autowired
	private HomeWorkDAO homeWorkDAO;

	@Autowired
	private SectionServiceImpl  sectionServiceImpl;

	@Autowired
	private SubjectServiceImpl subjectServiceImpl;

	@Autowired
	private TeacherServiceImpl teacherServiceImpl;

	private Section section;

	private Subject subject;

	private Teacher teacher;

	@Transactional(rollbackFor = Exception.class)
	public void saveHomeWork(HomeWork homeWork, int sectionId, int subjectId, int teacherId) {
		section = sectionServiceImpl.getSectionById(sectionId);
		subject = subjectServiceImpl.getSubjectById(subjectId);
		teacher = teacherServiceImpl.getTeacherById(teacherId);
		homeWork.setSection(section);
		homeWork.setSubject(subject);
		homeWork.setTeacher(teacher);
		homeWorkDAO.save(homeWork);
	}

	public List<HomeWork> fetchHomeWorkForDate(String date) {
		return null;
	}

	public List<Object[]> getHomeWorkByTeacherIdandDate(String user_id, int teacherId) {
		// TODO Auto-generated method stub
		return homeWorkDAO.getHomeWorkByTeacherIdandDate(user_id, teacherId);
	}

	public List<Object[]> getHomeWorkBySectionIdandDate(String user_id, int sectionId) {

		return homeWorkDAO.getHomeWorkBySectionIdandDate(user_id, sectionId);
	}

}
