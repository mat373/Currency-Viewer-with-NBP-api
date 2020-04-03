package com.example.demo.mapper;

import com.example.demo.model.currency.Currency;
import com.example.demo.model.currency.CurrencyDTO;

public class SingleCurrencyMapper {

    public CurrencyDTO currencyToDTO(Currency currency){
        CurrencyDTO dto = new CurrencyDTO();
        dto.setTable(currency.getTable());
        dto.setCurrency(currency.getCurrency());
        dto.setCode(currency.getCode());
        dto.setRates(currency.getRates());
        return dto;
    }

}
