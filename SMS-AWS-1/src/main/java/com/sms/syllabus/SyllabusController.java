package com.sms.syllabus;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Syllabus;
import com.sms.exceptions.InvalidFileNameException;

@Controller
public class SyllabusController {
	
	@Autowired
	private SyllabusServiceImpl syllabusServiceImpl;
	
	
	
	

	@PostMapping("/WebAddSyllabus")
	public RedirectView uploadSyllabus(@RequestParam("file") MultipartFile file,Syllabus syllabus,int classId,int subjectId,RedirectAttributes attributes) {
		try {
			syllabusServiceImpl.saveSyllabus(file, syllabus,classId,subjectId);
			attributes.addFlashAttribute("success", "Question Paper Added Sucessfully");
			return new RedirectView("addsyllabus");
		} catch (InvalidFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid File Name");
			return new RedirectView("addsyllabus");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addsyllabus");
		}catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addsyllabus");
		}
	}
	
	@PostMapping("/WebDeleteSyllabus")
	public RedirectView deleteSyllabus(int questionPaperId,RedirectAttributes attributes) {
		
		try {
			syllabusServiceImpl.deleteSyllabus(questionPaperId);
			attributes.addFlashAttribute("success", "Question Paper Added Sucessfully");
			return new RedirectView("listsyllabus");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("listsyllabus");
		}
		
		
	}

}
