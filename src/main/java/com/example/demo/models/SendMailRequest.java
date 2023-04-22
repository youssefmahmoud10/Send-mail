package com.example.demo.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * @author YoussefMahmoud
 * @created Apr 22, 2023-3:44:42 AM
 */

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SendMailRequest {

	String recipient;
	String subject;
	String messageBody;
	String attachment;

}