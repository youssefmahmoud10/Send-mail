package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.SendMailRequest;
import com.example.demo.services.SendMailService;

/**
 * @author YoussefMahmoud
 * @created Apr 22, 2023-3:47:49 AM
 */

@RestController
@RequestMapping("/sendMailController") //http://localhost:8080/sendMailController/sendMail
public class SendMailController {

	@Autowired
	private SendMailService sendMailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody SendMailRequest sendMailRequest) {
		return sendMailService.sendMail(sendMailRequest);
	}

	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody SendMailRequest sendMailRequest) {
		return sendMailService.sendMailWithAttachment(sendMailRequest);
	}

}