package com.example.demo.model.currency;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
public class CurrencyDTO {

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
    private Map<String, String> codesAndNames;

    public String getTable() {
        return table;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCode() {
        return code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public Map<String, String> getCodesAndNames() {
        return codesAndNames;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public void setCodesAndNames(Map<String, String> codesAndNames) {
        this.codesAndNames = codesAndNames;
    }
}
