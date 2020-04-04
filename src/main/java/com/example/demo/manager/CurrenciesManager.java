package com.example.demo.manager;

import com.example.demo.mapper.ReadURLParser;
import com.example.demo.mapper.SingleCurrencyMapper;
import com.example.demo.mapper.TableOfCurrenciesMapper;
import com.example.demo.model.currency.Currency;
import com.example.demo.model.currency.CurrencyDTO;
import com.example.demo.model.table.TableCurrency;
import com.example.demo.model.table.TableCurrencyDTO;
import com.example.demo.model.table.TableRates;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@NoArgsConstructor
@Component
public class CurrenciesManager {

    private static final String GET_TABLE_OF_CURRENCIES = "http://api.nbp.pl/api/exchangerates/tables/"; // + {table}
    private static final String SINGLE_CURRENCY = "http://api.nbp.pl/api/exchangerates/rates/";   // +  {table}/{code}


    private SingleCurrencyMapper singleCurrencyMapper = new SingleCurrencyMapper();
    private ReadURLParser readURLParser;

    @Autowired
    public CurrenciesManager(ReadURLParser readURLParser) {
        this.readURLParser = readURLParser;
    }


//      ********** ********** ********** ********** TABLE ********** ********** ********** **********

    public TableCurrencyDTO getEntireTable(String table) {
        return readEntireTable(table);
    }

    public List<TableRates> getRates(String table) {
        return getTableRates(table);
    }


//      ********** ********** ********** ********** SINGLE_CURRENCY ********** ********** ********** **********

    public CurrencyDTO getCurrency(String table, String code, String date) {
        CurrencyDTO currencyDTO = readCurrency(table, code, date);
        currencyDTO.setCodesAndNames(getMapOfNamesAndCodes(table));
        return currencyDTO;
    }

    public CurrencyDTO getCurrencyFromTableAWithPeriodOfTime(String table, String code, String startDate, String endDate) {
        return readCurrenciesWithDates(table, code, startDate, endDate);
    }


    //      ********** ********** ********** ********** SINGLE_CURRENCY PRIVATE METHODS ********** ********** ********** **********

    private CurrencyDTO readCurrency(String table, String code, String date) {
        Currency currency = readURLParser.getSingleCurrencyFromTable(SINGLE_CURRENCY + table + "/" + code + "/" + date);
        return singleCurrencyMapper.currencyToDTO(currency);
    }

    private CurrencyDTO readCurrenciesWithDates(String table, String code, String startDate, String endDate) {
        Currency currency = readURLParser.getSingleCurrencyFromTable(SINGLE_CURRENCY + table + "/" + code + "/" + startDate + "/" + endDate);
        return singleCurrencyMapper.currencyToDTO(currency);
    }

    private Map<String, String> getMapOfNamesAndCodes(String table) {
        List<TableRates> tableRates = getTableRates(table);
        Map<String, String> map = new HashMap<>();
        for (TableRates rates : tableRates) {
            map.put(rates.getCode(), rates.getCurrency());
        }
        return map;
    }

//          ********** ********** ********** ********** TABLE PRIVATE METHODS ********** ********** ********** **********


    private List<TableRates> getTableRates(String table) {
        TableCurrencyDTO tableCurrencyDTO = readEntireTable(table);
        return listOfRatesOnly(tableCurrencyDTO);
    }

    private TableCurrencyDTO readEntireTable(String table) {
        TableOfCurrenciesMapper tableOfCurrenciesMapper = new TableOfCurrenciesMapper();
        TableCurrency[] tableCurrency = readURLParser.getTableAOfCurrency(GET_TABLE_OF_CURRENCIES + table);
        return tableOfCurrenciesMapper.tableOfCurrencyToDTO(tableCurrency);
    }

    private List<TableRates> listOfRatesOnly(TableCurrencyDTO tableCurrencyDTO) {
        List<List<TableRates>> rates = new ArrayList<>();
        rates.add(tableCurrencyDTO.getRates());
        return new ArrayList<>(rates.get(0));
    }
}
