package com.checkmarx.ps.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {
    private CurrencyService currencyService;

    @GetMapping("/currency")
    public CurrencyDetails getCurrencyDetails() {
	List<CurrencyDetails> currencyDetailsList = currencyService.getCurrencyDetails();
	return currencyDetailsList.get(0);
    }

    @Autowired
    public void setCurrencyDataRepository(CurrencyService currencyService) {
	this.currencyService = currencyService;
    }
}