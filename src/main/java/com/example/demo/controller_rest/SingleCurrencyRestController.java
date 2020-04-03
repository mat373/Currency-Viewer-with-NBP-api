package com.example.demo.controller_rest;

import com.example.demo.exceptions.NbpApiClientException;
import com.example.demo.model.currency.CurrencyDTO;
import com.example.demo.service.SingleCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Date;

@RestController
@RequestMapping("/api/")
public class SingleCurrencyRestController {

    private SingleCurrencyService singleCurrencyService;
    private Date today = new Date();
    private String format = "yyyy-MM-dd";

    @Autowired
    public SingleCurrencyRestController(SingleCurrencyService singleCurrencyService) {
        this.singleCurrencyService = singleCurrencyService;
    }



    @GetMapping("/{table}/{code}/{date}")
    public ResponseEntity<CurrencyDTO> getSingleCurrencyByDate(@PathVariable String code,
                                                               @PathVariable(name = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String strDate,
                                                               @PathVariable String table) {

        try {
            Date date = new SimpleDateFormat(format).parse(strDate);
            if (date.after(today)) {
                throw new DateTimeException("Date cannot be after " + today);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (code.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CurrencyDTO currency = singleCurrencyService.getCurrency(table, code, strDate);
        return ResponseEntity.ok(currency);
    }

    @GetMapping("/{table}/{code}/{startDate}/{endDate}")
    public ResponseEntity<CurrencyDTO> getCurrenciesWithPeriodOfDate(@PathVariable String code,
                                                                     @PathVariable(name = "startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
                                                                     @PathVariable(name = "endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate,
                                                                     @PathVariable String table){
        try{
            Date start = new SimpleDateFormat(format).parse(startDate);
            Date end = new SimpleDateFormat(format).parse(endDate);
            if (start.after(today) || end.after(today) || start.after(end)){
                throw new DateTimeException("Date cannot be after " + today + " or start date cannot be after end date");
            }
        }catch (ParseException e){
            e.printStackTrace();
        }
        if (code.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        CurrencyDTO currency = singleCurrencyService.getCurrencyWithPeriodOTime(table, code, startDate, endDate);
        return ResponseEntity.ok(currency);

    }
}
