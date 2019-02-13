package com.sms.timetable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sms.beans.Period;
import com.sms.beans.PeriodSubjectMapping;
import com.sms.beans.School;
import com.sms.beans.Section;
import com.sms.beans.Subject;
import com.sms.beans.TimeTable;
import com.sms.exceptions.TimeTableAlreadyExistsException;
import com.sms.school.SchoolDAO;
import com.sms.section.SectionServiceImpl;
import com.sms.subject.SubjectDAOImpl;

@Service
public class TimeTableServiceImpl {

	@Autowired
	private PeriodDAO periodDAO;

	@Autowired
	private TimeTableDAO timeTableDAO;

	@Autowired
	private PeriodSubjectMappingDAO periodSubjectMappingDAO;

	@Autowired
	private SubjectDAOImpl subjectDAO;

	@Autowired
	private SectionServiceImpl sectionServiceImpl;


	@Autowired
	private SchoolDAO schoolDAO;

	private School school;

	private Section section;

	private String timeTableName;

	private PeriodSubjectMapping periodSubjectMapping;

	private Period period;
	private Subject subject;
	
	private TimeTable timeTable;

	@Transactional(rollbackFor = Exception.class)
	public void savePeriod(int schoolId, Period period) {
		school = schoolDAO.getOne(schoolId);
		period.setSchool(school);
		periodDAO.save(period);
	}

	public void deletePeriodById(int periodId) {
		periodDAO.deleteById(periodId);
	}

	public Period getPeriodById(int periodId) {
		return periodDAO.fetchPeriod(periodId);
	}

	public void checkSectionTimeTable(int sectionId) throws TimeTableAlreadyExistsException {
		timeTableName = timeTableDAO.checkSectionTimeTable(sectionId);
		if (timeTableName != null) {
			throw new TimeTableAlreadyExistsException();
		}
	}

	@Transactional(rollbackFor = Exception.class)
	public TimeTable saveTimeTable(int sectionId, String timeTableName2) {
		timeTable=new TimeTable();
		timeTable.setName(timeTableName2);
		section = sectionServiceImpl.getSectionById(sectionId);
		timeTable.setSection(section);
		return timeTableDAO.save(timeTable);
	}

	@Transactional(rollbackFor = Exception.class)
	public PeriodSubjectMapping savePeriodSubjectMapping(TimeTable timeTable, int periodId, int subjectId,
			String dayOfWeek) {

		period = periodDAO.fetchPeriod(periodId);
		subject = subjectDAO.fetchSubjectById(subjectId);
		periodSubjectMapping = new PeriodSubjectMapping();
		periodSubjectMapping.setPeriod(period);
		periodSubjectMapping.setSubject(subject);
		periodSubjectMapping.setTimeTable(timeTable);
		periodSubjectMapping.setDayOfWeek(dayOfWeek);
		periodSubjectMapping = periodSubjectMappingDAO.save(periodSubjectMapping);

		return periodSubjectMapping;
	}
	
	
	

	@Transactional(rollbackFor = Exception.class)
	public void deletePeriodSubjectMapping(int periodSubjectMappingId) {
		periodSubjectMappingDAO.deleteById(periodSubjectMappingId);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deletePeriodSubjectMapping(int timeTableId, int periodId, int subjectId) {
		PeriodSubjectMapping periodSubjectMapping = periodSubjectMappingDAO.fetchPeriodSubjectMapping(timeTableId,
				periodId, subjectId);
		periodSubjectMappingDAO.deleteById(periodSubjectMapping.getPeriodSubjectMappingId());
	}

	public List<Object[]> getPeriodsBySchoolId(int schoolId) {

		return periodDAO.getPeriodsBySchoolId(schoolId);
	}

	@Transactional(rollbackFor = Exception.class)
	public Period editPeriod(Period period) {
		Period period2 = periodDAO.getOne(period.getPeriodId());
		period2.setName(period.getName());
		period2.setStartTime(period.getStartTime());
		period2.setEndTime(period.getEndTime());
		return periodDAO.save(period2);

	}

	public TimeTable getTimeTableBySectionId(int sectionId) {

		return timeTableDAO.getTimeTableBySectionId(sectionId);
	}

	public List<Object[]> getTimeTableByPeriodDaySection(int periodId, int sectionId, String dayOfTheWeek) {
		System.out.println(periodId);
		System.out.println(sectionId);
		System.out.println(dayOfTheWeek);
		return timeTableDAO.getTimeTableByPeriodDaySection(periodId, sectionId, dayOfTheWeek);
	}

	public List<Object[]> getTimeTableByPeriodDayTeacher(int periodId, int teacherId, String dayOfTheWeek) {
		return timeTableDAO.getTimeTableByPeriodDayTeacher(periodId, teacherId, dayOfTheWeek);
	}

	@Transactional(rollbackFor = Exception.class)
	public void saveTimeTableWithPeriodSubjectMapping(String[] periodId, String[] subjectId, String[] dayOftheWeek,
			int sectionId, String timeTableName2) {
		timeTable = saveTimeTable(sectionId, timeTableName2);
				for (int i = 0; i < periodId.length; i++) {
				savePeriodSubjectMapping(timeTable, Integer.parseInt(periodId[i]),
							Integer.parseInt(subjectId[i]), dayOftheWeek[i]);
				}
		
	}
}
