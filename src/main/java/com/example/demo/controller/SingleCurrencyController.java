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


    private final String format = "yyyy-MM-dd";
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(format);

    private final SingleCurrencyService singleCurrencyService;

    @Autowired
    public SingleCurrencyController(SingleCurrencyService singleCurrencyService) {
        this.singleCurrencyService = singleCurrencyService;
    }

    @GetMapping("/{table}/{code}/{date}")
    public String getCurrency(@PathVariable String table, @PathVariable String code, @PathVariable String date, Model model){
        if (date == null){
            date = LocalDate.now().format(dateTimeFormatter);
        }
        CurrencyDTO currencyDTO = singleCurrencyService.getCurrency(table,code,date);

        model.addAttribute("currencyDTO", currencyDTO);
        return "singleCurrency";

    }

}
