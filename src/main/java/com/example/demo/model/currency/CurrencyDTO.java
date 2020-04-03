package com.example.demo.model.currency;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class CurrencyDTO {

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;
    private Map<String, String> codesAndNames;

}
