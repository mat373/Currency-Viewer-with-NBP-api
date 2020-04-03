package com.example.demo.controller;

import com.example.demo.model.currency.CurrencyDTO;
import com.example.demo.service.SingleCurrencyService;
import com.example.demo.service.TableOfCurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;

@Controller
public class SingleCurrencyController {

    private SingleCurrencyService singleCurrencyService;

    @Autowired
    public SingleCurrencyController(SingleCurrencyService singleCurrencyService) {
        this.singleCurrencyService = singleCurrencyService;
    }

    @GetMapping("/{table}/{code}/{date}")
    public String getCurrency(@PathVariable(name = "code") String code,
                              @PathVariable(name = "table") String table,
                              @PathVariable(required = false)@DateTimeFormat(pattern = "yyyy-MM-dd") String date,
                              Model model) {

        if(date == null) {
            date = LocalDateTime.now().toString();
        }
        CurrencyDTO currencyDTO = singleCurrencyService.getCurrency(table, code, date);

        model.addAttribute("currencyDTO", currencyDTO);
        return "singleCurrency";
    }
}
