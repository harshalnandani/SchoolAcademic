package com.sms.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class StudentRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int schoolId;
	private String studentName;
	private String studentEmailId;
	private String studentMobileNumber;
	private String fathersName;
	private String fatherEmailId;
	private String fatherMobileNumber;
	private boolean question;
	private int sectionId;
	private String classSection;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmailId() {
		return studentEmailId;
	}

	public void setStudentEmailId(String studentEmailId) {
		this.studentEmailId = studentEmailId;
	}

	public String getStudentMobileNumber() {
		return studentMobileNumber;
	}

	public void setStudentMobileNumber(String studentMobileNumber) {
		this.studentMobileNumber = studentMobileNumber;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getFatherEmailId() {
		return fatherEmailId;
	}

	public void setFatherEmailId(String fatherEmailId) {
		this.fatherEmailId = fatherEmailId;
	}

	public String getFatherMobileNumber() {
		return fatherMobileNumber;
	}

	public void setFatherMobileNumber(String fatherMobileNumber) {
		this.fatherMobileNumber = fatherMobileNumber;
	}

	public boolean isQuestion() {
		return question;
	}

	public void setQuestion(boolean question) {
		this.question = question;
	}

	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getClassSection() {
		return classSection;
	}

	public void setClassSection(String classSection) {
		this.classSection = classSection;
	}

}
