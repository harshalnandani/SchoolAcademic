package com.sms.school;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sms.beans.School;

@Repository
public interface SchoolDAO extends JpaRepository<School, Integer> {
	
	 @Query(value = "SELECT * FROM school2 where email_id=?1 and password=?2", nativeQuery = true)
	 School schoolLogin(String emailId,String password);

	@Query(value = "SELECT email_id from school2 where email_id=?1", nativeQuery = true)
	String checkCheckEmailId(String emailId);

	@Query(value = "select \r\n" + 
			"s.school_id,\r\n" + 
			"s.school_name,\r\n" + 
			"l.mobile_number,\r\n" + 
			"l.email_id,\r\n" + 
			"s.address_line1,\r\n" + 
			"s.address_line2,\r\n" + 
			"s.city,\r\n" + 
			"s.district,\r\n" + 
			"s.state,\r\n" + 
			"s.pin_code\r\n" + 
			"from \r\n" + 
			"school s,\r\n" + 
			"login l\r\n" + 
			"where\r\n" + 
			"l.login_id=s.login_id", nativeQuery = true)
	List<Object[]> getSchoolList();

	
	
	

}
