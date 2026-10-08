package com.java.mailSender.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OtpVerification {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer id;
	private String email;
	private String otp;
	private static LocalDateTime expires;
	private boolean verified;
	
	
	public static LocalDateTime getExpires() {
		return expires;
	}
	public static void setExpires(LocalDateTime expires) {
		OtpVerification.expires = expires;
	}
	
	
	

}
