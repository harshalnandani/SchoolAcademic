package com.sms.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Class;
import com.sms.beans.Notice;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.class1.ClassServiceImpl;
import com.sms.school.SchoolServiceImpl;
import com.sms.section.SectionServiceImpl;

@Service
public class NoticeServiceImpl {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	@Autowired
	private ClassServiceImpl classServiceImpl;
	
	@Autowired
	private SectionServiceImpl sectionServiceImpl;
	
	private School school;
	
	private Class class1;
	
	private Section section;
	
	private List<String> phoneNumbers;
	
	private List<String> emailIds;
	
	
	public Notice saveSchoolNotice(int schoolId, Notice notice) {
		school=schoolServiceImpl.getSchoolById(schoolId);
		notice.setSchool(school);
		notice.setType("school");
		phoneNumbers=noticeDAO.getSchoolMobileNumbers(schoolId);
		emailIds=noticeDAO.getSchoolEmailId(schoolId);
		for (String string : phoneNumbers) {
			System.out.println(phoneNumbers);
		}
		return noticeDAO.save(notice);
	}


	public Notice saveClassNotice(int schoolId, Notice notice1, int classId) {
		school=schoolServiceImpl.getSchoolById(schoolId);
		class1=classServiceImpl.getClassById(classId);
		notice1.setSchool(school);
		notice1.setClass1(class1);
		notice1.setType("class");
		phoneNumbers=noticeDAO.getClassMobileNumbers(schoolId,classId);
		emailIds=noticeDAO.getClassEmailIds(schoolId,classId);
		for (String string : phoneNumbers) {
			System.out.println(phoneNumbers);
		}
		return noticeDAO.save(notice1);
	}


	public Notice saveSectionNotice(int schoolId, Notice notice1, int sectionId) {
		school=schoolServiceImpl.getSchoolById(schoolId);
		section=sectionServiceImpl.getSectionById(sectionId);
		notice1.setSchool(school);
		notice1.setSection(section);
		notice1.setType("section");
		phoneNumbers=noticeDAO.getSectionMobileNumbers(schoolId,sectionId);
		emailIds=noticeDAO.getSectionEmailIds(schoolId,sectionId);
		for (String string : phoneNumbers) {
			System.out.println(phoneNumbers);
		}
		return noticeDAO.save(notice1);
	}


	public Notice saveTeacherNotice(int schoolId, Notice notice1) {
		school=schoolServiceImpl.getSchoolById(schoolId);
		notice1.setSchool(school);
		notice1.setType("teacher");
		phoneNumbers=noticeDAO.getTeacherMobileNumbers(schoolId);
		emailIds=noticeDAO.getTeacherEmailId(schoolId);
		for (String string : phoneNumbers) {
			System.out.println(phoneNumbers);
		}
		return noticeDAO.save(notice1);
	}


	public List<Object[]> getAllNoticeForSchoolBySchoolId(int schoolId) {
		// TODO Auto-generated method stub
		return noticeDAO.getAllNoticeForSchoolBySchoolId(schoolId);
	}


	public List<Object[]> getAllNoticeForTeacherBySchoolId(int schoolId) {
		// TODO Auto-generated method stub
		return noticeDAO.getAllNoticeForTeacherBySchoolId(schoolId);
	}


	public List<Object> getAllNoticeForStudentBySchoolIdAndSectionId(int schoolId, int classId, int sectionId) {
		return noticeDAO.getAllNoticeForStudentBySchoolIdAndSectionId(schoolId,classId,sectionId);
	}

	
}
