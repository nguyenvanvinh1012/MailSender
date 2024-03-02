package com.example.mailsender;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

@Service
public class MailSenderService {
    @Autowired
    private JavaMailSender mailSender;
    public void sendEmail(String toEmail, String subject, String body) throws MessagingException, UnsupportedEncodingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("nguyenvanvinhisco22@gmail.com");
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body, true);
        mailSender.send(message);
        System.out.println("Mail send successfully...");
    }
}
