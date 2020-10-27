package com.example.demo.model.currency;

import lombok.Getter;

import java.math.BigDecimal;


public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;

    public BigDecimal getMid() {
        return BigDecimal.valueOf(mid);
    }

    public String getNo() {
        return no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }
}
