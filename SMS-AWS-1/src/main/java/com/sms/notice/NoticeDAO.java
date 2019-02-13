package com.sms.notice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.Notice;

public interface NoticeDAO extends JpaRepository<Notice,Integer> {

	@Query(value = "select l.mobile_number from login l,parent p,student s where s.parent_id=p.parent_id and p.login_id=l.login_id and s.school_id=?1", nativeQuery = true)
	List<String> getSchoolMobileNumbers(int schoolId);
	
	@Query(value = "select l.email_id from login l,parent p,student s where s.parent_id=p.parent_id and p.login_id=l.login_id and s.school_id=?1", nativeQuery = true)
	List<String> getSchoolEmailId(int schoolId);
 
	@Query(value = "select l.mobile_number from login l,parent p,student s,class c,section se where s.parent_id=p.parent_id and p.login_id=l.login_id and s.section_id=se.section_id and se.class_id=c.class_id and s.school_id=?1 and c.class_id=?2", nativeQuery = true)
	List<String> getClassMobileNumbers(int schoolId, int classId);

	@Query(value = "select l.email_id from login l,parent p,student s,class c,section se where s.parent_id=p.parent_id and p.login_id=l.login_id and s.section_id=se.section_id and se.class_id=c.class_id and s.school_id=?1 and c.class_id=?2", nativeQuery = true)
	List<String> getClassEmailIds(int schoolId, int classId);

	@Query(value = "select l.mobile_number from login l,parent p,student s  where s.parent_id=p.parent_id and p.login_id=l.login_id and s.school_id=?1 and s.section_id=?2", nativeQuery = true)
	List<String> getSectionMobileNumbers(int schoolId, int sectionId);

	@Query(value = "select l.email_id from login l,parent p,student s  where s.parent_id=p.parent_id and p.login_id=l.login_id and s.school_id=?1 and s.section_id=?2", nativeQuery = true)
	List<String> getSectionEmailIds(int schoolId, int sectionId);

	@Query(value = "select l.mobile_number from login l,teacher t where t.login_id=l.login_id and t.school_id=?1", nativeQuery = true)
	List<String> getTeacherMobileNumbers(int schoolId);

	@Query(value = "select l.email_id from login l,teacher t where t.login_id=l.login_id and t.school_id=?1", nativeQuery = true)
	List<String> getTeacherEmailId(int schoolId);

	@Query(value = "SELECT\r\n" + 
			"	NULL as class_name\r\n" + 
			"	,NULL as section_name\r\n" + 
			"    ,notice.notice\r\n" + 
			"    , notice.timestamp\r\n" + 
			"    , notice.type\r\n" + 
			"FROM\r\n" + 
			"    sms.notice\r\n" + 
			"    INNER JOIN sms.school \r\n" + 
			"        ON (notice.school_id = school.school_id) where school.school_id=?1 and notice.type='school' or notice.type='teacher'\r\n" + 
			"\r\n" + 
			"UNION ALL SELECT\r\n" + 
			"    class.class_name\r\n" + 
			"    ,NULL as section_name\r\n" + 
			"    , notice.notice\r\n" + 
			"    , notice.timestamp\r\n" + 
			"    , notice.type\r\n" + 
			"FROM\r\n" + 
			"    sms.notice\r\n" + 
			"    INNER JOIN sms.class \r\n" + 
			"        ON (notice.class_id = class.class_id) where notice.school_id=?1\r\n" + 
			"UNION ALL SELECT\r\n" + 
			" NULL as class_name\r\n" + 
			",section.section_id\r\n" + 
			"    , notice.notice\r\n" + 
			"    , notice.timestamp\r\n" + 
			"    , notice.type\r\n" + 
			"FROM\r\n" + 
			"    sms.notice\r\n" + 
			"    INNER JOIN sms.section \r\n" + 
			"        ON (notice.section_id = section.section_id) where notice.school_id=?1\r\n" + 
			"", nativeQuery = true)
	List<Object[]> getAllNoticeForSchoolBySchoolId(int schoolId);

	@Query(value = "SELECT\r\n" + 
			"    notice.notice\r\n" + 
			"    , notice.timestamp\r\n" + 
			"FROM\r\n" + 
			"    notice\r\n" + 
			"    INNER JOIN school \r\n" + 
			"        ON (notice.school_id = school.school_id) where school.school_id=?1 and notice.type='school' or notice.type='teacher'", nativeQuery = true)
	List<Object[]> getAllNoticeForTeacherBySchoolId(int schoolId);

	@Query(value = "	SELECT\r\n" + 
			"		NULL as class_name \r\n" + 
			"		,NULL as section_name \r\n" + 
			"	    ,notice.notice \r\n" + 
			"	    , notice.timestamp \r\n" + 
			"	    , notice.type \r\n" + 
			"	FROM \r\n" + 
			"	    sms.notice \r\n" + 
			"	    INNER JOIN sms.school  \r\n" + 
			"	        ON (notice.school_id = school.school_id) where school.school_id=?1 and notice.type='school' \r\n" + 
			"	 \r\n" + 
			"	UNION ALL SELECT \r\n" + 
			"	    class.class_name \r\n" + 
			"	    ,NULL as section_name \r\n" + 
			"	    , notice.notice \r\n" + 
			"	    , notice.timestamp \r\n" + 
			"	    , notice.type \r\n" + 
			"	FROM \r\n" + 
			"	    sms.notice \r\n" + 
			"	    INNER JOIN sms.class  \r\n" + 
			"	        ON (notice.class_id = class.class_id) where notice.school_id=?1 and class.class_id=?2\r\n" + 
			"	UNION ALL SELECT \r\n" + 
			"	 NULL as class_name \r\n" + 
			"	,section.section_id \r\n" + 
			"	    , notice.notice \r\n" + 
			"	    , notice.timestamp \r\n" + 
			"	    , notice.type \r\n" + 
			"	FROM \r\n" + 
			"	    sms.notice \r\n" + 
			"	   INNER JOIN sms.section \r\n" + 
			"	       ON (notice.section_id = section.section_id) where notice.school_id=?1 and section.section_id=?3", nativeQuery = true)
	List<Object> getAllNoticeForStudentBySchoolIdAndSectionId(int schoolId, int classId, int sectionId);


	

}
