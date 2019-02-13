package com.sms.questionpaper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.QuestionPaper;
import com.sms.exceptions.InvalidFileNameException;

@Controller
public class QuestionPaperController {
	
	@Autowired
	private QuestionPaperServiceImpl questionPaperServiceImpl;
	
	
	
	

	@PostMapping("/WebAddQuestionPaper")
	public RedirectView uploadQuestionPaper(@RequestParam("file") MultipartFile file,QuestionPaper questionPaper,int classId,int subjectId,RedirectAttributes attributes) {
		
		try {
			questionPaperServiceImpl.saveQuestionPaper(file, questionPaper,classId,subjectId);
			attributes.addFlashAttribute("success", "Question Paper Added Sucessfully");
			return new RedirectView("addquestionpaper");
		} catch (InvalidFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invaid File Name");
			return new RedirectView("addquestionpaper");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addquestionpaper");
		}catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addquestionpaper");
		}
	}
	
	@PostMapping("/WebDeleteQuestionPaper")
	public RedirectView deleteQuestionPaper(int questionPaperId,RedirectAttributes attributes) {
		
		try {
			questionPaperServiceImpl.deleteQuestionPaper(questionPaperId);
			attributes.addFlashAttribute("success", "Question Paper Added Sucessfully");
			return new RedirectView("listquestionpaper");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("listquestionpaper");
		}
			
	}
}
