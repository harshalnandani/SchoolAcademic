package com.sms.section;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.Class;
import com.sms.beans.Section;
import com.sms.beans.Student;
import com.sms.beans.Subject;
import com.sms.beans.Teacher;
import com.sms.class1.ClassDAO;
import com.sms.class1.ClassServiceImpl;
import com.sms.exceptions.SectionAlreadyExistsException;
import com.sms.exceptions.SubjectAlreadyExitsException;
import com.sms.student.StudentServiceImpl;
import com.sms.subject.SubjectServiceImpl;
import com.sms.teacher.TeacherServiceImpl;

@Service
public class SectionServiceImpl {

	@Autowired
	private SectionDAO sectionDAO;

	
	
	@Autowired
	private ClassDAO classDOA;

	@Autowired
	private SubjectServiceImpl subjectServiceImpl;

	@Autowired
	private TeacherServiceImpl teacherServiceImpl;

	@Autowired
	private StudentServiceImpl studentServiceImpl;

	private Section section;
	private Subject subject;
	private Teacher teacher;
	private Student student;
	private Class class1;
	private String sectionName;

	@Transactional(rollbackFor = Exception.class)
	public void addSection(int schoolId, int classId, String sectionName2) throws SectionAlreadyExistsException {
		sectionName = sectionDAO.checkSectionName(sectionName2, classId);
		if (sectionName != null) {
			throw new SectionAlreadyExistsException();
		}
		class1 = classDOA.getOne(classId);
		section = new Section();
		section.setClass1(class1);
		section.setSectionName(sectionName2);
		sectionDAO.save(section);

	}

	public Section getSectionById(int sectionId) {
		return sectionDAO.getOne(sectionId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void addSubjectToSection(int sectionId, int[] subjectId, int[] teacherId) throws SubjectAlreadyExitsException {
		section = sectionDAO.getOne(sectionId);
		for(int i=0;i<subjectId.length;i++) {
		subject = subjectServiceImpl.getSubjectById(subjectId[i]);
		if (section.getSubjects().containsKey(subject)) {
			throw new SubjectAlreadyExitsException();
		}
		teacher = teacherServiceImpl.getTeacherById(teacherId[i]);
		section.getSubjects().put(subject, teacher);
		sectionDAO.save(section);
		}
	}

	public int addClassTeacher(int sectionId, int teacherId) {
		section = sectionDAO.getOne(sectionId);
		if (section.getClassTeacherId() != 0) {
			return -1;
		}
		teacher = teacherServiceImpl.getTeacherById(teacherId);
		teacher.setClassTeacher(true);
		teacherServiceImpl.save(teacher);
		section.setClassTeacherId(teacherId);
		sectionDAO.save(section);
		return section.getSectionId();
	}

	public int addStudentToSection(int sectionId, int studentId) {
		section = sectionDAO.getOne(sectionId);
		System.out.println(studentId);
		System.out.println(sectionId);
		student = studentServiceImpl.getStudentById(studentId);
		section.getStudents().add(student);
		section = sectionDAO.save(section);
		return section.getSectionId();
	}

	public List<Object[]> getSectionByClassId(int user_id) {

		return sectionDAO.getSectionByClassId(user_id);
	}

	public List<Object[]> getSectionNameAndIdBySchoolId(int schoolId) {

		return sectionDAO.getSectionNameAndIdBySchoolId(schoolId);
	}

	public List<Object[]> getStudentsBySectionId(int sectionId) {

		return sectionDAO.getStudentsBySectionId(sectionId);
	}

	public List<Object[]> getSubjectNameIdBySectionId(int sectionId) {
		// TODO Auto-generated method stub
		return sectionDAO.getSubjectNameIdBySectionId(sectionId);
	}

	public List<Object[]> getSubjectTeacherMappingBySchoolId(int schoolId) {
		return sectionDAO.getSubjectTeacherMappingBySchoolId(schoolId);
	}

}
