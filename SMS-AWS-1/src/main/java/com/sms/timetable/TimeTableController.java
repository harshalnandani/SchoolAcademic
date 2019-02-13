package com.sms.timetable;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Period;
import com.sms.beans.TimeTable;
import com.sms.exceptions.TimeTableAlreadyExistsException;

@Controller
public class TimeTableController {

	@Autowired
	private TimeTableServiceImpl serviceImpl;

	private int sectionId;

	private String timeTableName;

	@PostMapping("/WebAddPeriod")
	public RedirectView addPeriod(Period period, RedirectAttributes attributes, HttpSession session) {
		try {
			int schoolId = (int) session.getAttribute("schoolId");
			serviceImpl.savePeriod(schoolId, period);
			attributes.addFlashAttribute("success", "Period Added Sucessfully");
			return new RedirectView("/addperiod");
		} catch (Exception e) {
			// TODO: handle exception
			attributes.addFlashAttribute("failure", "Opps SOme Error Occurs");
			return new RedirectView("/addperiod");
		}

	}

	@PostMapping("/WebEditPeriod")
	public RedirectView deletePeriod(Period period, int periodId, int actionId, RedirectAttributes attributes,
			HttpSession session) {

		try {
			if (actionId == 1) {
				attributes.addFlashAttribute("period", serviceImpl.getPeriodById(periodId));
				return new RedirectView("/editperiod");
			}
			if (actionId == 2) {
				period = serviceImpl.editPeriod(period);
			}
			attributes.addFlashAttribute("period", period);
			attributes.addFlashAttribute("success", "Period Edited Sucessfully");
			return new RedirectView("/editperiod");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/editperiod");
		}

	}

	@PostMapping("/WebDeletePeriod")
	public RedirectView deletePeriod(Period period, RedirectAttributes attributes, HttpSession session) {

		try {
			serviceImpl.deletePeriodById(period.getPeriodId());
			attributes.addFlashAttribute("message", "Period Deleted Sucessfully");
			return new RedirectView("/deleteperiod");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/deleteperiod");
		}

	}

	@PostMapping("/WebAddTimeTable")
	public RedirectView addTimeTable(int sectionId, TimeTable timeTable, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {
		try {
			serviceImpl.checkSectionTimeTable(sectionId);
			session.setAttribute("sectionId", sectionId);
			session.setAttribute("timeTableName", timeTable.getName());
			return new RedirectView("/addperiodsubjectmapping");
		} catch (TimeTableAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Time Table For The Section Already exits");
			return new RedirectView("/addtimetable");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Failed to Add TimeTable");
			return new RedirectView("/addtimetable");
		}

	}

	@PostMapping("/WebAddPeriodSubjectMapping")
	public RedirectView schoolLogin(String[] periodId, String[] subjectId, String[] dayOftheWeek,
			ServletRequest request, HttpSession session, RedirectAttributes attributes) {

		try {
			sectionId = (int) session.getAttribute("sectionId");
			timeTableName = (String) session.getAttribute("timeTableName");
			serviceImpl.saveTimeTableWithPeriodSubjectMapping(periodId, subjectId, dayOftheWeek, sectionId,
					timeTableName);
			attributes.addFlashAttribute("success", "Added PeriodSubject Mapping");
			return new RedirectView("/addperiodsubjectmapping");
		} catch (Exception e) {
			// TODO: handle exception
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/addtimetable");
		}
	}

	@PostMapping("/WebViewTimeTable")
	public RedirectView viewTimeTable(int sectionId, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {

		try {
			int schoolId = (int) session.getAttribute("schoolId");
			session.setAttribute("periods", serviceImpl.getPeriodsBySchoolId(schoolId));
			System.out.println(serviceImpl.getPeriodsBySchoolId(schoolId).size());
			session.setAttribute("sectionId", sectionId);
			System.out.println(sectionId);
			session.setAttribute("timetableobject", serviceImpl);
			return new RedirectView("/viewtimetablefront");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/viewtimetablefront");
		}

	}
	
	@PostMapping("/WebTeacherViewTimeTable")
	public RedirectView teacherViewTimeTable(int sectionId, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {

		try {
			int schoolId = (int) session.getAttribute("teacherSchoolId");
			session.setAttribute("periods", serviceImpl.getPeriodsBySchoolId(schoolId));
			session.setAttribute("sectionId", sectionId);
			session.setAttribute("timetableobject", serviceImpl);
			return new RedirectView("/teacherviewclasstimetable");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/teacherviewclasstimetable");
		}

	}
}
