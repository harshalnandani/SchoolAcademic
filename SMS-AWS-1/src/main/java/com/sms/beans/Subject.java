package com.sms.beans;

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


@Entity
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	private String subjectName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private School school;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionPaper> questionPapers;
	
	@OneToMany(mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Syllabus> syllabus;

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public School getSchool() {
		return school;
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
	
	

}
