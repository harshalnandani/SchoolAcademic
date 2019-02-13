package com.sms.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class AdmissionEnquiryForm {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int admissionId;
	private String date;
	private String academicSession;
	private String studentName;
	private String studentDOB;
	private String gender;
	private String classToAdmission;
	private String previousClassPassed;
	private String yearOfPassing;
	private String medium;
	private String previousSchool;
	private String previousBoard;
	private String marksObtained;
	private String achievement;
	private String fathersName;
	private String mothersName;
	private String emailId;
	private String mobileNumber;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String district;
	private String state;
	private int pinCode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	private School school;

	public int getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(int admissionId) {
		this.admissionId = admissionId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


	public String getAcademicSession() {
		return academicSession;
	}

	public void setAcademicSession(String academicSession) {
		this.academicSession = academicSession;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(String studentDOB) {
		this.studentDOB = studentDOB;
	}

	public String getClassToAdmission() {
		return classToAdmission;
	}

	public void setClassToAdmission(String classToAdmission) {
		this.classToAdmission = classToAdmission;
	}

	public String getPreviousClassPassed() {
		return previousClassPassed;
	}

	public void setPreviousClassPassed(String previousClassPassed) {
		this.previousClassPassed = previousClassPassed;
	}

	public String getYearOfPassing() {
		return yearOfPassing;
	}

	public void setYearOfPassing(String yearOfPassing) {
		this.yearOfPassing = yearOfPassing;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	public String getPreviousSchool() {
		return previousSchool;
	}

	public void setPreviousSchool(String previousSchool) {
		this.previousSchool = previousSchool;
	}

	public String getPreviousBoard() {
		return previousBoard;
	}

	public void setPreviousBoard(String previousBoard) {
		this.previousBoard = previousBoard;
	}

	public String getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(String marksObtained) {
		this.marksObtained = marksObtained;
	}

	public String getAchievement() {
		return achievement;
	}

	public void setAchievement(String achievement) {
		this.achievement = achievement;
	}

	public String getFathersName() {
		return fathersName;
	}

	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}

	public String getMothersName() {
		return mothersName;
	}

	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
