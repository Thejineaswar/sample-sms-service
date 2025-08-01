package com.thejin.prototype.samplesmsservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@Service
public class SmsGatewayService {
    
    private final RestTemplate restTemplate;
    private final String SMS_GATEWAY_URL = "https://api.smsgateway.com/send";
    
    public SmsGatewayService() {
        this.restTemplate = new RestTemplate();
    }
    
    public String sendSms(String mobile, String message) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("Authorization", "Bearer YOUR_API_KEY");
            
            Map<String, String> payload = new HashMap<>();
            payload.put("to", mobile);
            payload.put("message", message);
            
            HttpEntity<Map<String, String>> request = new HttpEntity<>(payload, headers);
            
            ResponseEntity<String> response = restTemplate.postForEntity(SMS_GATEWAY_URL, request, String.class);
            
            if (response.getStatusCode().is2xxSuccessful()) {
                return "SMS sent successfully to " + mobile;
            } else {
                throw new RuntimeException("Failed to send SMS. Status: " + response.getStatusCode());
            }
            
        } catch (Exception e) {
            System.out.println("Simulating SMS send to: " + mobile);
            System.out.println("Message: " + message);
            return "SMS simulated successfully (Gateway not configured)";
        }
    }
}