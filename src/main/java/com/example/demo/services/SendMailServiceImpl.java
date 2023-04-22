package com.example.demo.services;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.example.demo.models.SendMailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

/**
 * @author YoussefMahmoud
 * @created Apr 22, 2023-3:57:32 AM
 */

@Service
public class SendMailServiceImpl implements SendMailService {

	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}")
	private String sender;

	public String sendMail(SendMailRequest sendMailRequest) {
		try {
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(sender);
			simpleMailMessage.setTo(sendMailRequest.getRecipient());
			simpleMailMessage.setSubject(sendMailRequest.getSubject());
			simpleMailMessage.setText(sendMailRequest.getMessageBody());
			javaMailSender.send(simpleMailMessage);
			return "Mail sent successfully.";
		} catch (Exception e) {
			return "Error while sending mail.";
		}
	}

	public String sendMailWithAttachment(SendMailRequest sendMailRequest) {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper;
		try {
			mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
			mimeMessageHelper.setFrom(sender);
			mimeMessageHelper.setTo(sendMailRequest.getRecipient());
			mimeMessageHelper.setSubject(sendMailRequest.getSubject());
			mimeMessageHelper.setText(sendMailRequest.getMessageBody());
			FileSystemResource file = new FileSystemResource(new File(sendMailRequest.getAttachment()));
			mimeMessageHelper.addAttachment(file.getFilename(), file);
			javaMailSender.send(mimeMessage);
			return "Mail sent successfully.";
		} catch (MessagingException e) {
			return "Error while sending mail.";
		}
	}
	
}