package com.sms.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sms.beans.Login;
import com.sms.exceptions.EmailIdAlreadyExistsException;
import com.sms.exceptions.InvalidAdminLoginException;
import com.sms.exceptions.InvalidLoginException;
import com.sms.exceptions.InvalidOTPException;
import com.sms.exceptions.InvalidParentEmailIdOrMobileNumberException;
import com.sms.exceptions.InvalidUserDetailsException;
import com.sms.exceptions.MobileNumberAlreadyExistsException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl {

	@Autowired
	private LoginDAOImpl loginDAOImpl;

	private Login login;

	public void checkEmailId(String emailId1) throws EmailIdAlreadyExistsException {
		if (loginDAOImpl.checkEmailId(emailId1) != null) {
			throw new EmailIdAlreadyExistsException();
		}
	}

	public Login login(String username, String password) throws InvalidLoginException {
		login = loginDAOImpl.login(username, password);
		if (login == null) {
			throw new InvalidLoginException();
		}
		return login;
	}

	public Login saveLogin(Login login2) {
		// TODO Auto-generated method stub
		return loginDAOImpl.save(login2);
	}

	public long getLoginCount() {
		return loginDAOImpl.count();
	}

	public void checkMobileNumber(String mobileNumber1) throws MobileNumberAlreadyExistsException {

		if (loginDAOImpl.checkMobileNumber(mobileNumber1) != null)
			throw new MobileNumberAlreadyExistsException();
	}

	public Login checkEmailIdMobileNumber(String emailId2, String mobileNumber2)
			throws InvalidParentEmailIdOrMobileNumberException {
		login = loginDAOImpl.checkEmailIdMobileNumber(emailId2, mobileNumber2);
		if (login == null)
			throw new InvalidParentEmailIdOrMobileNumberException();
		return login;

	}

	public void adminLogin(String emailId2, String password) throws InvalidAdminLoginException {
		if (!(emailId2.equals("prashantsahay651@gmail.com") && password.equals("prashant"))) {
			throw new InvalidAdminLoginException();
		}
		
	}
	
	public Login checkValidDetails(String detail) throws InvalidUserDetailsException {
		login = loginDAOImpl.checkValidDetails(detail);
		if(login == null){
			throw new InvalidUserDetailsException();
		}
			
		else{
			return login;
		}
		
	}

	public void checkOTPValidity(String enteredOTP, String generatedOTP) throws InvalidOTPException{
		if(!(enteredOTP.equals("abc"))){
			throw new InvalidOTPException();
		}
		
	}

	public void updatePassword(String newpassword, String email_id){
		loginDAOImpl.updatePassword(newpassword, email_id);
	}

}