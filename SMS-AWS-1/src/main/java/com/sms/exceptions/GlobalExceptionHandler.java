package com.sms.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public RedirectView handleMyException(Exception ex, HttpServletRequest request, HttpServletResponse response,
			HttpSession session, RedirectAttributes attributes) {
		if (session.getAttribute("user") != null) {
			if (session.getAttribute("user").equals("school")) {
				attributes.addFlashAttribute("failure", "Something Went Wrong");
				return new RedirectView("/schoolhome");
			}else if(session.getAttribute("user").equals("teacher")) {
				attributes.addFlashAttribute("failure", "Something Went Wrong");
				return new RedirectView("/teacherhome");
			}else if(session.getAttribute("user").equals("parent")) {
				attributes.addFlashAttribute("failure", "Something Went Wrong");
				return new RedirectView("/parenthome");
			}
		} else {
			attributes.addFlashAttribute("failure", "Session Expired PLease Login Again");
			return new RedirectView("/");
		}
			attributes.addFlashAttribute("failure", "Something Went Wrong");
			return new RedirectView("/");
	}

}
