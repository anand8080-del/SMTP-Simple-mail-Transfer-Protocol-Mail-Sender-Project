package com.java.mailSender.service;

public interface EmailService {
	
	void sendOtpEmail(String toEmail, String otp);
}
