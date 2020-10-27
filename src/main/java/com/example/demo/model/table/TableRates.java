package com.example.demo.model.table;


import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@NoArgsConstructor
public class TableRates {
    private String currency;
    private String code;
    private double mid;

    public BigDecimal getMid() {
        return BigDecimal.valueOf(mid);
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }
}
