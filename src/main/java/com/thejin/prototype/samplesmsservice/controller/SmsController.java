package com.thejin.prototype.samplesmsservice.controller;

import com.thejin.prototype.samplesmsservice.dto.PaymentRequest;
import com.thejin.prototype.samplesmsservice.service.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sms")
public class SmsController {
    
    @Autowired
    private SmsService smsService;
    
    @PostMapping("/send-payment-notification")
    public ResponseEntity<String> sendPaymentNotification(@RequestBody PaymentRequest request) {
        try {
            String result = smsService.sendPaymentSms(request);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error sending SMS: " + e.getMessage());
        }
    }
}