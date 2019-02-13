package com.sms.beans;

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


@Entity
@Table
public class TimeTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int timeTableId;
	
	private String name;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;

	@OneToMany(mappedBy = "timeTable", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PeriodSubjectMapping> periodSubjectMapping;

	public int getTimeTableId() {
		return timeTableId;
	}

	public void setTimeTableId(int timeTableId) {
		this.timeTableId = timeTableId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public List<PeriodSubjectMapping> getPeriodSubjectMapping() {
		return periodSubjectMapping;
	}

	public void setPeriodSubjectMapping(List<PeriodSubjectMapping> periodSubjectMapping) {
		this.periodSubjectMapping = periodSubjectMapping;
	}	
	
}
