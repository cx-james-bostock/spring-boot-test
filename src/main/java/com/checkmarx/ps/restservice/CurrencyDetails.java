package com.checkmarx.ps.restservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDetails {
    private Long id;
    private String currencyName;
}
