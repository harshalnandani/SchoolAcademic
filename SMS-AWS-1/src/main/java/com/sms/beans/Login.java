package com.sms.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginId;
	private String username;
	private String emailId;
	private String mobileNumber;
	private String password;
	private String user;
	
	

	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private School school;

	@OneToOne(mappedBy = "login",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Student student;

	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Parent parent;

	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@OneToOne(mappedBy = "login", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Accountant accountant;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Parent getParent() {
		return parent;
	}

	public void setParent(Parent parent) {
		this.parent = parent;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	
	
	

}
