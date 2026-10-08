package com.java.mailSender.otpcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.mailSender.service.OtpService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/otp")
public class OtpController {
	
	@Autowired
	private final OtpService otpService;
	
	@PostMapping("/send")
	public ResponseEntity<String> sendOtp(@RequestParam String email)
	{
		
		otpService.generateAndSendotp(email);
		return ResponseEntity.ok("OTP sent successfully to " + email);
	}
	
	@PostMapping("/verify")
	public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp)
	{
		
		otpService.verifyOtp(email, otp);
		return ResponseEntity.ok("OTP verified successfully for " + email);
	}
	
	

}
