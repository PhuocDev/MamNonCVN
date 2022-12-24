package com.example.mamnoncvn.mailSender;

import org.springframework.stereotype.Service;

@Service
public interface EmailService {
    // Method
    // To send a simple email
    String sendSimpleMail(Mail details);

    // Method
    // To send an email with attachment
    //String sendMailWithAttachment(Mail details);
}
