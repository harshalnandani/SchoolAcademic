package com.sms.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int classId;

	private String className;

	@OneToMany(mappedBy = "class1", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Section> sections = new ArrayList<Section>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private School school;

	@OneToMany(mappedBy = "class1", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionPaper> questionPapers;

	@OneToMany(mappedBy = "class1", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Syllabus> syllabus;

	@OneToMany(mappedBy = "class1", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ExamTimeTable> examTimeTables;
	
	@OneToMany(mappedBy = "class1", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Notice> notices =new ArrayList<>();
	

	public int getClassId() {
		return classId;
	}

	public void setClassId(int classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<QuestionPaper> getQuestionPapers() {
		return questionPapers;
	}

	public void setQuestionPapers(List<QuestionPaper> questionPapers) {
		this.questionPapers = questionPapers;
	}

	public List<Syllabus> getSyllabus() {
		return syllabus;
	}

	public void setSyllabus(List<Syllabus> syllabus) {
		this.syllabus = syllabus;
	}

	public List<ExamTimeTable> getExamTimeTables() {
		return examTimeTables;
	}

	public void setExamTimeTables(List<ExamTimeTable> examTimeTables) {
		this.examTimeTables = examTimeTables;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	
}
