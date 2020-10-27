package com.example.demo.model.table;

import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
public class TableCurrencyDTO {
    private String table;
    private String no;
    private String effectiveDate;
    private List<TableRates> rates;

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public List<TableRates> getRates() {
        return rates;
    }

    public void setRates(List<TableRates> rates) {
        this.rates = rates;
    }
}
