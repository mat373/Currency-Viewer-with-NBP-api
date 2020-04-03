package com.example.demo.model.table;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class TableRates {
    private String currency;
    private String code;
    private double mid;

    public BigDecimal getMid() {
        return BigDecimal.valueOf(mid);
    }
}
