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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Component
public class CurrenciesManager {

    private static final String GET_TABLE_OF_CURRENCIES = "http://api.nbp.pl/api/exchangerates/tables/"; // + {table}
    private static final String SINGLE_CURRENCY = "http://api.nbp.pl/api/exchangerates/rates/";   // +  {table}/{code}

    private String format = "yyyy-MM-dd";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

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

    public List<String> getNames(String table) {
        List<TableRates> tableRates = getTableRates(table);
        List<String> codes = new ArrayList<>();
        for (TableRates tableRate : tableRates) {
            codes.add(tableRate.getCurrency());
        }
        return codes;
    }

//      ********** ********** ********** ********** SINGLE_CURRENCY ********** ********** ********** **********

    public CurrencyDTO getCurrency(String table, String code, String date) {
            return readCurrency(table, code, date);

    }

    public CurrencyDTO getCurrencyFromTableAWithPeriodOfTime(String table, String code, String startDate, String endDate) {
        return readCurrenciesWithDates(table, code, startDate, endDate);
    }


    //      ********** ********** ********** ********** SINGLE_CURRENCY PRIVATE METHODS ********** ********** ********** **********

    private CurrencyDTO readCurrency(String table, String code, String date) {
        SingleCurrencyMapper singleCurrencyMapper = new SingleCurrencyMapper();
        if(date == null){
            date = LocalDateTime.now().format(dateTimeFormatter);
        }
        Currency currency = readURLParser.getSingleCurrencyFromTable(SINGLE_CURRENCY + table + "/" + code + "/" + date);
        return singleCurrencyMapper.currencyToDTO(currency);
    }

    private CurrencyDTO readCurrenciesWithDates(String table, String code, String startDate, String  endDate) {
        SingleCurrencyMapper singleCurrencyMapper = new SingleCurrencyMapper();
        Currency currency = readURLParser.getSingleCurrencyFromTable(SINGLE_CURRENCY + table + "/" + code + "/" + startDate + "/" + endDate);
        return singleCurrencyMapper.currencyToDTO(currency);
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
