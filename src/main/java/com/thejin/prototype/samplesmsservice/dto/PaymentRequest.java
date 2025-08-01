package com.thejin.prototype.samplesmsservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequest {
    
    @JsonProperty("mobile")
    private String mobile;
    
    @JsonProperty("amount")
    private Double amount;
    
    @JsonProperty("reference")
    private String reference;
    
    public PaymentRequest() {}
    
    public PaymentRequest(String mobile, Double amount, String reference) {
        this.mobile = mobile;
        this.amount = amount;
        this.reference = reference;
    }
    
    public String getMobile() {
        return mobile;
    }
    
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    public Double getAmount() {
        return amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    
    public String getReference() {
        return reference;
    }
    
    public void setReference(String reference) {
        this.reference = reference;
    }
}