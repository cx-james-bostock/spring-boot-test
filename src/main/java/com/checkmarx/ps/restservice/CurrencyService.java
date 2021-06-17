package com.checkmarx.ps.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CurrencyService {
    private CurrencyDataRepository currencyDataRepository;

    public List<CurrencyDetails> getCurrencyDetails() {
	return currencyDataRepository.getCurrencyDetails();
    }

    @Autowired
    public void setCurrencyDataRepository(CurrencyDataRepository currencyDataRepository) {
	this.currencyDataRepository = currencyDataRepository;
    }
}
