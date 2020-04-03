package com.example.demo.controller;

import com.example.demo.model.currency.CurrencyDTO;
import com.example.demo.service.SingleCurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class SingleCurrencyController {


    private String format = "yyyy-MM-dd";
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

    private SingleCurrencyService singleCurrencyService;

    @Autowired
    public SingleCurrencyController(SingleCurrencyService singleCurrencyService) {
        this.singleCurrencyService = singleCurrencyService;
    }

    @RequestMapping(value = "/currency")
    public String getCurrency(@RequestParam(value = "code", defaultValue = "eur") String code,
                              @RequestParam(value = "table", defaultValue = "a") String table,
                              @RequestParam(value = "date", defaultValue = "last", required = false) String date,
                              Model model) {
        if (date == null)
            date = LocalDate.now().format(dateTimeFormatter);

        CurrencyDTO currencyDTO = singleCurrencyService.getCurrency(table, code, date);

        model.addAttribute("currencyDTO", currencyDTO);

        return "singleCurrency";
    }
}
