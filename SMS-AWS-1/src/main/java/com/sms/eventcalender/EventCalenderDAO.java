package com.sms.eventcalender;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.EventCalender;

public interface EventCalenderDAO extends JpaRepository<EventCalender,Integer> {

	@Query(value = "SELECT event_calender_id,event_date,event_name from event_calender where school_id=?1", nativeQuery = true)
	List<Object[]> getViewEventCalenderBySchoolId(int schoolId);

}
