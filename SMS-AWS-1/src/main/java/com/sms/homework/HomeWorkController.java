package com.sms.homework;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.HomeWork;
import com.sms.beans.Student;

@Controller
public class HomeWorkController {

	

	@Autowired
	private HomeWorkServiceImpl homeWorkServiceImpl;
	
	private int teacherId;

	

	@PostMapping("/WebAddHomeWork")
	public RedirectView uploadQuestionPaper(HomeWork homeWork, int sectionId, int subjectId,
			RedirectAttributes attributes, HttpSession session) {
		
		try {
			teacherId=(int) session.getAttribute("teacherId");
			homeWorkServiceImpl.saveHomeWork(homeWork,sectionId,subjectId,teacherId);
			attributes.addFlashAttribute("success", "HomeWork Added Sucessfully");
			return new RedirectView("teacherhomework");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("teacherhomework");
		}
	}

	@GetMapping("/WebGetTeacherHomeWork")
	@ResponseBody
	public void getTeacherHomeWork(String user_id, ServletResponse response, HttpSession session) {
		int teacherId = (int) session.getAttribute("teacherId");
		List<Object[]> list = homeWorkServiceImpl.getHomeWorkByTeacherIdandDate(user_id, teacherId);
		System.out.println(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			if (list.size() == 0) {

				out.print("<tr>");
				out.print("<td colspan='6'>No Data Avaliable</td>");
				out.print("</tr>");

			} else {
				for (Object[] section : list) {
					out.print("<tr>");
					out.print("<td>" + section[0] + "</td>");
					out.print("<td>" + section[1] + "</td>");
					out.print("<td>" + section[2] + "</td>");
					out.print("<td>" + section[3] + "</td>");
					out.print("<td>" + section[4] + "</td>");
					out.print("<td>" + section[5] + "</td>");
					out.print("</tr>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@GetMapping("/WebGetSectionHomeWork")
	@ResponseBody
	public void getSectionHomeWork(String user_id, int sectionId,ServletResponse response, HttpSession session) {
		System.out.println(sectionId);
		List<Object[]> list = homeWorkServiceImpl.getHomeWorkBySectionIdandDate(user_id, teacherId);
		System.out.println(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			if (list.size() == 0) {

				out.print("<tr>");
				out.print("<td colspan='6'>No Data Avaliable</td>");
				out.print("</tr>");

			} else {
				for (Object[] section : list) {
					out.print("<tr>");
					out.print("<td>" + section[0] + "</td>");
					out.print("<td>" + section[1] + "</td>");
					out.print("<td>" + section[2] + "</td>");
					out.print("<td>" + section[3] + "</td>");
					out.print("</tr>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@GetMapping("/WebGetParentHomeWork")
	@ResponseBody
	public void getParentHomeWork(String user_id, ServletResponse response, HttpSession session) {
		Student student =(Student) session.getAttribute("currentstudent");
		int sectionId = student.getSection().getSectionId();
		System.out.println(sectionId);
		List<Object[]> list = homeWorkServiceImpl.getHomeWorkBySectionIdandDate(user_id,sectionId);
		System.out.println(user_id);
		PrintWriter out;
		try {
			out = response.getWriter();
			if (list.size() == 0) {

				out.print("<tr>");
				out.print("<td colspan='6'>No Data Avaliable</td>");
				out.print("</tr>");

			} else {
				for (Object[] section : list) {
					out.print("<tr>");
					out.print("<td>" + section[0] + "</td>");
					out.print("<td>" + section[1] + "</td>");
					out.print("<td>" + section[2] + "</td>");
					out.print("<td>" + section[3] + "</td>");
					out.print("</tr>");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
