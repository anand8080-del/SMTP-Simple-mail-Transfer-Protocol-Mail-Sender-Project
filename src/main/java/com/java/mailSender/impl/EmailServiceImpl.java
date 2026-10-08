package com.java.mailSender.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.java.mailSender.service.EmailService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService{
	
	private final JavaMailSender javaMailSender;

	
	public void sendOtpEmail(String toEmail, String otp) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(toEmail);
		message.setSubject("Schollership Application Verification System"); 
		message.setText("Your OTP is: " + otp +"\n\nPlease do not share this OTP with anyone for security reasons, Otp valid for 5 minutes only.");
	    
		javaMailSender.send(message);
	        
	}
	

}
