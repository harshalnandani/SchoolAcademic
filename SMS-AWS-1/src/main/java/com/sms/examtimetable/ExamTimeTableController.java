package com.sms.examtimetable;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.ExamTimeTable;
import com.sms.exceptions.InvalidFileNameException;

@Controller
public class ExamTimeTableController {
	
	@Autowired
	private ExamTimeTableServiceImpl examTimeTableServiceImpl;
	
	
	
	
	
	

	@PostMapping("/WebAddExamTimeTable")
	public RedirectView uploadQuestionPaper(@RequestParam("file") MultipartFile file,ExamTimeTable examTimeTable,int examId,int classId,RedirectAttributes attributes) {
		try {
			examTimeTableServiceImpl.saveExamTimeTable(file, examTimeTable,classId,examId);
			attributes.addFlashAttribute("success", "Exam Time Table Added Sucessfully");
			return new RedirectView("addexamtimetable");
		} catch (InvalidFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid File Name");
			return new RedirectView("addexamtimetable");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addexamtimetable");
		}catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addexamtimetable");
		}
	}
	
	@PostMapping("/WebDeleteExamTimeTable")
	public RedirectView deleteQuestionPaper(int questionPaperId,RedirectAttributes attributes) {
		try {
			examTimeTableServiceImpl.deleteExamTimeTable(questionPaperId);
			attributes.addFlashAttribute("success", "Exam Time Table Added Sucessfully");
			return new RedirectView("listexamtimetable");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("listexamtimetable");
		}
		
	}

}
