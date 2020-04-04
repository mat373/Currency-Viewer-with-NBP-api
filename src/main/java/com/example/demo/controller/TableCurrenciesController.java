package com.example.demo.controller;

import com.example.demo.model.table.TableCurrencyDTO;
import com.example.demo.model.table.TableRates;
import com.example.demo.service.TableOfCurrenciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/table")
public class TableCurrenciesController {

    private TableOfCurrenciesService tableOfCurrenciesService;

    @Autowired
    public TableCurrenciesController(TableOfCurrenciesService tableOfCurrenciesService) {
        this.tableOfCurrenciesService = tableOfCurrenciesService;
    }

    @GetMapping("/{table}")
    public String getTable(@PathVariable String table, Model model) {
        TableCurrencyDTO tableCurrencyDTO = tableOfCurrenciesService.getTableOfCurrencies(table);
        List<TableRates> ratesList = tableOfCurrenciesService.getTableRates(table);
        model.addAttribute("tableCurrencyDTO", tableCurrencyDTO);
        model.addAttribute("ratesList", ratesList);
        return "tableCurrencies";
    }

}
