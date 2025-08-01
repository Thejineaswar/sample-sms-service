package com.thejin.prototype.samplesmsservice.service;

import com.thejin.prototype.samplesmsservice.dto.PaymentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    
    @Autowired
    private SmsGatewayService smsGatewayService;
    
    public String sendPaymentSms(PaymentRequest request) {
        String message = formatPaymentMessage(request);
        return smsGatewayService.sendSms(request.getMobile(), message);
    }
    
    private String formatPaymentMessage(PaymentRequest request) {
        return String.format("Your account has been debited with %s with reference no %s", 
                           request.getAmount(), request.getReference());
    }
}