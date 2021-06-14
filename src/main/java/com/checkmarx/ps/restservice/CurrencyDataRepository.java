package com.checkmarx.ps.restservice;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CurrencyDataRepository extends JpaRepository<CurrencyDetails, String> {
    @Query(value = "SELECT id, currency_name FROM currency_details WHERE status = 'A'", nativeQuery = true)
    List<CurrencyDetails> getCurrencyDetails();
}
