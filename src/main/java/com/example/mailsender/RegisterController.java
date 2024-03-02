package com.example.mailsender;

import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;

@Controller
public class RegisterController {
    @Autowired
    MailSenderService mailSenderService;

    @GetMapping("/")
    public String registerForm(){

        return "register";
    }
    @PostMapping("/sendEmail")
    public String postForm(@RequestParam("fullname") String fullName, @RequestParam("address") String address,
                           @RequestParam("phoneno")String SDT) throws MessagingException, UnsupportedEncodingException {
        String body = "<h2>Thông tin đăng ký:</h2>" +
                "<p><strong>Họ và tên:</strong> " + fullName + "</p>" +
                "<p><strong>Địa chỉ:</strong> " + address + "</p>" +
                "<p><strong>Số điện thoại:</strong> " + SDT + "</p>";
        mailSenderService.sendEmail("nguyenvanvinhisco22@gmail.com", "Infomation form register form", body);
        return "success";
    }
}
