package com.sms.controllers;

import java.util.List;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sms.beans.School;
import com.sms.school.SchoolServiceImpl;

@Controller
public class AdminWebpageController {
	
	@Autowired
	private SchoolServiceImpl schoolServiceImpl;
	
	private List<Object[]> schools;
	
	private School school;
	
	@GetMapping("/admissionenquiryformbylink")
	public String admissionenquiryformbylink() {
		return "/admissionenquiryform";
	}

	@GetMapping("/adminlogin")
	public String adminlogin() {
			return "/admin/adminlogin";
	}
	
	@GetMapping("/adminhome")
	public String adminhome() {
			return "/admin/adminhome";
	}

	@GetMapping("/addschool")
	public String addschool() {
		return "/admin/addschool";
	}
	
	@GetMapping("/listschool")
	public String listschool(ServletRequest request) {
		try {
			schools=schoolServiceImpl.getSchoolList();
			request.setAttribute("schools",schools);
			return "/admin/adminlistschool";
		}catch (Exception e) {
			return "/admin/adminhome";
		}
		
	}
	
	@GetMapping("/editschool")
	public String editschool(ServletRequest request,int schoolId) {
		try {
			school=schoolServiceImpl.getSchoolById(schoolId);
			request.setAttribute("school",school);
			return "/admin/admineditschool";
		}catch (Exception e) {
			return "/admin/adminhome";
		}
		
	}

}
