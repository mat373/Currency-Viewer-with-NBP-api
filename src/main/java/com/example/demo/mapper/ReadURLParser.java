package com.example.demo.mapper;

import com.example.demo.exceptions.NbpApiClientException;
import com.example.demo.model.currency.Currency;

import com.example.demo.model.table.TableCurrency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ReadURLParser {

    private RestTemplate restTemplate;

    @Autowired
    public ReadURLParser(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Currency getSingleCurrencyFromTable(String url) throws HttpClientErrorException.NotFound {
        try {
            ResponseEntity<Currency> currencyResponseEntity = restTemplate.getForEntity(url, Currency.class);
            return currencyResponseEntity.getBody();
        } catch (NbpApiClientException e) {
            throw new NbpApiClientException();
        }
    }

    public TableCurrency[] getTableAOfCurrency(String url) {
        try {
            ResponseEntity<TableCurrency[]> tableCurrencyResponseEntity = restTemplate.getForEntity(url, TableCurrency[].class);
            return tableCurrencyResponseEntity.getBody();
        } catch (NbpApiClientException e) {
            throw new NbpApiClientException();
        }
    }

}
