package com.sms.services;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void sendNewRegistrationMail(String name,String emailId,String mobileNumber,String username,String password) throws MessagingException {
			String htmlMsg = "<div style=\"background-color:#e0ebeb;padding:30px;width:50%;margin-left:25%;\">\r\n" + 
					"<div style=\"background-color:white;padding:15px;\">\r\n" + 
					"<h1 style=\"text-align:center;\">School Academic</h1>\r\n" + 
					"\r\n" + 
					"<h3>Hi "+name+",</h3>\r\n" + 
					"<p><strong>This is Confirmation For Your Registration</strong></p>\r\n" + 
					"\r\n" + 
					"<p><strong>Your Login Details Are As Follow</strong></p>\r\n" + 
					"\r\n" + 
					"<div style=\"line-height:5px;margin-left:15px;\">\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Email Id:-</span>"+emailId+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Mobile Number:-</span>"+mobileNumber+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Username:-</span>"+username+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Password:-</span>"+password+"</p>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<p style=\"text-align:center;color:red;\">Please Don't Share Password With Anyone</p>\r\n" + 
					"\r\n" + 
					"<div style=\"margin-left:35%;\"><a href=\"\"><button style=\"background-color:#669999;border: none;color:white; padding: 8px 16px;font-size: 16px;font-weight:bold;border-radius:4px;\">Click Here To Login</button></a></div>\r\n" + 
					"\r\n" + 
					"<p><strong>Thanks And Regards</strong></p>\r\n" + 
					"<p>Prashant Kumar Sahay</p>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"";
			sendMail(htmlMsg, emailId, "Registration Confirmation");
	}
	
	public void sendNewStudentRegistrationWithoutParent(String name,String emailId,String password,String username) throws MessagingException {
			String htmlMsg = "<div style=\"background-color:#e0ebeb;padding:30px;width:50%;margin-left:25%;\">\r\n" + 
					"<div style=\"background-color:white;padding:15px;\">\r\n" + 
					"<h1 style=\"text-align:center;\">School Management System</h1>\r\n" + 
					"\r\n" + 
					"<h3>Hi "+name+",</h3>\r\n" + 
					"<p><strong>This is Confirmation For Your Registration</strong></p>\r\n" + 
					"\r\n" + 
					"<p><strong>Your Login Details Are As Follow</strong></p>\r\n" + 
					"\r\n" + 
					"<div style=\"line-height:5px;margin-left:15px;\">\r\n" + 
					
					"<p><span style=\"color:#669999;font-weight:bold;\">Username:-</span>"+username+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Password:-</span>"+password+"</p>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<p style=\"text-align:center;color:red;\">Please Don't Share Password With Anyone</p>\r\n" + 
					"\r\n" + 
					"<div style=\"margin-left:35%;\"><a href=\"\"><button style=\"background-color:#669999;border: none;color:white; padding: 8px 16px;font-size: 16px;font-weight:bold;border-radius:4px;\">Click Here To Login</button></a></div>\r\n" + 
					"\r\n" + 
					"<p><strong>Thanks And Regards</strong></p>\r\n" + 
					"<p>Prashant Kumar Sahay</p>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"";
			sendMail(htmlMsg, emailId, "Registration Confirmation");
	}
	
	
	public void sendNewStudentRegistrationWithParent(String name,String parentEmailId,String parentMobileNumber,String parentUsername,String parentPassword,String studentUsername,String studentPassword) throws MessagingException {
			String htmlMsg = "<div style=\"background-color:#e0ebeb;padding:30px;width:50%;margin-left:25%;\">\r\n" + 
					"<div style=\"background-color:white;padding:15px;\">\r\n" + 
					"<h1 style=\"text-align:center;\">School Management System</h1>\r\n" + 
					"\r\n" + 
					"<h3>Hi "+name+",</h3>\r\n" + 
					"<p><strong>This is Confirmation For Your Registration</strong></p>\r\n" + 
					"\r\n" + 
					"<p><strong>Your Login Details Are As Follow</strong></p>\r\n" + 
					"\r\n" + 
					"<h3>Parent Login Details : -</h3>\r\n" + 
					"<div style=\"line-height:5px;margin-left:15px;\">\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Email Id:-</span>"+parentEmailId+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Mobile Number:-</span>"+parentMobileNumber+"</p>\r\n" +
					"<p><span style=\"color:#669999;font-weight:bold;\">Username:-</span>"+parentUsername+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Password:-</span>"+parentPassword+"</p>\r\n" + 
					"</div>\r\n"+
					"<h3>Student Login Details : -</h3>\r\n" + 
					"<div style=\"line-height:5px;margin-left:15px;\">\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Username:-</span>"+studentUsername+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Password:-</span> "+studentPassword+"</p>\r\n" + 
					"</div>" + 
					
					"\r\n" + 
					"<p style=\"text-align:center;color:red;\">Please Don't Share Password With Anyone</p>\r\n" + 
					"\r\n" + 
					"<div style=\"margin-left:35%;\"><a href=\"\"><button style=\"background-color:#669999;border: none;color:white; padding: 8px 16px;font-size: 16px;font-weight:bold;border-radius:4px;\">Click Here To Login</button></a></div>\r\n" + 
					"\r\n" + 
					"<p><strong>Thanks And Regards</strong></p>\r\n" + 
					"<p>Prashant Kumar Sahay</p>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"";
			sendMail(htmlMsg, parentEmailId, "Registration Confirmation");
	}
	
	
	
	
	public void newSchoolRegistrationMail(String emailId,String password,String username,String mobileNumber) throws MessagingException {
			String htmlMsg = "<div style=\"background-color:#e0ebeb;padding:30px;width:50%;margin-left:25%;\">\r\n" + 
					"<div style=\"background-color:white;padding:15px;\">\r\n" + 
					"<h1 style=\"text-align:center;\">School Management System</h1>\r\n" + 
					"\r\n" + 
					"<h3>Hi,Prashant !</h3>\r\n" + 
					"<p><strong>This is Confirmation For Your Registration</strong></p>\r\n" + 
					"\r\n" + 
					"<p><strong>Your Login Details Are As Follow</strong></p>\r\n" + 
					"\r\n" + 
					"<div style=\"line-height:5px;margin-left:15px;\">\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Email Id:-</span>"+emailId+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Mobile Number:-</span>"+mobileNumber+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Username:-</span>"+username+"</p>\r\n" + 
					"<p><span style=\"color:#669999;font-weight:bold;\">Password:-</span>"+password+"</p>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<p style=\"text-align:center;color:red;\">Please Don't Share Password With Anyone</p>\r\n" + 
					"\r\n" + 
					"<div style=\"margin-left:35%;\"><a href=\"\"><button style=\"background-color:#669999;border: none;color:white; padding: 8px 16px;font-size: 16px;font-weight:bold;border-radius:4px;\">Click Here To Login</button></a></div>\r\n" + 
					"\r\n" + 
					"<p><strong>Thanks And Regards</strong></p>\r\n" + 
					"<p>Prashant Kumar Sahay</p>\r\n" + 
					"</div>\r\n" + 
					"</div>\r\n" + 
					"";
			sendMail(htmlMsg, emailId, "Registration Confirmation");
	}

	public void sendAdmissionEnquiryMail(int schoolId, String emailId) throws MessagingException {
		
		String htmlMsg = "http://www.schoolacademic.com/admissionenquiryformbylink?schoolId="+schoolId+"";
		sendMail(htmlMsg, emailId,"Enquiry Form Link");
		
	}
	
	private void sendMail(String message,String emailId,String subject) throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper;
		helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
		helper.setText(message, true);
		helper.setFrom("admin@schoolacademic.com");
		helper.setTo(emailId);
		helper.setSubject(subject);
		javaMailSender.send(mimeMessage);
	}

}