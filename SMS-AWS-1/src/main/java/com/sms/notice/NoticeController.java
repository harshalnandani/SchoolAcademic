package com.sms.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Notice;

@Controller
public class NoticeController {

	@Autowired
	private NoticeServiceImpl noticeServiceImpl;

	private int schoolId;

	private Notice notice1;

	@PostMapping("WebSendSchoolNotice")
	public RedirectView sendSchoolNotice(String notice, HttpSession session, RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		notice1=new Notice();
		notice1.setNotice(notice);
		notice1 = noticeServiceImpl.saveSchoolNotice(schoolId, notice1);

		if (notice1 == null) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("sendnotice");
		}
		attributes.addFlashAttribute("success", "Notice Send Successfully");
		return new RedirectView("sendnotice");
	}
	
	@PostMapping("WebSendClassNotice")
	public RedirectView sendClassNotice(String notice, HttpSession session, RedirectAttributes attributes,int classId) {
		schoolId = (int) session.getAttribute("schoolId");
		notice1=new Notice();
		notice1.setNotice(notice);
		notice1 = noticeServiceImpl.saveClassNotice(schoolId, notice1,classId);

		if (notice1 == null) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("sendnotice");
		}
		attributes.addFlashAttribute("success", "Notice Send Successfully");
		return new RedirectView("sendnotice");
	}
	
	@PostMapping("WebSendSectionNotice")
	public RedirectView sendSectionNotice(String notice, HttpSession session, RedirectAttributes attributes,int sectionId) {
		schoolId = (int) session.getAttribute("schoolId");
		notice1=new Notice();
		notice1.setNotice(notice);
		notice1 = noticeServiceImpl.saveSectionNotice(schoolId, notice1,sectionId);

		if (notice1 == null) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("sendnotice");
		}
		attributes.addFlashAttribute("success", "Notice Send Successfully");
		return new RedirectView("sendnotice");
	}
	
	@PostMapping("WebSendTeacherNotice")
	public RedirectView sendTeacherNotice(String notice, HttpSession session, RedirectAttributes attributes) {
		schoolId = (int) session.getAttribute("schoolId");
		notice1=new Notice();
		notice1.setNotice(notice);
		notice1 = noticeServiceImpl.saveTeacherNotice(schoolId, notice1);

		if (notice1 == null) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("sendnotice");
		}
		attributes.addFlashAttribute("success", "Notice Send Successfully");
		return new RedirectView("sendnotice");
	}

}
