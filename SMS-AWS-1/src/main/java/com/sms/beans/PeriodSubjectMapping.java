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
public class PeriodSubjectMapping {	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int periodSubjectMappingId;
	
	/* Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday */
	private String dayOfWeek;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "time_table_id")
	private TimeTable timeTable;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "period_id")
	private Period period;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public TimeTable getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(TimeTable timeTable) {
		this.timeTable = timeTable;
	}

	public int getPeriodSubjectMappingId() {
		return periodSubjectMappingId;
	}

	public void setPeriodSubjectMappingId(int periodSubjectMappingId) {
		this.periodSubjectMappingId = periodSubjectMappingId;
	}

	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}	
}
