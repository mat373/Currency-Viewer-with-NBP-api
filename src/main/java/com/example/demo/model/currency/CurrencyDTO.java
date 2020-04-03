package com.example.demo.model.currency;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CurrencyDTO {

    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

}
