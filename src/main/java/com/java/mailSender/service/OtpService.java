package com.java.mailSender.service;

public interface OtpService {
	
	void generateAndSendotp(String email);
	
	void verifyOtp(String email, String otp);
	
	

}
