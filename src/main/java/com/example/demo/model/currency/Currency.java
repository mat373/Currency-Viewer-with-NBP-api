package com.example.demo.model.currency;

import lombok.Getter;


import java.util.List;

@Getter
public class Currency {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;


}
