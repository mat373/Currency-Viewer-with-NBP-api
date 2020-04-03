package com.example.demo.model.table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TableCurrencyDTO {
    private String table;
    private String no;
    private String effectiveDate;
    private List<TableRates> rates;

}
