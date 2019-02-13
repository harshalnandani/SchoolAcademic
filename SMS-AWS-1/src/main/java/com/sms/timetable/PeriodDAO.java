package com.sms.timetable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Period;

public interface PeriodDAO extends JpaRepository<Period,Integer> {

	@Query(value = "SELECT * from period where period_id=?1", nativeQuery = true)
	Period fetchPeriod(int periodId);

	@Query(value = "SELECT period_id,name,start_time,end_time from period where school_id=?1", nativeQuery = true)
	List<Object[]> getPeriodsBySchoolId(int schoolId);
}
