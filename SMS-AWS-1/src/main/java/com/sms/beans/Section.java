package com.sms.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table
public class Section {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private int sectionId;
	private String sectionName;
	
	@ElementCollection
	Map<Subject,Teacher> subjects=new HashMap<Subject, Teacher>();
	
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Student> students=new ArrayList<Student>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "class_id")
	private Class class1;
	
	private int classTeacherId;

	@OneToOne(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private TimeTable timeTable;
	
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
	List<HomeWork> homeWork=new ArrayList<HomeWork>();
	
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
	List<Notice> notices =new ArrayList<>();
	
	public int getSectionId() {
		return sectionId;
	}

	public void setSectionId(int sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Class getClass1() {
		return class1;
	}

	public void setClass1(Class class1) {
		this.class1 = class1;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Map<Subject, Teacher> getSubjects() {
		return subjects;
	}

	public void setSubjects(Map<Subject, Teacher> subjects) {
		this.subjects = subjects;
	}

	public int getClassTeacherId() {
		return classTeacherId;
	}

	public void setClassTeacherId(int classTeacherId) {
		this.classTeacherId = classTeacherId;
	}

	
	

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	public List<HomeWork> getHomeWork() {
		return homeWork;
	}

	public void setHomeWork(List<HomeWork> homeWork) {
		this.homeWork = homeWork;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
	
	
}
