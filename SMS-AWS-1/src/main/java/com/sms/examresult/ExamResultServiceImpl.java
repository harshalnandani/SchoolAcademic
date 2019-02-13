package com.sms.examresult;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Exam;
import com.sms.beans.Result;
import com.sms.beans.Student;
import com.sms.beans.Subject;
import com.sms.exceptions.ExamAlreadyExistsException;
import com.sms.exceptions.ResultNotFoundException;
import com.sms.school.SchoolServiceImpl;

@Service
public class ExamResultServiceImpl {

	@Autowired
	private ExamDAO examDAO;

	@Autowired
	private ResultDAO resultDAO;

	@Autowired
	private SchoolServiceImpl schoolServiceImpl;

	public void save(Exam exam, int schoolId) throws ExamAlreadyExistsException {

		if (examDAO.checkExamAndSession(exam.getExamName(), exam.getSession(), schoolId) != null)
			throw new ExamAlreadyExistsException();

		exam.setSchool(schoolServiceImpl.getSchoolById(schoolId));
		examDAO.save(exam);
	}

	public List<Exam> getExamsBySchoolId(int schoolId) {

		return examDAO.getExamsBySchoolId(schoolId);
	}

	public void addResult(int[] marks, List<Integer> subjectId, List<Object[]> students, int examId) {
		int i = 0, j = 0, k = 0;
		Exam exam = new Exam();
		exam.setExamId(examId);
		Student student;
		List<Subject> subjects = new ArrayList<>();
		for (j = 0; j < subjectId.size(); j++) {
			Subject subject = new Subject();
			subject.setSubjectId(subjectId.get(j));
			subjects.add(subject);
		}

		List<Result> results = new ArrayList<>();
		for (i = 0; i < marks.length; i = i + subjectId.size()) {
			student = new Student();
			student.setStudentId((int) students.get(k)[0]);
			for (j = 0; j < subjects.size(); j++) {
				Result result = new Result();
				result.setExam(exam);
				result.setStudent(student);
				result.setSubject(subjects.get(j));
				result.setMarks(marks[i + j]);
				results.add(result);
			}
			k++;
		}

		resultDAO.saveAll(results);

	}

	public List<String> getDISTINCTSubjectByExamId(int examId) throws ResultNotFoundException {
		
		List<String> subject=examDAO.getDISTINCTSubjectByExamId(examId);
		if(subject.size()==0)
			throw new ResultNotFoundException();
		return subject;
	}

	public List<Object[]> getResultByExamAndSectionId(int sectionId, int examId) {
		
		return resultDAO.getResultByExamAndSectionId(sectionId,examId);
	}

	public Exam getExamById(int examId) {
		// TODO Auto-generated method stub
		return examDAO.getOne(examId);
	}

}
