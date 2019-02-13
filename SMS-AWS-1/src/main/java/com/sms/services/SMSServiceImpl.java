package com.sms.services;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.login.LoginServiceImpl;

@Service
public class SMSServiceImpl {

	private static final String ALPHA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom random = new SecureRandom();

	@Autowired
	private LoginServiceImpl loginServiceImpl;

	private long count;

	public String generatePassword() {
		String result = "";
		for (int i = 0; i < 10; i++) {
			int index = random.nextInt(ALPHA.length());
			result += ALPHA.charAt(index);
		}
		return result;
	}

	public String generateUsername(String name) {
		count = loginServiceImpl.getLoginCount();
		String[] parts = name.split(" ");
		return parts[0].substring(0, 1) + parts[parts.length - 1].substring(0, 1) + String.format("%04d",count);
	}
	
	public String generateOTP(){
		String OTP="";
		for(int i=0; i<6; i++){
			int index=random.nextInt(ALPHA.length());
			OTP+=ALPHA.charAt(index);
		}
		return OTP;
	}
	
	

}
