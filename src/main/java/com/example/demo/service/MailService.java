package com.example.demo.service;

import com.example.demo.model.request.MailRequest;
import com.example.demo.model.response.ResponseApi;
import org.springframework.http.ResponseEntity;

public interface MailService {
    void sendTextMessage(MailRequest mailRequest);

    ResponseEntity<ResponseApi<?>> sendCustomMessageWithAttachment(MailRequest mailRequest);
}
