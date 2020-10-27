package com.example.demo.service;

import com.example.demo.manager.CurrenciesManager;
import com.example.demo.model.table.TableCurrencyDTO;
import com.example.demo.model.table.TableRates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableOfCurrenciesService {

    private final CurrenciesManager currenciesManager;

    @Autowired
    public TableOfCurrenciesService(CurrenciesManager currenciesManager) {
        this.currenciesManager = currenciesManager;
    }


    public TableCurrencyDTO getTableOfCurrencies(String table) {
        return currenciesManager.getEntireTable(table);
    }

    public List<TableRates> getTableRates(String table) {
        return currenciesManager.getRates(table);
    }

}
