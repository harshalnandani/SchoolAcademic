package com.sms.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;


import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceClientBuilder;
import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

public class Sendsms {

	
	
	

	
	

	/**
	 * This method is used to use SES java client to send email
	 * 
	 * @param from - recipient of email
	 * @param to
	 * @param cc
	 * @param subject
	 * @param content
	 * @param contentType html or text
	 */
	public static boolean sendEmail(String from, List<String> to, List<String> cc, String subject, String content, String contentType) {
		AmazonSimpleEmailService sesClient;
		AWSCredentials credentials = new BasicAWSCredentials("AKIAJ34JLUG2AMSBC2RA","2SY36mVYB920tcTkd8eM35Depj5EH/Yq+Mjdb6eR");
    	AWSCredentialsProvider p = new AWSStaticCredentialsProvider(credentials);
    	sesClient = 
          AmazonSimpleEmailServiceClientBuilder.standard()
          	.withCredentials(p)
            .withRegion(Regions.US_EAST_1).build();
		boolean emailSendSuccess = false;
		Body emailBody;
		Message emailMessage = null;
		Destination emailDestination = null;
		try {
			//validation from and to email mandatory
			if (from == null || from.isEmpty()) {
				System.out.println("Missing from:");
				return emailSendSuccess;
			}
			
			if (to == null || to.isEmpty()) {
				System.out.println("Missing to:");
				return emailSendSuccess;
			}
			
			System.out.println("from [" + from + "] to [" + to.toString() + "] cc [" + cc.toString() + "] subject [" + subject + 
					"] contentType [" + contentType + "] content [" + content + "]");
			
			emailDestination = new Destination();
			emailDestination.setToAddresses(to);
			if (cc != null && !cc.isEmpty()) {
				emailDestination.setCcAddresses(cc);
			}
			
			emailBody = new Body();
			if (contentType.equalsIgnoreCase("html")) {
				emailBody.withHtml(new Content().withCharset("UTF-8").withData(content));
			}
			else if (contentType.equalsIgnoreCase("text")) {
				emailBody.withText(new Content().withCharset("UTF-8").withData(content));
			}
			else {
				//invalid contentType
			}
			
			emailMessage = new Message();
			emailMessage.setBody(emailBody);
			emailMessage.setSubject(new Content().withCharset("UTF-8").withData(subject));
			
			SendEmailRequest request = new SendEmailRequest()
			          .withDestination(emailDestination)
			          .withMessage(emailMessage)
			          .withSource(from);
			sesClient.sendEmail(request);
			System.out.println("Email sent!");
			emailSendSuccess = true;
		}
		catch (Throwable t) {
			t.printStackTrace();
			emailSendSuccess = false;
		}
		
		return emailSendSuccess;
	}
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("prashantsahay651@gmail.com");
		sendEmail("admin@schoolacademic.com",list,list, "prashantsahay651@gmail.com", "prashantsahay651@gmail.com", "html");
	}
}
	
