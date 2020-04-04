package com.example.demo.mapper;

import com.example.demo.model.table.TableCurrency;
import com.example.demo.model.table.TableCurrencyDTO;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class TableOfCurrenciesMapper {

    public TableCurrencyDTO tableOfCurrencyToDTO(TableCurrency[] tableCurrency) {
        List<TableCurrency> tableCurrencyList = parseToList(tableCurrency);
        TableCurrencyDTO dto = new TableCurrencyDTO();
        dto.setTable(tableCurrencyList.get(0).getTable());
        dto.setNo(tableCurrencyList.get(0).getNo());
        dto.setEffectiveDate(tableCurrencyList.get(0).getEffectiveDate());
        dto.setRates(tableCurrencyList.get(0).getRates());
        return dto;
    }


    private List<TableCurrency> parseToList(TableCurrency[] tableCurrencies) {
        return Arrays.asList(Objects.requireNonNull(tableCurrencies));
    }
}


