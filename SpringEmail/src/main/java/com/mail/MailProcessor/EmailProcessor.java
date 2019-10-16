package com.mail.MailProcessor;

import java.util.Date;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.springmvc.user.UserInfo;

public class EmailProcessor {
	
	private MailSender sender;

	public void setSender(MailSender sender) {
		this.sender = sender;
	}
	
	public String sendEmail(UserInfo u)
	{
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(u.getTo());
		message.setSubject(u.getSub());
		message.setSentDate(new Date());
		message.setText(u.getMessage());
		
		sender.send(message);
		
		return "Mail Sent!";
	}

}
