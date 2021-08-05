package com.checkmarx.ps.restservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UnsafeObjectBindingRepository extends JpaRepository<UnsafeObjectBindingData, Long> {
    public UnsafeObjectBindingData save(UnsafeObjectBindingData userAuditLogin);
}
