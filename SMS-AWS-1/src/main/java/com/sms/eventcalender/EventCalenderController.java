package com.sms.eventcalender;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.EventCalender;

@Controller
public class EventCalenderController {

	@Autowired
	EventCalenderServiceImpl eventCalenderServiceImpl;

	

	private int schoolId;

	

	@PostMapping("/WebAddEventCalender")
	public RedirectView addEventCalender(HttpSession session, RedirectAttributes attributes,
			EventCalender eventCalender) {
		try {
			schoolId = (int) session.getAttribute("schoolId");
			eventCalenderServiceImpl.addEventCalender(eventCalender,schoolId);
			attributes.addFlashAttribute("success", "Event Added Sucessfully");
			return new RedirectView("addeventcalender");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addeventcalender");
		}

	}

	@PostMapping("/WebDeleteEventCalender")
	public RedirectView deleteEventCalender(HttpSession session, RedirectAttributes attributes, int eventCalenderId) {
		try {
			eventCalenderServiceImpl.deleteEventCalender(eventCalenderId);
			attributes.addFlashAttribute("success", "Event Calender Deleted Sucessfully");
			return new RedirectView("listeventcalender");
		} catch (Exception exception) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("listeventcalender");
		}
	}

}
