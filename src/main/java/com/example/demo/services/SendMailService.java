package com.example.demo.services;

import com.example.demo.models.SendMailRequest;

/**
 * @author YoussefMahmoud
 * @created Apr 22, 2023-3:52:12 AM
 */

public interface SendMailService {
	String sendMail(SendMailRequest sendMailRequest);
	String sendMailWithAttachment(SendMailRequest sendMailRequest);
}