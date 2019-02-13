package com.sms.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MobileSMSServiceImpl {

	@Value("${smsProperties.username}")
	private String username;
	@Value("${smsProperties.password}")
	private String password;
	@Value("${smsProperties.senderid}")
	private String senderid;
	@Value("${smsProperties.route}")
	private String route;

	

	public void sendRegistrationMail(String name, String emailId, String mobileNumber, String username1,
			String password1) {
		String message = "Hi " + name + ",\n" + "You Are Sucessfully Registered With Following Details:\n"
				+ "Email Id: " + emailId + "\n" + "Mobile Number: " + mobileNumber + "\n"
				+ "User Name: " + username1 + "\n" + "Password: " + password1 + "\n"
				+ "Login Url: http://www.schoolacademic.com/ \n" + "PLease Don't Share Login Detail's With Anyone";
		sendMessage(mobileNumber, message);
	}

	public void sendAdmissionEnquiryFormLink(int schoolId, String mobileNumber) {
		String message = "Please Click On The Link To Fill Form: \n"
				+ "http://www.schoolacademic.com/admissionenquiryformbylink?schoolId=" + schoolId + "";
		sendMessage(mobileNumber, message);
	}

	public void sendMessage(String mobileNumber, String message) {
		String url = "http://spwpl.com/http-api.php?username=" +this.username+ "&password=" +this.password+ "&senderid="
				+ this.senderid + "&route=" + this.route + "";
		RestTemplate restTemplate = new RestTemplate();
		Object result = restTemplate.getForObject(url + "&number=" + mobileNumber + "&message=" + message + "",
				String.class);
		System.out.println(result);
	}
	
	public void sendOTPMessage(String OTP, String mobileNumber){
		String message="Your OTP is: "+OTP;
		sendMessage(mobileNumber,message);
	}

}
