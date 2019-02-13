package com.sms.login;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.sms.beans.Login;
import com.sms.exceptions.InvalidAdminLoginException;
import com.sms.exceptions.InvalidLoginException;
import com.sms.exceptions.InvalidOTPException;
import com.sms.exceptions.InvalidUserDetailsException;
import com.sms.school.SchoolServiceImpl;
import com.sms.services.MobileSMSServiceImpl;
import com.sms.services.SMSServiceImpl;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private LoginServiceImpl loginSericeImpl;
	
	@Autowired 
	private SchoolServiceImpl schoolServiceImpl;

	private Login login;
	
	@Autowired
	private SMSServiceImpl smsServiceImpl;
	
	@Autowired
	private MobileSMSServiceImpl mobileSMSServiceImpl;
	
	@RequestMapping("/ForgPass")
	public ModelAndView forgotPassword(ServletRequest request, HttpSession session,
	RedirectAttributes attributes) {
		
		return new ModelAndView("forgotpassword");
	}
	
	@PostMapping("/SendOTP")
	public ModelAndView getOTP(RedirectAttributes attributes, HttpServletRequest request, HttpSession session) {
		try{
			String detail=request.getParameter("details");
			login = loginSericeImpl.checkValidDetails(detail);
			//System.out.println(login.getEmailId());
			String OTP=smsServiceImpl.generateOTP();
			System.out.println("OTP:"+OTP);
			String MobileNumber=login.getMobileNumber();
			
			session.setAttribute("generatedOTP",OTP);
			mobileSMSServiceImpl.sendOTPMessage(OTP,MobileNumber);
			return new ModelAndView("enterOTP");
		}
		catch(InvalidUserDetailsException e){
			e.printStackTrace();
			attributes.addFlashAttribute("failure", "Invalid Detail");
			//System.out.println("Exception");
			return new ModelAndView("login");
		}
	}
	
	@PostMapping("/ChangePass")
	public ModelAndView changepasssword(RedirectAttributes attributes, HttpServletRequest request, HttpSession session) {
		try{
			String enteredOTP=request.getParameter("enteredOTP");
			String generatedOTP=(String)session.getAttribute("generatedOTP");
			loginSericeImpl.checkOTPValidity(enteredOTP,generatedOTP);
			return new ModelAndView("changepassword");
		}
		catch(InvalidOTPException e){
			e.printStackTrace();
			attributes.addFlashAttribute("failure","Invalid OTP");
			return new ModelAndView("login");
		}
		
	}
	
	@PostMapping("/NewPass")
	public ModelAndView newpassword(RedirectAttributes attributes, HttpServletRequest request){
		try{
			String newpassword=request.getParameter("newpassword");
			String email_id=login.getEmailId();
			System.out.print(email_id);
			loginSericeImpl.updatePassword(newpassword,email_id);
			return new ModelAndView("login");
		}
		catch(Exception e){
			e.printStackTrace();
			attributes.addFlashAttribute("Something Went Wrong");
			return new ModelAndView("login");
		}
	}

}
