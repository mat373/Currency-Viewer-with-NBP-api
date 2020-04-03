package com.example.demo.model.currency;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Rate {
    private String no;
    private String effectiveDate;
    private double mid;

    public BigDecimal getMid() {
        return BigDecimal.valueOf(mid);
    }
}
