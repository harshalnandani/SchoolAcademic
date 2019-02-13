package com.sms.eventcalender;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.EventCalender;
import com.sms.beans.School;
import com.sms.school.SchoolServiceImpl;

@Service
public class EventCalenderServiceImpl {

	@Autowired
	private EventCalenderDAO  eventCalenderDAO;
	
	@Autowired
	SchoolServiceImpl schoolServiceImpl;
	
	private School school;
	
	@Transactional(rollbackFor = Exception.class)
	public void addEventCalender(EventCalender eventCalender, int schoolId) {
		
		school = schoolServiceImpl.getSchoolById(schoolId);
		eventCalender.setSchool(school);
		eventCalenderDAO.save(eventCalender);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void deleteEventCalender(int id) {
		eventCalenderDAO.deleteById(id);
	}

	public List<Object[]> getViewEventCalenderBySchoolId(int schoolId) {
		return eventCalenderDAO.getViewEventCalenderBySchoolId(schoolId);
	}
}
