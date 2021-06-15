package com.checkmarx.ps.restservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CurrencyController {
    private CurrencyDataRepository currencyDataRepository;

    @GetMapping("/currency")
    public CurrencyDetails getCurrencyDetails() {
	List<CurrencyDetails> currencyDetailsList = currencyDataRepository.getCurrencyDetails();
	return currencyDetailsList.get(0);
    }

    @Autowired
    public void setCurrencyDataRepository(CurrencyDataRepository currencyDataRepository) {
	this.currencyDataRepository = currencyDataRepository;
    }
}