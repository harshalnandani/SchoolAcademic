package com.sms.assignment;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Assignment;
import com.sms.exceptions.InvalidFileNameException;

@Controller
public class AssignmentController {

	@Autowired
	private AssignmentServiceImpl assignmentServiceImpl;
	
	@PostMapping("/WebAddAssignment")
	public RedirectView uploadQuestionPaper(@RequestParam("file") MultipartFile file,Assignment assignment,int sectionId,int subjectId,RedirectAttributes attributes,HttpSession session) {
		
		try {
			
			assignmentServiceImpl.saveAssignment(file,assignment,sectionId,subjectId,(int)session.getAttribute("teacherId"));
			attributes.addFlashAttribute("success", "Assignment Added Sucessfully");
			return new RedirectView("teacheraddassignment");
		} catch (InvalidFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid File Name");
			return new RedirectView("teacheraddassignment");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("teacheraddassignment");
		}catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("teacheraddassignment");
		}
	}
	
	@PostMapping("/WebDeleteAssignment")
	public RedirectView deleteQuestionPaper(int assignmentId,RedirectAttributes attributes) {
		
		try {
			assignmentServiceImpl.deleteAssignment(assignmentId);
			attributes.addFlashAttribute("success", "Assignment Deleted");
			return new RedirectView("listquestionpaper");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("listquestionpaper");
		}
		
		
	}
	
	
}
