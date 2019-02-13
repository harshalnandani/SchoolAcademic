package com.sms.admission;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sms.beans.AdmissionEnquiryForm;

public interface AdmissionDAO extends JpaRepository<AdmissionEnquiryForm,Integer> {

	@Query(value = "select admission_id,date,academic_session,student_name,studentdob,gender,class_to_admission,previous_class_passed,\r\n" + 
			"year_of_passing,medium,previous_school,previous_board,marks_obtained,achievement,fathers_name,mothers_name,\r\n" + 
			"email_id,mobile_number,address_line1,address_line2,city,district,state,pin_code from admission_enquiry_form\r\n" + 
			"where school_id=?1", nativeQuery = true)
	List<Object[]> getenquiryFormList(int schoolId);

}
