package com.sms.timetable;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.PeriodSubjectMapping;

public interface PeriodSubjectMappingDAO extends JpaRepository<PeriodSubjectMapping,Integer> {

	@Query(value = "SELECT * from period_subject_mapping where period_subject_mapping_id=?1", nativeQuery = true)
	PeriodSubjectMapping fetchPeriodSubjectMapping(int periodSubjectMappingId);	

	@Query(value = "SELECT * from period_subject_mapping where time_table_id=?1 and period_id=?2 and subject_id=?3", nativeQuery = true)
	PeriodSubjectMapping fetchPeriodSubjectMapping(int timeTableId, int periodId, int subjectId);

	
}
