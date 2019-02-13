package com.sms.beans;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int schoolId;
	private String schoolName;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String district;
	private String state;
	private int pinCode;

	private String logoURl;

	private String bannerUrl;

	@CreationTimestamp
	private Date date;

	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "login_id", nullable = false)
	private Login login;

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Teacher> teachers = new ArrayList<Teacher>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Student> students = new ArrayList<Student>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Class> classes = new ArrayList<Class>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Subject> subjects = new ArrayList<Subject>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<News> news = new ArrayList<>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<EventCalender> eventCalenders = new ArrayList<>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Period> periods = new ArrayList<Period>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Notice> notices = new ArrayList<>();

	@OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Accountant> accountants = new ArrayList<>();

	public int getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(int schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
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

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Class> getClasses() {
		return classes;
	}

	public void setClasses(List<Class> classes) {
		this.classes = classes;
	}

	public List<News> getNews() {
		return news;
	}

	public void setNews(List<News> news) {
		this.news = news;
	}

	public List<EventCalender> getEventCalenders() {
		return eventCalenders;
	}

	public void setEventCalenders(List<EventCalender> eventCalenders) {
		this.eventCalenders = eventCalenders;
	}

	public List<Period> getPeriods() {
		return periods;
	}

	public void setPeriods(List<Period> periods) {
		this.periods = periods;
	}

	public String getLogoURl() {
		return logoURl;
	}

	public void setLogoURl(String logoURl) {
		this.logoURl = logoURl;
	}

	public String getBannerUrl() {
		return bannerUrl;
	}

	public void setBannerUrl(String bannerUrl) {
		this.bannerUrl = bannerUrl;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

}
