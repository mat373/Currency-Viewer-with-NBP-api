package com.example.demo.service;


import com.example.demo.manager.CurrenciesManager;
import com.example.demo.model.currency.CurrencyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
public class SingleCurrencyService {

    private CurrenciesManager currenciesManager;

    @Autowired
    public SingleCurrencyService(CurrenciesManager currenciesManager) {
        this.currenciesManager = currenciesManager;
    }

    public CurrencyDTO getCurrency(String table, String code, String date) {
        return currenciesManager.getCurrency(table, code, date);
    }

    public CurrencyDTO getCurrencyWithPeriodOTime(String table, String code, String startDate, String endDate) {
        return currenciesManager.getCurrencyFromTableAWithPeriodOfTime(table, code, startDate, endDate);
    }
}


