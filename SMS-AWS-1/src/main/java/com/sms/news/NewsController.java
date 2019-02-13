package com.sms.news;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.News;
import com.sms.exceptions.InvalidFileNameException;

@Controller
public class NewsController {

	@Autowired
	private NewsServiceImpl newsServiceImpl;

	private int schoolId;

	@PostMapping("/WebAddNews")
	public RedirectView AddNews(@RequestParam("file") MultipartFile file, News news, ServletRequest request,
			HttpSession session, RedirectAttributes attributes) {
		try {
			schoolId = (int) session.getAttribute("schoolId");
			newsServiceImpl.addNews(news, file, schoolId);
			attributes.addFlashAttribute("success", "News Added Sucessfully");
			return new RedirectView("addnews");
		} catch (InvalidFileNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid File Name Wrong");
			return new RedirectView("addnews");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addnews");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("addnews");
		}

	}

	@PostMapping("/WebDeleteNews")
	public RedirectView deleteNews(int newsId, ServletRequest request, HttpSession session,
			RedirectAttributes attributes) {

		try {
			newsServiceImpl.deleteNews(newsId);
			attributes.addFlashAttribute("success", "News Deleted Sucessfully");
			return new RedirectView("viewnews");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("viewnews");
		}

	}

	@PostMapping("/WebEditNews")
	public RedirectView editNews(News news, ServletRequest request, HttpSession session, RedirectAttributes attributes,
			int newsId, int actionId) {
		try {
			if (actionId == 1) {
				news = newsServiceImpl.getNewsById(newsId);
				session.setAttribute("news", news);
				return new RedirectView("editnews");
			}
			newsServiceImpl.editNews(news);
			attributes.addFlashAttribute("success", "News Edited Sucessfully");
			return new RedirectView("editnews");
		} catch (Exception e) {
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("editnews");
		}

	}

}
