package com.java.mailSender.impl;

import java.security.SecureRandom;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.mailSender.entity.OtpVerification;
import com.java.mailSender.repository.OtpVerificationRepository;
import com.java.mailSender.service.EmailService;
import com.java.mailSender.service.OtpService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService{
	
	@Autowired
	private final OtpVerificationRepository otpVerificationRepository;
	
	@Autowired
	private final EmailService emailService;
	private final SecureRandom random = new SecureRandom();  // this class used for the generate a random numbers 

	@Override
	public void generateAndSendotp(String email) {
		
		String otp = String.format("%06d", random.nextInt(1_000_000)); //generate a 6 digits of OTP
		
		OtpVerification otpVerification = new OtpVerification();
		otpVerification.setEmail(email);
		otpVerification.setOtp(otp);
		otpVerification.setExpires(LocalDateTime.now().plusMinutes(5));
		otpVerification.setVerified(false);
		
		otpVerificationRepository.save(otpVerification);
		
		emailService.sendOtpEmail(email, otp);
		
		
	}

	@Override
	public void verifyOtp(String email, String otp) {
		
		OtpVerification otpVerification = otpVerificationRepository.findTopByEmailOrderByIdDesc(email)
				.orElseThrow(() -> new RuntimeException("No OTP found for the provided email."));
		
		if(otpVerification.isVerified()) {
			
			throw new RuntimeException("OTP has already been verified.");
			
		}
		
		if(LocalDateTime.now().isAfter(otpVerification.getExpires())) {
			
			throw new RuntimeException("OTP has expired.");
			
		}
		
		if(!otpVerification.getOtp().equals(otp)) {
			
			throw new RuntimeException("Invalid OTP.");
			
		}
		
		otpVerification.setVerified(true);
		
		otpVerificationRepository.save(otpVerification);
		
	}

}
