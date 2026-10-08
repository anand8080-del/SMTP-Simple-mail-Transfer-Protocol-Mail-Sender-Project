package com.java.mailSender.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.mailSender.entity.OtpVerification;

public interface OtpVerificationRepository extends JpaRepository<OtpVerification, Integer> {
	
	Optional<OtpVerification> findTopByEmailOrderByIdDesc(String email);

}
