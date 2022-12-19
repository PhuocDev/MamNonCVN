package com.example.mamnoncvn.mailSender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Annotations
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail {
    // Class data members
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
